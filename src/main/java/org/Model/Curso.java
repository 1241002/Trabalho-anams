package org.Model;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String titulo;
    private String sigla;
    private String descricao;
    private List<Inscricao> inscricoes;

    public Curso() {
        this.inscricoes = new ArrayList<>();
    }

    public void adicionarInscricao(Inscricao inscricao) {
        this.inscricoes.add(inscricao);
    }
    public void removerInscricao(Inscricao inscricao) {
        this.inscricoes.remove(inscricao);
    }

    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
