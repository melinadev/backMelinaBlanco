
package com.portfolio.melina.Controller;

import com.portfolio.melina.Dto.DtoSkills;
import com.portfolio.melina.Entity.Skills;
import com.portfolio.melina.Service.SSkills;
import com.portfolio.melina.security.Controller.Mensaje;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skills")
@CrossOrigin(origins = "https://frontportfolioblanco.web.app")
public class CSkills {
    @Autowired
    SSkills sSkills;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list(){
        List<Skills> list = sSkills.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoSkills dtoskills){
        if(StringUtils.isBlank(dtoskills.getName()))
            return new ResponseEntity(new Mensaje("El campo es olbigatorio"), HttpStatus.BAD_REQUEST);
        if(sSkills.existsByName(dtoskills.getName()))
            return new ResponseEntity(new Mensaje("El dato ya existe"), HttpStatus.BAD_REQUEST);
        
        Skills skills = new Skills(dtoskills.getName(), dtoskills.getPercentage());
        sSkills.save(skills);
        
        return new ResponseEntity(new Mensaje("Experiencia laboral agregada correctamente"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@PathVariable("id") int id, @RequestBody DtoSkills dtoSkills){
        if(!sSkills.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
  
        Skills skills = sSkills.getOne(id).get();
        
        skills.setPercentage(dtoSkills.getPercentage());
        
        sSkills.save(skills);
        
        return new ResponseEntity(new Mensaje("Porcentaje actualizado correctamente"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id){
        if(!sSkills.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        Skills educacion = sSkills.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
}
