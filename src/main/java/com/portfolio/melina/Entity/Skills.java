package com.portfolio.melina.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int percentage;
    private String name;

    public Skills() {
    }

    public Skills(int id, int percentage, String name) {
        this.id = id;
        this.percentage = percentage;
        this.name = name;
    }

    public Skills( String name,int percentage) {
        this.name = name;
        this.percentage = percentage;
        
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
