package com.sakamoto.feed.adapter.out.persistence;

import com.sakamoto.feed.core.port.out.persistence.GetPostsPort;
import com.sakamoto.feed.core.port.out.persistence.ManagePostsPort;
import com.sakamoto.feed.core.port.out.persistence.PostNotFoundException;
import com.sakamoto.feed.domain.Post;
import com.sakamoto.feed.utils.PostMapper;
import comm.sakamoto.common.annotation.Adapter;
import comm.sakamoto.common.model.PostEntity;
import comm.sakamoto.common.model.PostStatus;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Adapter
@RequiredArgsConstructor
public class PersistenceAdapter implements ManagePostsPort, GetPostsPort {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Override
    public List<PostEntity> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public List<PostEntity> getPostsByUserId(Long userId) {
        return postRepository.findAllByUserId(userId);
    }

    @Override
    public List<PostEntity> getPostsByStatus(PostStatus status) {
        return postRepository.findAllByStatus(status);
    }

    @Override
    public List<PostEntity> getPostsByUserIdAndStatus(Long userId, PostStatus status) {
        return postRepository.findAllByUserIdAndStatus(userId, status);
    }

    @Override
    public PostEntity getPostById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
    }

    @Override
    public PostEntity createPost(Post post) {
        return postRepository.save(postMapper.toEntity(post));
    }

    @Override
    public PostEntity updatePost(Post post) {
        return postRepository.save(postMapper.toEntity(post));
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
