package com.portfolio.melina.security.Repository;

import com.portfolio.melina.security.Entity.Rol;
import com.portfolio.melina.security.Enums.RolName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolName(RolName rolName);
}
