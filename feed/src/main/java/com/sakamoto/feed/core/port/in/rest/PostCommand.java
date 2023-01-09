package com.sakamoto.feed.core.port.in.rest;

public record PostCommand(String title, String description, double price, Long userId, Long petId) {
}
