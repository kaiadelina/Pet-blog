package com.company.service;

import com.company.model.Article;
import com.company.repository.ArticleRepository;
import com.company.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

import static com.company.TestUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks
    private ArticleService articleService;

    @Mock
    UserRepository userRepository;

    @Mock
    private ArticleRepository articleRepository;

    @Mock
    private Authentication authentication;

    @Mock
    private SecurityContext securityContext;

    public void mockAuth() {
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        when(authentication.getName()).thenReturn("testUser");
    }


    @Test
    void getArticlesTest() {
        when(articleRepository.findAll()).thenReturn(createArticleList());

        List<Article> response = articleService.getArticles();

        assertEquals(2, response.size());
    }

    @Test
    void getArticleByIdTest() {
        int id = 1;
        when(articleRepository.findArticleById(id)).thenReturn(createArticle());

        Article response = articleService.getArticleById(id);
        assertEquals(id, response.getId());
    }

    @Test
    void saveArticleTest() {
        Article request = new Article(null, null, "Title", "Text", null, null);

        when(articleRepository.save(any())).thenReturn(createArticle());
        when(userRepository.findByNickname(any())).thenReturn(createUser());
        mockAuth();

        Article response = articleService.saveArticle(request);

        assertEquals("Text", response.getText());
        assertEquals("Title", response.getTitle());
        assertNotNull(response.getId());
        assertNotNull(response.getCreatedAt());
    }
}