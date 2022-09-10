package com.portfolio.melina.security.Repository;

import com.portfolio.melina.security.Entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iUserRepository extends JpaRepository<User, Integer>{
    Optional <User> findByUserName(String userName);
    
    boolean existsByUserName(String userName);
    boolean existsByMail(String mail);
}
