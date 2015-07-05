/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecsup.spring.jdbc.helper;

import java.util.List;


/**
 *
 * @author alumno
 */
public interface GenericDAO<T> {
    public List<T> list();
    public T get(Long id);
    public void insert(T t);
    public void update(T t);
    public void delete(T t);    
}
