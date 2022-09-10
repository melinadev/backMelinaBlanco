
package com.portfolio.melina.Service;

import com.portfolio.melina.Entity.Skills;
import com.portfolio.melina.Repository.RSkills;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SSkills {
    @Autowired
    RSkills rSkills;
    
    public List<Skills> list(){
        return rSkills.findAll();
    }
    
     public Optional<Skills> getOne(int id){
        return rSkills.findById(id);
    }
     
     public boolean existsById(int id){
        return rSkills.existsById(id);
    }
     
    public void save(Skills educacion){
       rSkills.save(educacion);
    }
    public boolean existsByName(String name){
        return rSkills.existsByName(name);
    }
    public Optional<Skills> getByName(String name){
        return rSkills.findByName(name);
    }
}
