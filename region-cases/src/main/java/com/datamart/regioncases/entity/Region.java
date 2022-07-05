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
    @Column(name="address")
    private String address;
    
    @NotBlank
    @Column(name= "district")
    private String district;
    
    @NotBlank
    @Column(name="city")
    private String city;

    @Column(name="santadingWater")
    private Boolean standingWater;

    @Column(name="mosquitoLarva")
    private Boolean mosquitoLarva;

    public Region(String address, String district, String city, Boolean standingWater, Boolean mosquitoLarva){
        this.address = address;
        this.district = district;
        this.city = city;
        this.standingWater = standingWater;
        this.mosquitoLarva = mosquitoLarva;
    }
}
