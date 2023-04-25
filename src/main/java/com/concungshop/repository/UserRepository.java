package com.concungshop.repository;

import com.concungshop.entity.Product;
import com.concungshop.entity.Role;
import com.concungshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Iterable<User> findByActivated(Boolean isActivated);
    Iterable<User> findByActivatedAndRole(Boolean isActivated, Role role);
    Optional<User> findByUsername(String username);
    Iterable<User> findByFullNameContainingAndActivated(String fullname, Boolean isActivated);

    @Query("SELECT r.name FROM Role r INNER JOIN r.users u WHERE u.username = :username")
    List<String> findRolesByUsername(@Param("username") String username);


}
