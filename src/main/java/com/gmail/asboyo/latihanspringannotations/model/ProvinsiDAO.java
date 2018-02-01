/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.asboyo.latihanspringannotations.model;

import java.sql.Types;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author St0rm
 */
@Repository
public class ProvinsiDAO {
    
    @Autowired
    private JdbcTemplate jdbctemplate;

    public List<Provinsi> getAllProvinsi(){
        return jdbctemplate.query("select id_propinsi, id_negara, nm_propinsi from m_propinsi",//where nm_propinsi like '%'||?||'%' 
                new Object[]{},(rs,rowNum)->{
                    Provinsi p = new Provinsi();
                    p.setIdProv(rs.getInt("id_propinsi"));
                    p.setId_negara(rs.getInt("id_negara"));
                    p.setNama_propinsi(rs.getString("nm_propinsi"));
                    return p;
            });
    }
    @Transactional
    public void save(int id, int id_negara, String nama){
        jdbctemplate.update("insert into m_propinsi(id_propinsi, id_negara, nm_propinsi) values(?,?,?)", id,id_negara,nama);
        System.out.println("provinsi berhasil ditambahkan");
    }
    @Transactional
    public void delete(int id){
        jdbctemplate.update("delete from m_propinsi where id_propinsi=?", id);
        System.out.println("Provinsi berhasil dihapus");
    }
    @Transactional
    public void update(int id, int idnegara, String nama){
        String sql = "update m_propinsi set id_negara=?, nm_propinsi=? where id_propinsi=?";
        Object[] params = {idnegara,nama,id};
        int[] types = {Types.INTEGER,Types.VARCHAR,Types.INTEGER};
        int rows = jdbctemplate.update(sql, params, types);
        System.out.println(rows+" row(s) updated");
    }
    public Provinsi getProvinsiByID(int id){
        return jdbctemplate.queryForObject("select id_propinsi, id_negara, nm_propinsi from m_propinsi where id_propinsi=?", 
                new Object[]{id},(rs,rowNum)->{
                    Provinsi p = new Provinsi();
                    p.setIdProv(rs.getInt("id_propinsi"));
                    p.setId_negara(rs.getInt("id_negara"));
                    p.setNama_propinsi(rs.getString("nm_propinsi"));
                    return p;
            });
    }
    public Provinsi getByProvinsiByIDAlter(String nama){
        Provinsi temp = (Provinsi) jdbctemplate.queryForObject("select id_propinsi as idProv, id_negara, nm_propinsi as nama_propinsi from m_propinsi where nm_propinsi=?", new Object[]{nama}, new BeanPropertyRowMapper(Provinsi.class));
        return temp;
    }
}