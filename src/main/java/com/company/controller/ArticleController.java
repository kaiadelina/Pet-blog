package com.company.controller;

import com.company.model.Article;
import com.company.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping(value = "/")
    public List<Article> getArticles() {
        return articleService.getArticles();
    }

    @GetMapping(value = "/article/{id}")
    public Article getArticle(@PathVariable int id) {
        return articleService.getArticleById(id);
    }

    @PostMapping(value = "/addArticle", consumes = {"application/json"})
    public Article addArticle(@RequestBody Article article) {
        return articleService.saveArticle(article);
    }
}
