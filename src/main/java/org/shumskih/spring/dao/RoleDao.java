package org.shumskih.spring.dao;

import org.shumskih.spring.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
}
