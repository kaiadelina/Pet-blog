
INSERT INTO users (nickname, password, created_at)
VALUES ( 'test', '$2a$10$TGNcu20u9WyTjGPF6fPPyuokMuij4dbmsmzVHkUvRYRIIsOhePFYe', CURRENT_TIMESTAMP);

INSERT INTO articles ( title,  text, created_at, author_id)
VALUES ( 'Dikson', 'My best friend.', CURRENT_TIMESTAMP, 1);

ALTER TABLE articles
    ADD FOREIGN KEY (author_id)
        REFERENCES users(id);

INSERT INTO comments (text, created_at, article_id, author_id)
VALUES ( 'wauuu', CURRENT_TIMESTAMP, 1, 1);





