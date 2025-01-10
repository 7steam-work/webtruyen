package site.ngonlustory.dto;

import lombok.Getter;

@Getter
public class CreateUserDto {
    private String username;
    private String password;
    private String email;
    private String avatar;
    private String bio;
}
