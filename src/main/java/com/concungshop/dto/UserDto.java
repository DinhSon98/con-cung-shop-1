package com.concungshop.dto;

import com.concungshop.entity.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.NaturalId;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;

    private String fullname;

    private String username;

    private String password;

    private String email;

    private String phone;

    private String address;

    private String avatar;

    private boolean activated;

    private Role role;
    private MultipartFile path;
}
