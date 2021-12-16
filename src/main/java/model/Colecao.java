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
    
    private String id;
    private String descricao;
    private int totalItensColecao;

    public Colecao(String descricao, int totalItensColecao) {
        this.descricao = descricao;
        this.totalItensColecao = totalItensColecao;
    }

    public Colecao() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
        setId(descricao);
    }

    public int getTotalItensColecao() {
        return totalItensColecao;
    }

    public void setTotalItensColecao(int totalItensColecao) {
        this.totalItensColecao = totalItensColecao;
    }
}
