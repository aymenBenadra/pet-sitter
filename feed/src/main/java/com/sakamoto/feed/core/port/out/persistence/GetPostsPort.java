package com.sakamoto.feed.core.port.out.persistence;

import comm.sakamoto.common.model.PostEntity;
import comm.sakamoto.common.model.PostStatus;

import java.util.List;

public interface GetPostsPort {
    List<PostEntity> getAllPosts();

    List<PostEntity> getPostsByStatus(PostStatus status);

    List<PostEntity> getPostsByUserId(Long userId);

    List<PostEntity> getPostsByUserIdAndStatus(Long userId, PostStatus status);

    PostEntity getPostById(Long id) throws PostNotFoundException;

}
