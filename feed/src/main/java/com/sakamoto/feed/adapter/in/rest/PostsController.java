package com.sakamoto.feed.adapter.in.rest;

import com.sakamoto.feed.core.port.in.rest.ManagePostsUseCase;
import com.sakamoto.feed.core.port.in.rest.PostCommand;
import com.sakamoto.feed.core.port.in.rest.PostDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@ResponseStatus(HttpStatus.OK)
public class PostsController {
    private final ManagePostsUseCase managePostsUseCase;

    @PostMapping("/")
    public ResponseEntity<?> createPost(@RequestBody PostCommand command) {
        PostDTO post = managePostsUseCase.createPost(command);
        return ResponseEntity.created(URI.create("/" + post.id())).body(post);
    }

    @PutMapping("/{id}")
    public PostDTO updatePost(@PathVariable Long id, @RequestBody PostCommand command) {
        return managePostsUseCase.updatePost(id, command);
    }

    @PatchMapping("/{id}")
    public void closePost(@PathVariable Long id) {
        managePostsUseCase.closePost(id);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        managePostsUseCase.deletePost(id);
    }
}
