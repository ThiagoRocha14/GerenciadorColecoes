/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author aluno
 */
public class Colecao {
    
    private int id;
    private String descricao;
    private int totalItensColecao;

    public Colecao(String descricao, int totalItensColecao) {
        this.descricao = descricao;
        this.totalItensColecao = totalItensColecao;
    }

    public Colecao() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getTotalItensColecao() {
        return totalItensColecao;
    }

    public void setTotalItensColecao(int totalItensColecao) {
        this.totalItensColecao = totalItensColecao;
    }
}
