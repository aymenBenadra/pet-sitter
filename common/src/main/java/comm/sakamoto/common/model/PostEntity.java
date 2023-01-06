package comm.sakamoto.common.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "posts")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String title;
    @NonNull
    private String description;

    @NonNull
    private double price;

    @Enumerated(EnumType.STRING)
    private PostStatus status = PostStatus.OPEN;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private PetEntity pet;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<RequestEntity> requests = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PostEntity that = (PostEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
