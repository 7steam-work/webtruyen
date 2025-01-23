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
@Table(name = "chapter_images")
@Data
public class ChapterImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "chapter_id", nullable = false)
    private ChapterEntity chapterEntity;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "page_number")
    private Integer pageNumber;
}
