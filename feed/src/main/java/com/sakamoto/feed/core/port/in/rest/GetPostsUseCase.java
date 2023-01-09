package com.sakamoto.feed.core.port.in.rest;

import comm.sakamoto.common.model.PostStatus;

import java.util.List;

public interface GetPostsUseCase {
    List<PostDTO> getAllPosts();

    List<PostDTO> getPostsByUserId(Long userId);

    List<PostDTO> getPostsByStatus(PostStatus status);

    List<PostDTO> getPostsByUserIdAndStatus(Long userId, PostStatus status);

    PostDTO getPostById(Long id);
}
