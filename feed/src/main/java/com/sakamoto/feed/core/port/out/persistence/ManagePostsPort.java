package com.sakamoto.feed.core.port.out.persistence;

import com.sakamoto.feed.domain.Post;
import comm.sakamoto.common.model.PostEntity;

public interface ManagePostsPort {
    PostEntity createPost(Post post);

    PostEntity updatePost(Post post);

    void deletePost(Long id);
}
