package com.concungshop.service;

import com.concungshop.dto.RoleDto;
import com.concungshop.entity.Role;
import com.concungshop.entity.RoleName;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RoleService extends GeneralService<RoleDto> {
    Optional<RoleDto> findByName(RoleName name);
}
