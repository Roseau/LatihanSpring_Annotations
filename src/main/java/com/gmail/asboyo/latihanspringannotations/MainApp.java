/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.asboyo.latihanspringannotations;

import com.gmail.asboyo.latihanspringannotations.model.VolumeKubus;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author St0rm
 */
public class MainApp {
    public static void main(String[] args) {
        //test tanpa XML
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(VolumeKubus.class);
        //AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
        VolumeKubus vk = context.getBean(VolumeKubus.class);
        System.out.println("Volume Kubus : "+vk.hitungVolume(10, 10, 10));
    }
}
