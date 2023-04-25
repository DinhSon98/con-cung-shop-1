package com.concungshop.entity;


import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private RoleName name;

    private String description;

    @OneToMany(mappedBy = "role")
    Collection<User> users;
}
