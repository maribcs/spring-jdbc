/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecsup.spring.jdbc.dao;

import com.tecsup.spring.jdbc.model.Programa;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


/**
 *
 * @author alumno
 */
public class ProgramaRowMapper implements RowMapper<Programa>{
    
    @Override
    public Programa mapRow(ResultSet rs, int i) throws SQLException{
        Programa programa = new Programa();
        programa.setId(rs.getLong(1));
        programa.setNombre(rs.getString(2));
        programa.setDescripcion(rs.getString(3));
        return programa;
    }
}
