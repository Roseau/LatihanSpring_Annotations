/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.asboyo.latihanspringannotations.model;

import org.springframework.stereotype.Component;

/**
 *
 * @author St0rm
 */
@Component
public class Lingkaran {
    public double hitungLuas(int jari){
        return jari*jari*3.14;
    }
}
