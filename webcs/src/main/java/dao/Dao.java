/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;

/**
 *
 * @author victor
 */
public interface Dao<T> {
    
    public T get(long id);
    
    List<T> getAll();
    
    public void create(T t);
    
    public void update(T t, String[] params);
    
    public void delete(T t);
}

