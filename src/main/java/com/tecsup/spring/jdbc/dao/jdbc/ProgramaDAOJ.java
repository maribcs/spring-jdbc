/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecsup.spring.jdbc.dao.jdbc;

import com.tecsup.spring.jdbc.dao.ProgramaDAO;
import com.tecsup.spring.jdbc.dao.ProgramaRowMapper;
import com.tecsup.spring.jdbc.model.Programa;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 *
 * @author alumno
 */
public class ProgramaDAOJ extends JdbcDaoSupport implements ProgramaDAO{
    @Override
    public List<Programa> list() {
        String sql = "select * from programa";
        return this.getJdbcTemplate().query(sql, new ProgramaRowMapper());
    }    
    public Programa get(Long id) {
        String sql = "select * from programa where id = ?";
        Programa programa = (Programa) this.getJdbcTemplate().queryForObject(sql, new Object[]{id}, new ProgramaRowMapper());
        return programa;
    }    
    public void insert(Programa t) {
        String sql = "insert into programa(nombre,descripcion,codigo)values(?,?,?)";
        try {
            this.getJdbcTemplate().update(sql, 
                    new Object[]{
                        t.getNombre(),
                        t.getDescripcion(),
                        t.getCodigo()
                    });
        } catch (DataAccessException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
    public void update(Programa t) {
        String sql = "update programa set nombre=?, descripcion=?, codigo=? where id=?";
        try {
            this.getJdbcTemplate().update(sql, 
                    new Object[]{
                        t.getNombre(),
                        t.getDescripcion(),
                        t.getCodigo(),
                        t.getId()
            });
        } catch (DataAccessException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
    public void delete(Programa t) {
        String sql = "delete from programa where id=?";
        this.getJdbcTemplate().update(sql,new Object[]{t.getId()});
    }   
  
}
