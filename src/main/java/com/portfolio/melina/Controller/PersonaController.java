package com.portfolio.melina.Controller;

import com.portfolio.melina.Entity.Persona;
import com.portfolio.melina.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://frontportfolioblanco.web.app")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    @GetMapping ("/personas/traer") //ära que nos traiga de la base de datos al front
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/personas/crear") //Guardame del front en la BDD
    public String createPersona (@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "Creación de perona correcta";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/personas/borrar/{id}")
    public String deletePersona (@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    
    //Editar un usuario
    //URL:PUERTO/persona/editar/4(id)/nombre & Apellido &img
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/personas/editar/{id}")
    public Persona editPersona (@PathVariable Long id,
                                @RequestParam ("name") String nuevoName,
                                @RequestParam ("surname") String nuevoSurname,
                                @RequestParam ("img") String nuevoImg){
        Persona persona = ipersonaService.findPersona(id);
        
        persona.setName(nuevoName);
        persona.setSurname(nuevoSurname);
        persona.setImg(nuevoImg);
        
        ipersonaService.savePersona(persona);
        return persona;
    }
    
    @GetMapping ("/personas/traer/perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona((long)1);
    }
   
    
}
