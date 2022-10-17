package com.company;

import com.company.model.Article;
import com.company.model.Comment;
import com.company.model.User;

import java.time.LocalDateTime;
import java.util.List;

public class TestUtils {

    public static List<Comment> createCommentsList() {
        return List.of(createComment(), createComment());
    }
    public static List<Article> createArticleList() {
        return List.of(createArticle(), createArticle());
    }

    public static Comment createComment() {
        return new Comment(1, null, null, createUser(), "comment text", LocalDateTime.now());
    }

    public static User createUser() {
        return new User(1, "Vasya", "1111", null, LocalDateTime.now());
    }

    public static Article createArticle() {
        return new Article(1, createUser(), "Title", "Text", LocalDateTime.now(), createCommentsList());
    }
}
