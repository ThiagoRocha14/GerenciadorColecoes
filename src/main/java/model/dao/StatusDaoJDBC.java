/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Status;

/**
 *
 * @author aluno
 */
public class StatusDaoJDBC implements InterfaceDao<Status> {
    
    private Connection conn;
    
    public StatusDaoJDBC() throws Exception {
        this.conn = ConnectionFactory.getConnection();
        
    }

    @Override
    public void incluir(Status entidade) throws Exception {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO Status (descricao) VALUES (?)");
        ps.setString(1, entidade.getDescricao());
        ps.execute();
    }

    @Override
    public void editar(Status entidade) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Status entidade) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pesquisarPorId(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pesquisarPorString(String termo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Status> listar() throws Exception {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Status");
        ResultSet rs = ps.executeQuery();
        List<Status> lista = new ArrayList();
        while (rs.next()){
           Status s = new Status();
           s.setId(rs.getInt("id_status"));
           s.setDescricao(rs.getString("descricao"));
           lista.add(s);
        }
        return lista;
    }
    
}
