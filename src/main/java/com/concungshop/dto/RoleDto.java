package com.concungshop.dto;

import com.concungshop.entity.RoleName;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {
    private Long id;
    private RoleName name;
    private String description;
}
