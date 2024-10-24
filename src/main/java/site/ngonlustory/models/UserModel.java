package site.ngonlustory.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Username là bắt buộc!")
    @Column(nullable = false, unique = true)
    private String username;

    @NotBlank(message = "Password là bắt buộc!")
    @Column(nullable = false)
    private String password;

    @Email(message = "Email không hợp lệ")
    @NotBlank(message = "Email là bắt buộc!")
    @Column(nullable = false, unique = true)
    private String email;

}
