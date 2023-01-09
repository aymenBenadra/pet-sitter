package com.sakamoto.feed.adapter.in.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ResponseRecord<T>(HttpStatus status, String message, T content) {
    public ResponseRecord(T content) {
        this(HttpStatus.OK, null, content);
    }

    public ResponseRecord(HttpStatus status, T content) {
        this(status, null, content);
    }

    public ResponseRecord(HttpStatus status, String message) {
        this(status, message, null);
    }
}
