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
import model.Item;
import model.Status;

/**
 *
 * @author aluno
 */
public class ItemDaoJDBC implements InterfaceDao<Item> {
    
    private Connection conn;
    
    public ItemDaoJDBC() throws Exception {
        this.conn = ConnectionFactory.getConnection();
    }


    @Override
    public void incluir(Item entidade) throws Exception {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO Item (caminho_foto, status, colecao, data_aquisicao, descricao) VALUES (?, ?, ?, ?, ?)");
        ps.setString(1, entidade.getCaminhoFoto());
        ps.setString(2, entidade.getStatus().toString());
        ps.setString(3, entidade.getColecao().toString());
        ps.setString(4,  entidade.getDataAquisicao().toString());
        ps.setString(5, entidade.getDescricao());
        ps.execute();
    }

    @Override
    public void editar(Item entidade) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Item entidade) throws Exception {
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
    public List<Item> listar() throws Exception {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Item");
        ResultSet rs = ps.executeQuery();
        List<Item> lista = new ArrayList();
        while (rs.next()) {
            Item item = new Item();
            item.setId(rs.getInt("id_item"));
            item.setCaminhoFoto(rs.getString("caminho_foto"));
            item.setColecao(rs.getString("colecao"));
            item.setStatus(rs.getString("status"));
            item.setDataAquisicao(rs.getDate("data_aquisicao").toLocalDate());
            item.setDescricao(rs.getString("descricao"));
            lista.add(item);            
        }
        return lista;
    }
    
    public List<Item> listarFiltroItem() throws Exception {
        PreparedStatement ps = conn.prepareStatement("SELECT id_item, descricao, status, colecao FROM Item ORDER BY colecao asc");
        ResultSet rs = ps.executeQuery();
        List<Item> lista = new ArrayList();
        while (rs.next()) {
            Item item = new Item();
            item.setId(rs.getInt("id_item"));
            item.setColecao(rs.getString("colecao"));
            item.setStatus(rs.getString("status"));
            item.setDescricao(rs.getString("descricao"));
            lista.add(item);            
        }
        return lista;
    }
    
    public List<Item> listarFiltroItem(String colecao) throws Exception {
        PreparedStatement ps = conn.prepareStatement("SELECT id_item, descricao, status, colecao FROM Item where colecao = ? ORDER BY colecao asc");
        ps.setString(1, colecao);
        ResultSet rs = ps.executeQuery();
        List<Item> lista = new ArrayList();
        while (rs.next()) {
            Item item = new Item();
            item.setId(rs.getInt("id_item"));
            item.setColecao(rs.getString("colecao"));
            item.setStatus(rs.getString("status"));
            item.setDescricao(rs.getString("descricao"));
            lista.add(item);            
        }
        return lista;
    }

    public List<Item> listarFiltroStatus() throws Exception {
        PreparedStatement ps = conn.prepareStatement("SELECT COUNT(status) as totalStatus, status FROM Item GROUP BY status");
        ResultSet rs = ps.executeQuery();
        List<Item> lista = new ArrayList();
        while (rs.next()) {
            Item item = new Item();
            item.setStatus(rs.getString("status"));
            item.setTotalPorStatus(rs.getInt("totalStatus"));
            item.setColecao("Coleção não filtrada");
            lista.add(item);            
        }
        return lista;
    }

    public List<Item> listarFiltroStatus(String colecao) throws Exception {
        PreparedStatement ps = conn.prepareStatement("SELECT COUNT(status) as totalStatus, status, colecao FROM Item where colecao = ? GROUP BY status");
        ps.setString(1, colecao);
        ResultSet rs = ps.executeQuery();
        List<Item> lista = new ArrayList();
        while (rs.next()) {
            Item item = new Item();
            item.setColecao(rs.getString("colecao"));
            item.setStatus(rs.getString("status"));
            item.setTotalPorStatus(rs.getInt("totalStatus"));
            lista.add(item);            
        }
        return lista;
    }
    
}
