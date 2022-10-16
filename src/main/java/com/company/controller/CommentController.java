package com.company.controller;

import com.company.model.Comment;
import com.company.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping(value = "/addComment", consumes = {"application/json"})
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.saveComment(comment);
    }
}
