package comm.sakamoto.common.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pets")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private PetType type;

    private int age;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NonNull
    private UserEntity owner;

    @ManyToOne
    @JoinColumn(name = "sitter_id")
    @NonNull
    private UserEntity sitter;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<PetImageEntity> images = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        PetEntity that = (PetEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}