package com.sakamoto.feed.core.port.in.rest;

import com.sakamoto.feed.domain.Pet;
import com.sakamoto.feed.domain.User;
import comm.sakamoto.common.model.PostStatus;
import lombok.Builder;

@Builder
public record PostDTO(Long id, String title, String description, double price, PostStatus status, User user, Pet pet) {
}
