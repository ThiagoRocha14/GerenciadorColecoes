/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;

/**
 *
 * @author aluno
 */
public interface InterfaceDao<T> {
    
    public abstract void incluir(T entidade) throws Exception;
    
    public abstract void editar(T entidade) throws Exception;
    
    public abstract void excluir(T entidade) throws Exception;
    
    public abstract void pesquisarPorId(int id) throws Exception;
    
    public abstract void pesquisarPorString(String termo) throws Exception;
    
    public abstract List<T> listar() throws Exception;
    
}
