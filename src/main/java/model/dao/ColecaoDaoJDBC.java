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
import model.Colecao;

/**
 *
 * @author aluno
 */
public class ColecaoDaoJDBC implements InterfaceDao<Colecao> {
    
    private Connection conn;
    
    public ColecaoDaoJDBC() throws Exception {
        this.conn = ConnectionFactory.getConnection();
    }


    @Override
    public void incluir(Colecao entidade) throws Exception {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO Colecao (id_colecao, descricao,total_itens_colecao) VALUES (?, ?, ?)");
        ps.setString(1, entidade.getId());
        ps.setString(2, entidade.getDescricao());
        ps.setInt(3, entidade.getTotalItensColecao());
        ps.execute();
    }

    @Override
    public void editar(Colecao entidade) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Colecao entidade) throws Exception {
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
    public List<Colecao> listar() throws Exception {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Colecao");
        ResultSet rs = ps.executeQuery();
        List<Colecao> lista = new ArrayList();
        while (rs.next()){
           Colecao c = new Colecao();
           c.setDescricao(rs.getString("descricao"));
           c.setTotalItensColecao(rs.getInt("total_itens_colecao"));
           lista.add(c);
        }
        return lista;
    }
    
}
