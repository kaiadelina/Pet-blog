package com.company.service;

import com.company.model.Comment;
import com.company.repository.ArticleRepository;
import com.company.repository.CommentRepository;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    UserRepository userRepository;

    public Comment saveComment(Comment comment) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        comment.setAuthor(userRepository.findByNickname(username));
        comment.setArticle(articleRepository.findArticleById(comment.getArticleId()));
        return commentRepository.save(comment);
    }
}
