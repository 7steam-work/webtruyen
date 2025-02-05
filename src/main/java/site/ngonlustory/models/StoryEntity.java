package site.ngonlustory.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.ngonlustory.models.enums.StoryStatusEnum;
import site.ngonlustory.models.enums.StoryTypeEnum;

import java.sql.Timestamp;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "stories")
@Data
public class StoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "description")
    private String description;

    @Column(name = "cover_image")
    private String coverImage;

    // Note: 1-manga, 2-tiểu thuyết
    @Column(name = "type")
    private Integer type;

    // Note: 0-gián đoạn, 1-đang diễn ra, 2-hoàn thành
    @Column(name = "status")
    private Integer status;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "view_count")
    private Integer viewCount;

    @Column(name = "total_chapters")
    private Integer totalChapters;

    @Column(name = "last_updated")
    private Timestamp lastUpdated;

    @Column(name = "rating_avg")
    private Float ratingAvg;

    @Column(name = "total_ratings")
    private Integer totalRatings;
}
