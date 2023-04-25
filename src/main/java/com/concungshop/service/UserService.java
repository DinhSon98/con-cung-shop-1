package com.concungshop.service;

import com.concungshop.dto.RoleDto;
import com.concungshop.dto.UserDto;
import com.concungshop.entity.Product;
import com.concungshop.entity.Role;
import com.concungshop.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService extends GeneralService<UserDto> {
    Optional<UserDto> findByUsername(String username);
    Iterable<UserDto> findByActivatedAndRole(Boolean isActivated, RoleDto roleDto);
    void updatePassword(UserDto userDto);
    void updateRole(UserDto userDto);
    Iterable<UserDto> findByFullNameContainingAndActivated(String fullname, Boolean isActivated);
}
