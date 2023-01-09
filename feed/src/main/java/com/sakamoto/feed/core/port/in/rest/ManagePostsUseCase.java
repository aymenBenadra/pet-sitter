package com.sakamoto.feed.core.port.in.rest;

public interface ManagePostsUseCase {
    PostDTO createPost(PostCommand command);

    PostDTO updatePost(Long id, PostCommand command);

    void closePost(Long id);

    void deletePost(Long id);
}
