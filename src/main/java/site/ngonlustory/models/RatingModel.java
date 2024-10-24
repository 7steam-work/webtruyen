package site.ngonlustory.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ratings")
@IdClass(RatingId.class)
public class RatingModel {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    @Id
    @ManyToOne
    @JoinColumn(name = "story_id", nullable = false)
    private StoryModel story;

    @Column(nullable = false)
    private Integer rating;
}
