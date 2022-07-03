package com.datamart.humancases.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="symptom")
@Entity(name="symptom")

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Symptom {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(name="nome")
    private String name;

    public Symptom (String name){
        this.name = name;
    }

}
