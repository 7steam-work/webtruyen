package site.ngonlustory.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.ngonlustory.models.enums.ContentTypeEnum;

import java.sql.Timestamp;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reports")
@Data
public class ReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "content_type")
    private ContentTypeEnum contentType;

    @Column(name = "content_id")
    private Integer contentId;

    @Column(name = "reason")
    private String reason;

    @Column(name = "status")
    private Integer status;

    @Column(name = "created_at")
    private Timestamp createdAt;
}
