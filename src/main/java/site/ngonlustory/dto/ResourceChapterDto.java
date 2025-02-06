package site.ngonlustory.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ResourceChapterDto {
    private String storyId;
    private String chapterNumber;
    private String title;
    private String content;
    private Timestamp createdAt;
}
