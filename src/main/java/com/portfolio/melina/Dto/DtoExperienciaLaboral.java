package com.portfolio.melina.Dto;

import javax.validation.constraints.NotBlank;

public class DtoExperienciaLaboral {
    @NotBlank
    private String nameE;
    @NotBlank
    private String descriptionE;

    public DtoExperienciaLaboral() {
    }

    public DtoExperienciaLaboral(String nameE, String descriptionE) {
        this.nameE = nameE;
        this.descriptionE = descriptionE;
    }

    public String getNameE() {
        return nameE;
    }

    public void setNameE(String nameE) {
        this.nameE = nameE;
    }

    public String getDescriptionE() {
        return descriptionE;
    }

    public void setDescriptionE(String descriptionE) {
        this.descriptionE = descriptionE;
    }
    
    
}
