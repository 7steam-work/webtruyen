package site.ngonlustory.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "notifications")
@Data
public class NotificationsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;

    // Note: 0 - hệ thống || 1 - cập nhật chương || 2 - bình luận trả lời
    @Column(name = "type")
    private Integer type;

    @Column(name = "content")
    private String content;

    @Column(name = "is_read")
    private boolean isRead;

    @Column(name = "created_at")
    private Timestamp createdAt;
}
