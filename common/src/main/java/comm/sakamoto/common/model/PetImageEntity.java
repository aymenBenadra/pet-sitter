package comm.sakamoto.common.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "pet_images")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class PetImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @NotBlank
    private String url;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    @NonNull
    @NotNull
    private PetEntity pet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PetImageEntity that = (PetImageEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}