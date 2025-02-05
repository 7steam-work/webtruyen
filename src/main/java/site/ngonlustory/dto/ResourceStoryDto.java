package site.ngonlustory.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ResourceStoryDto {
    private String title;
    private String author;
    private String description;
    private String coverImage;

    // Note: 1-manga, 2-tiểu thuyết
    private Integer typeStory;

    // Note: 0-gián đoạn, 1-đang diễn ra, 2-hoàn thành
    private Integer statusStory;

    private Timestamp createdAt;
    private Integer viewCount;
    private Integer totalChapters;
    private Timestamp lastUpdated;
    private Float ratingAvg;
    private Integer totalRatings;
}
