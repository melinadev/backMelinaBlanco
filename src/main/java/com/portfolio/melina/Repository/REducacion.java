package com.portfolio.melina.Repository;

import com.portfolio.melina.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REducacion  extends JpaRepository<Educacion, Integer>{
    public Optional<Educacion> findByNameE(String nameE);
    public boolean existsByNameE(String nameE);
}
