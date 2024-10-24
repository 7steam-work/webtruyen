package site.ngonlustory.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "story_genres")
@IdClass(StoryGenresId.class)
public class StoryGenreModel {

    @Id
    @ManyToOne
    @JoinColumn(name = "story_id")
    private StoryModel story;

    @Id
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private GenreModel genre;
}
