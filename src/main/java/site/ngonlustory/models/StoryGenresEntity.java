package site.ngonlustory.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "story_genres")
@Data
public class StoryGenresEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "story_id", nullable = false)
    private StoryEntity storyEntity;

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private GenresEntity genresModel;

}
