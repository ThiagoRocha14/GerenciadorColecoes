/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
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
    private String status;
    private String colecao;
    private LocalDate dataAquisicao;
    private int totalPorStatus;

    public Item(String descricao, String caminhoFoto, String status, String colecao, LocalDate dataAquisicao) {
        this.descricao = descricao;
        this.caminhoFoto = caminhoFoto;
        this.status = status;
        this.colecao = colecao;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getColecao() {
        return colecao;
    }

    public void setColecao(String colecao) {
        this.colecao = colecao;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public int getTotalPorStatus() {
        return totalPorStatus;
    }

    public void setTotalPorStatus(int totalPorStatus) {
        this.totalPorStatus = totalPorStatus;
    }
}
