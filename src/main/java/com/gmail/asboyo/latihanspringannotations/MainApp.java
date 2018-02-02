/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.asboyo.latihanspringannotations;

import com.gmail.asboyo.latihanspringannotations.model.AppConfig;
import com.gmail.asboyo.latihanspringannotations.model.Provinsi;
import com.gmail.asboyo.latihanspringannotations.model.ProvinsiDAO;
import com.gmail.asboyo.latihanspringannotations.model.VolumeKubus;
import java.util.ArrayList;
import java.util.List;
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
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        VolumeKubus vk = (VolumeKubus) context.getBean("volumeKubus");
        //test dengan xml
//        AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
//        VolumeKubus vk = (VolumeKubus) context.getBean("volumeKubus");
        System.out.println("Volume Kubus : "+vk.hitungVolume(10, 10, 10));
        System.out.println("Volume bola  : "+vk.hitungVolumeLingkaran(30));
        //bisa nama kelas langsung dengan .class, 
        //atau string nama kelas huruf awal kecil(kalo tanpa alias)
        //atau string nama alias
        ProvinsiDAO pdao = (ProvinsiDAO) context.getBean(ProvinsiDAO.class);
        List<Provinsi> listProv = pdao.getAllProvinsi();
        for(Provinsi p : listProv){
            System.out.println("ID negara : "+p.getId_negara()+" || "+
                               "ID provinsi : "+p.getIdProv()+" || "+
                               "Nama Provinsi : "+p.getNama_propinsi());
        }
        //pdao.save(3, 62, "Provinsi Y");
        //pdao.delete(1);
        //pdao.update(2, 63, "Provinsi XYZ");
        Provinsi p = pdao.getProvinsiByID(19);
        System.out.println("id negara     : "+p.getId_negara());
        System.out.println("id provinsi   : "+p.getIdProv());
        System.out.println("nama provinsi : "+p.getNama_propinsi());
        //
        Provinsi pv = pdao.getByProvinsiByIDAlter("SUMATERA BARAT");
        System.out.println("id negara     : "+pv.getId_negara());
        System.out.println("id provinsi   : "+pv.getIdProv());
        System.out.println("nama provinsi : "+pv.getNama_propinsi());
//        //testing batch insert
//        List<Provinsi> batch = new ArrayList<>();
//        batch.add(new Provinsi(551,62,"Mockingjay"));
//        batch.add(new Provinsi(550,62,"District 40"));
//        batch.add(new Provinsi(570,62,"District 58"));
//        System.out.println("count : "+pdao.saveBatch(batch));
        //insert using map parameter
        Provinsi prov = new Provinsi(780,62,"District 777");
        //pdao.saveAlter(prov);
        pdao.saveExecute(prov);
        context.close();
        
        
        
    }
}
