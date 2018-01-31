/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.asboyo.latihanspringannotations.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 *
 * @author St0rm
 */
@Component
@ComponentScan(basePackages = "com.gmail.asboyo.latihanspringannotations.model")
public class VolumeKubus {
    @Autowired
    private Persegi persegi;
    
    public double hitungVolume(int panjang, int lebar, int tinggi){
        return persegi.hitungLuas(panjang, lebar)*tinggi;
    }
}
