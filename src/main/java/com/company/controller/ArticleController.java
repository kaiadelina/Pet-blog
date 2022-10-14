package com.company.controller;

import com.company.model.Article;
import com.company.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping(value = "/")
    public List<Article> getArticles() {
        return articleService.getArticles();
    }
}
