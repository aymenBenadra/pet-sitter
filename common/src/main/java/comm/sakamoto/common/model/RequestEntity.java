package comm.sakamoto.common.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "post_requests")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class RequestEntity {
    @EmbeddedId
    private RequestId id;

    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name = "user_id")
    @NotNull
    private UserEntity user;

    @ManyToOne
    @MapsId("post_id")
    @JoinColumn(name = "post_id")
    @NotNull
    private PostEntity post;

    @Enumerated(EnumType.STRING)
    @NotNull
    private RequestStatus status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RequestEntity that = (RequestEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}