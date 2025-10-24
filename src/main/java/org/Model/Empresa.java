/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dulce Mota <mdm@isep.ipp.pt>
 */
public class Empresa {

    private final List<TipoCurso> lstTiposCurso;
    private final List<CoordenadorAcademico> lstCA;
    private final List<Curso> cursos;
    private final List<Formador> lstFormadores;

    public Empresa() {
        this.lstTiposCurso = new ArrayList<>();
        this.lstCA = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.lstFormadores = new ArrayList<>();
    }

    /* ----------  TipoCurso  ---------- */
    public TipoCurso novoTipoCurso() {
        return new TipoCurso();
    }

    public boolean especificarTipoCurso(TipoCurso tipoCurso) {
        // TODO: validação global (sigla única, etc.)
        adicionarTipoCurso(tipoCurso);
        return true;
    }

    private void adicionarTipoCurso(TipoCurso tipoCurso) {
        lstTiposCurso.add(tipoCurso);
    }

    public List<TipoCurso> obterListaTiposCurso() {
        return new ArrayList<>(lstTiposCurso);
    }

    /* ----------  Formador  ---------- */
    public Formador novoFormador() {
        return new Formador();
    }

    public boolean registaFormador(Formador formador) {
        // TODO: validação global (email duplicado, etc.)
        lstFormadores.add(formador);
        return true;
    }

    public List<Formador> obterListaFormadores() {
        return new ArrayList<>(lstFormadores);
    }

    /* ----------  CoordenadorAcademico  ---------- */
    public CoordenadorAcademico novoCA() {
        return new CoordenadorAcademico();
    }

    public boolean registaCA(CoordenadorAcademico ca) {
        // TODO: validação global (sigla única, etc.)
        lstCA.add(ca);
        return true;
    }

    public void enviarCredenciaisPorEmail(CoordenadorAcademico ca) {
        System.out.println("\n>>> EMAIL ENVIADO para " + ca.getEmail());
        System.out.println(">>> Login: " + ca.getCredenciais().getLogin());
        System.out.println(">>> Password: " + ca.getCredenciais().getPassword());
    }

    /* ----------  Curso  ---------- */
    public void addCurso(Curso curso) {
        this.cursos.add(curso);
    }

    public List<Curso> getAvailableCourses() {
        return cursos;
    }

    public Curso findCursoById(String idCurso) {
        for (Curso curso : cursos) {
            if (curso.getSigla().equals(idCurso)) {
                return curso;
            }
        }
        return null;
    }

    /* ----------  Outros  ---------- */
    @Override
    public String toString() {
        return "Empresa:\n" +
                "Lista de tipos de cursos: " + lstTiposCurso + "\n";
    }
}
    
    
