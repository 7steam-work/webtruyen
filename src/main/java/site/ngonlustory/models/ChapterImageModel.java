package site.ngonlustory.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chapter_images")
public class ChapterImageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "chapter_id", nullable = false)
    private ChapterModel chapter;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private Integer pageNumber;
}
