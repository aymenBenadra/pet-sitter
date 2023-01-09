package com.sakamoto.feed.core.port.out.persistence;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(Long id) {
        super("No post found with id: " + id);
    }
}
