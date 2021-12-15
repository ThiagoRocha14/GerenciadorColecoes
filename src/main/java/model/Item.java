/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import model.Colecao;
import model.Status;

/**
 *
 * @author aluno
 */
public class Item {

    private int id;
    private String descricao;
    private String caminhoFoto;
    private Status status;
    private Colecao colecao;
    private Date dataLancamento;
    private Date dataAquisicao;

    public Item(String descricao, String caminhoFoto, Status status, Colecao colecao, Date dataLancamento, Date dataAquisicao) {
        this.descricao = descricao;
        this.caminhoFoto = caminhoFoto;
        this.status = status;
        this.colecao = colecao;
        this.dataLancamento = dataLancamento;
        this.dataAquisicao = dataAquisicao;
    }

    public Item() {
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

    public String getCaminhoFoto() {
        return caminhoFoto;
    }

    public void setCaminhoFoto(String caminhoFoto) {
        this.caminhoFoto = caminhoFoto;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Colecao getColecao() {
        return colecao;
    }

    public void setColecao(Colecao colecao) {
        this.colecao = colecao;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Date getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(Date dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }
}
