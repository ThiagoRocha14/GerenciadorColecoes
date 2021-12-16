/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

/**
 *
 * @author aluno
 */
public class DaoFactory {
    
    public static StatusDaoJDBC novoStatusDao() throws Exception{
        return new StatusDaoJDBC();
    }
    public static ItemDaoJDBC novoItemDao() throws Exception{
        return new ItemDaoJDBC();
    }
    public static ColecaoDaoJDBC novoColecaoDao() throws Exception{
        return new ColecaoDaoJDBC();
    }
    
}
