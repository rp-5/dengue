package com.datamart.humancases.entity;

// import java.util.ArrayList;

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

@Table(name="human")
@Entity(name="human")

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Human {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private int age;

    @Column(name="adress")
    private String adress;

    @Column(name="complement")
    private String complement;

    @Column(name="symptom")
    private String symptom;

    @Column(name="gravity")
    private String gravity;

    @Column(name="status")
    private String status;

    public Human(String name, int age, String adress, String complement, String symptom, String gravity, String status){
        this.name = name;
        this.age = age;
        this.adress = adress;
        this.complement = complement;
        this.symptom = symptom;
        this.gravity = gravity;
        this.status = status;
    }
}
