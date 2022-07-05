package com.datamart.regioncases.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name="region")
@Entity(name="region")

public class Region {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @Column(name="adress")
    private String adress;
    
    @NotBlank
    @Column(name= "district")
    private String district;
    
    @NotBlank
    @Column(name="city")
    private String city;

    @NotBlank
    @Column(name="santadingWater")
    private Boolean standingWater;

    @NotBlank
    @Column(name="mosquitoLarva")
    private Boolean mosquitoLarva;

    public Region(String adress, String district, String city, Boolean standingWater, Boolean mosquitoLarva){
        this.adress = adress;
        this.district = district;
        this.city = city;
        this.standingWater = standingWater;
        this.mosquitoLarva = mosquitoLarva;
    }
}
