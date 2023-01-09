package com.sakamoto.feed.core.service;

import com.sakamoto.feed.core.port.in.rest.GetPostsUseCase;
import com.sakamoto.feed.core.port.in.rest.PostDTO;
import com.sakamoto.feed.core.port.out.persistence.GetPostsPort;
import com.sakamoto.feed.utils.PostMapper;
import comm.sakamoto.common.annotation.UseCase;
import comm.sakamoto.common.model.PostStatus;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class FeedService implements GetPostsUseCase {

    private final GetPostsPort getPostsPort;
    private final PostMapper postMapper;

    @Override
    public List<PostDTO> getAllPosts() {
        return getPostsPort.getAllPosts().stream().map(postMapper::toDTO).toList();
    }

    @Override
    public List<PostDTO> getPostsByUserId(Long userId) {
        return getPostsPort.getPostsByUserId(userId).stream().map(postMapper::toDTO).toList();
    }

    @Override
    public List<PostDTO> getPostsByStatus(PostStatus status) {
        return getPostsPort.getPostsByStatus(status).stream().map(postMapper::toDTO).toList();
    }

    @Override
    public List<PostDTO> getPostsByUserIdAndStatus(Long userId, PostStatus status) {
        return getPostsPort.getPostsByUserIdAndStatus(userId, status).stream().map(postMapper::toDTO).toList();
    }

    @Override
    public PostDTO getPostById(Long id) {
        return postMapper.toDTO(getPostsPort.getPostById(id));
    }
}
