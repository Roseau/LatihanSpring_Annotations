/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.asboyo.latihanspringannotations.model;

import java.util.List;
import static javafx.scene.input.KeyCode.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

/**
 *
 * @author St0rm
 */
@Repository("provinsirepo")
public class ProvinsiDAO {
    
    @Autowired
    private JdbcTemplate jdbctemplate;

    public List<Provinsi> getAllProvinsi(){
        return jdbctemplate.query("select id_propinsi, id_negara, nm_propinsi from m_propinsi", 
                new Object[]{},(rs,rowNum)->{
                    Provinsi p = new Provinsi();
                    p.setIdProv(rs.getInt("id_propinsi"));
                    p.setId_negara(rs.getInt("id_negara"));
                    p.setNama_propinsi(rs.getString("nm_propinsi"));
                    return p;
            });
    }
}