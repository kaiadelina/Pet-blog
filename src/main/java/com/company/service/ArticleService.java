package com.company.service;

import com.company.DAO.ArticleRepository;
import com.company.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getArticles() {
        return articleRepository.findAll();
    }
}
