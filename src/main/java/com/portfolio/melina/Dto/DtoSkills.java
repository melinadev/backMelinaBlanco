
package com.portfolio.melina.Dto;

import javax.validation.constraints.NotBlank;


public class DtoSkills {
    @NotBlank
    private int percentage;
    @NotBlank
    private int id;
    @NotBlank
    private String name;

    public DtoSkills() {
    }

    public DtoSkills(int percentage, int id, String name) {
        this.percentage = percentage;
        this.id = id;
        this.name = name;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

    
    
    
}
