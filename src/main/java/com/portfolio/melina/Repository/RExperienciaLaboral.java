package com.portfolio.melina.Repository;

import com.portfolio.melina.Entity.ExperienciaLaboral;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RExperienciaLaboral extends JpaRepository<ExperienciaLaboral, Integer>{
    public Optional<ExperienciaLaboral> findByNameE(String nameE);
    public boolean existsByNameE(String nameE);
}
