package com.sakamoto.feed.core.service;

import com.sakamoto.feed.core.port.in.rest.ManagePostsUseCase;
import com.sakamoto.feed.core.port.in.rest.PostCommand;
import com.sakamoto.feed.core.port.in.rest.PostDTO;
import com.sakamoto.feed.core.port.out.persistence.GetPostsPort;
import com.sakamoto.feed.core.port.out.persistence.ManagePostsPort;
import com.sakamoto.feed.domain.Post;
import com.sakamoto.feed.utils.PostMapper;
import comm.sakamoto.common.annotation.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class PostsService implements ManagePostsUseCase {

    private final GetPostsPort getPostsPort;
    private final ManagePostsPort managePostsPort;
    private final PostMapper postMapper;

    @Override
    public PostDTO createPost(PostCommand command) {
        return postMapper.toDTO(managePostsPort.createPost(postMapper.toDomain(command)));
    }

    @Override
    public PostDTO updatePost(Long id, PostCommand command) {
        Post post = postMapper.toDomain(getPostsPort.getPostById(id));
        return postMapper.toDTO(managePostsPort.updatePost(postMapper.toDomain(command, post)));
    }

    @Override
    public void closePost(Long id) {
        Post post = postMapper.toDomain(getPostsPort.getPostById(id));
        post.close();
        managePostsPort.updatePost(post);
    }

    @Override
    public void deletePost(Long id) {
        managePostsPort.deletePost(id);
    }
}
