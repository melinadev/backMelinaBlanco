
package com.portfolio.melina.Repository;

import com.portfolio.melina.Entity.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RSkills extends JpaRepository<Skills, Integer>{
    public Optional<Skills> findByName(String name);
    public boolean existsByName(String name);
}
