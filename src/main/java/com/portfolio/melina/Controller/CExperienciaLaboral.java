package com.portfolio.melina.Controller;

import com.portfolio.melina.Dto.DtoExperienciaLaboral;
import com.portfolio.melina.Entity.ExperienciaLaboral;
import com.portfolio.melina.Service.SExperienciaLaboral;
import com.portfolio.melina.security.Controller.Mensaje;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("explab")
@CrossOrigin(origins = "https://frontportfolioblanco.web.app")
public class CExperienciaLaboral {
    @Autowired
    SExperienciaLaboral sExperienciaLaboral;
    
    @GetMapping("/lista")
    public ResponseEntity<List<ExperienciaLaboral>> list(){
        List<ExperienciaLaboral> list = sExperienciaLaboral.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperienciaLaboral dtoexp){
        if(StringUtils.isBlank(dtoexp.getNameE()))
            return new ResponseEntity(new Mensaje("El campo es olbigatorio"), HttpStatus.BAD_REQUEST);
        if(sExperienciaLaboral.existsByNameE(dtoexp.getNameE()))
            return new ResponseEntity(new Mensaje("El dato ya existe"), HttpStatus.BAD_REQUEST);
        
        ExperienciaLaboral experienciaLaboral = new ExperienciaLaboral(dtoexp.getNameE(), dtoexp.getDescriptionE());
        sExperienciaLaboral.save(experienciaLaboral);
        
        return new ResponseEntity(new Mensaje("Experiencia laboral agregada correctamente"), HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<ExperienciaLaboral> getById(@PathVariable("id") int id){
        if(!sExperienciaLaboral.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        ExperienciaLaboral experiencia = sExperienciaLaboral.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperienciaLaboral dtoexp){
        if(!sExperienciaLaboral.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"),HttpStatus.BAD_REQUEST);
        if(sExperienciaLaboral.existsByNameE(dtoexp.getNameE()) && sExperienciaLaboral.getByNameE(dtoexp.getNameE()).get().getId() != id)
            return new ResponseEntity(new Mensaje("El dato ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoexp.getNameE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        ExperienciaLaboral experienciaLaboral = sExperienciaLaboral.getOne(id).get();
        experienciaLaboral.setNameE(dtoexp.getNameE());
        experienciaLaboral.setDescriptionE((dtoexp.getDescriptionE()));
        
        sExperienciaLaboral.save(experienciaLaboral);
        return new ResponseEntity (new Mensaje("Experiencia actualizada"), HttpStatus.OK);
        
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!sExperienciaLaboral.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        sExperienciaLaboral.delete(id);
        
        return new ResponseEntity(new Mensaje("Experiencia Eliminada"), HttpStatus.OK);
    }
}