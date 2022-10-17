package com.company.service;

import com.company.model.Comment;
import com.company.repository.ArticleRepository;
import com.company.repository.CommentRepository;
import com.company.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import static com.company.TestUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CommentServiceTest {

    @InjectMocks
    private CommentService commentService;

    @Mock
    private CommentRepository commentRepository;

    @Mock
    private ArticleRepository articleRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private SecurityContext securityContext;

    @Mock
    private Authentication authentication;

    @BeforeEach
    public void mockAuth() {
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        when(authentication.getName()).thenReturn("testUser");
    }

    @Test
    void saveComment() {
        Comment request = new Comment(null, null, 1, null, "comment text", null);

        when(commentRepository.save(any())).thenReturn(createComment());
        when(userRepository.findByNickname(any())).thenReturn(createUser());
        when(articleRepository.findArticleById(eq(1))).thenReturn(createArticle());

        Comment response = commentService.saveComment(request);

        assertEquals("comment text", response.getText());
        assertNotNull(response.getId());
        assertNotNull(response.getCreatedAt());
    }
}