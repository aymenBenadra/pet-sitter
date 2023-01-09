package com.sakamoto.feed.domain;

import comm.sakamoto.common.model.PetType;

public record Pet(Long id, String name, PetType type) {
}
