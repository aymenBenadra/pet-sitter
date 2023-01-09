package com.sakamoto.feed.adapter.out.persistence;

import comm.sakamoto.common.model.PostEntity;
import comm.sakamoto.common.model.PostStatus;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface PostRepository extends ListCrudRepository<PostEntity, Long> {
    List<PostEntity> findAllByStatus(PostStatus status);

    List<PostEntity> findAllByUserId(Long userId);

    List<PostEntity> findAllByUserIdAndStatus(Long userId, PostStatus status);
}
