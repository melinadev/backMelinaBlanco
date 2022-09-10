package com.portfolio.melina.security.Service;

import com.portfolio.melina.security.Entity.User;
import com.portfolio.melina.security.Repository.iUserRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    @Autowired
    iUserRepository iuserRepository;
    
    public Optional<User> getByUserName(String userName){
        return iuserRepository.findByUserName(userName);
    }
    
    public boolean existsByUserName(String userName){
        return iuserRepository.existsByUserName(userName);
    }
    
    public boolean existsByMail(String mail){
        return iuserRepository.existsByMail(mail);
    }
    
    public void save(User user){
        iuserRepository.save(user);
    }
}
