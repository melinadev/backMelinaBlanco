package com.portfolio.melina.security.Service;

import com.portfolio.melina.security.Entity.Rol;
import com.portfolio.melina.security.Enums.RolName;
import com.portfolio.melina.security.Repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository irolRepository;
    
    public Optional<Rol> getByRolName(RolName rolName){
        return irolRepository.findByRolName(rolName);
    }
    
    public void save (Rol rol){
        irolRepository.save(rol);
    }
}
