package com.sakamoto.feed.domain;

import comm.sakamoto.common.model.PostStatus;
import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Post {
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private String description;
    @NonNull
    private double price;
    private PostStatus status = PostStatus.OPEN;
    @NonNull
    private User user;
    @NonNull
    private Pet pet;

    public void close() {
        this.status = PostStatus.CLOSED;
    }
}
