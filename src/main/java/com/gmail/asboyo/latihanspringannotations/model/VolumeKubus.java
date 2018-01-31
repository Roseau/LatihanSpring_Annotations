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
public class VolumeKubus {
    @Autowired
    private Persegi persegi;
    @Autowired
    private Lingkaran lingkaran;
    
    public double hitungVolume(int panjang, int lebar, int tinggi){
        return persegi.hitungLuas(panjang, lebar)*tinggi;
    }
    public double hitungVolumeLingkaran(int jari){
        return lingkaran.hitungLuas(jari)*4/3*jari;
    }
}
