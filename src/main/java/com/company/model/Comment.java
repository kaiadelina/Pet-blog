package com.company.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "article_id")
    private Article article;

    @Transient
    private Integer articleId;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    private String text;

    @Column(insertable = false, name = "created_at")
    private LocalDateTime createdAt;
}
