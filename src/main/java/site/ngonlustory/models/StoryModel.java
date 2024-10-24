package site.ngonlustory.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stories")
public class StoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Tiêu đề là bắt buộc!")
    @Column(nullable = false)
    private String title;

    private String author;

    @Size(max = 5000, message = "Mô tả không được vượt quá 5000 ký tự")
    private String description;

    private String coverImage;

    @Enumerated(EnumType.STRING)
    @Column(name="type", nullable = false)
    private TypeStory type;

    @Enumerated(EnumType.STRING)
    @Column(name="status", nullable = false)
    private TypeStatus status = TypeStatus.ONGOING;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToMany
    @JoinTable(
            name = "story_genres",
            joinColumns = @JoinColumn(name = "story_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<GenreModel> genres;

    public enum TypeStory {
        NOVEL,
        MANGA
    }

    public enum TypeStatus {
        ONGOING,
        COMPLETED,
        HIATUS
    }
}
