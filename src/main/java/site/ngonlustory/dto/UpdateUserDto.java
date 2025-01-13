package site.ngonlustory.dto;

import lombok.Data;

@Data
public class UpdateUserDto {
    private String username;
    private String password;
    private String email;
    private String avatar;
    private String bio;
}
