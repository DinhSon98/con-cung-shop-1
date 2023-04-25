package com.concungshop.dto;

import com.concungshop.entity.Product;
import lombok.*;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Long id;
    private String name;
    private boolean activated;
}
