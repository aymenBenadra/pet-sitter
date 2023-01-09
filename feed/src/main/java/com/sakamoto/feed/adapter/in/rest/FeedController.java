package com.sakamoto.feed.adapter.in.rest;

import com.sakamoto.feed.core.port.in.rest.GetPostsUseCase;
import com.sakamoto.feed.core.port.in.rest.PostDTO;
import comm.sakamoto.common.model.PostStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@ResponseStatus(HttpStatus.OK)
public class FeedController {

    private final GetPostsUseCase getPostsUseCase;

    @GetMapping("/")
    public List<PostDTO> getPosts(@RequestParam(name = "status", required = false) PostStatus status,
                                  @RequestParam(name = "user", required = false) Long userId) {
        List<PostDTO> posts;
        if (userId != null && status != null) {
            posts = getPostsUseCase.getPostsByUserIdAndStatus(userId, status);
        } else if (userId != null) {
            posts = getPostsUseCase.getPostsByUserId(userId);
        } else if (status != null) {
            posts = getPostsUseCase.getPostsByStatus(status);
        } else {
            posts = getPostsUseCase.getAllPosts();
        }
        return posts;
    }

    @GetMapping("/{id}")
    public PostDTO getPostById(@PathVariable Long id) {
        return getPostsUseCase.getPostById(id);
    }
}
