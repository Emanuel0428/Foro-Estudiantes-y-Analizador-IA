package org.IngSoftware.repository;

import org.IngSoftware.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RolesRepository extends JpaRepository<Roles, Long> {
    Optional<Roles> findByNombre(String DescpRol);
    
}
