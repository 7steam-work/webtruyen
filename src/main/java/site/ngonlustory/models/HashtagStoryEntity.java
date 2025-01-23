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
@Table(name = "hashtag_stories")
@Data
public class HashtagStoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "hashtag_id")
    private HashtagsEntity hashtagsEntity;

    @ManyToOne
    @JoinColumn(name = "story_id")
    private StoryEntity storyEntity;

}
