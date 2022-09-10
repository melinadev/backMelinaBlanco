package com.portfolio.melina.Service;

import com.portfolio.melina.Entity.ExperienciaLaboral;
import com.portfolio.melina.Repository.RExperienciaLaboral;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SExperienciaLaboral {
    @Autowired
    RExperienciaLaboral rExperienciaLaboral;
    
    public List<ExperienciaLaboral> list(){
        return rExperienciaLaboral.findAll();
    }
    
    public Optional<ExperienciaLaboral> getOne(int d){
        return rExperienciaLaboral.findById(d);
    }
    
    public Optional<ExperienciaLaboral> getByNameE (String nameE){
        return rExperienciaLaboral.findByNameE(nameE);
    }
    public void save(ExperienciaLaboral experienciaLaboral){
        rExperienciaLaboral.save(experienciaLaboral);
    }
    
    public void delete(int id){
        rExperienciaLaboral.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rExperienciaLaboral.existsById(id);
    }
    
    public boolean existsByNameE(String nameE){
        return rExperienciaLaboral.existsByNameE(nameE);
    }
}
