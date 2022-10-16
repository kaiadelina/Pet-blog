package com.company.service;

import com.company.model.Article;
import com.company.repository.ArticleRepository;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getArticles() {
        return articleRepository.findAll();
    }
    public Article getArticleById(int id) {
        return articleRepository.findArticleById(id);
    }

    public Article saveArticle(Article article) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        article.setAuthor(userRepository.findByNickname(username));
        return articleRepository.save(article);
    }
}
