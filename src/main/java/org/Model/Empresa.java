/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Dulce Mota <mdm@isep.ipp.pt>
 */
public class Empresa
{
    private final List<TipoCurso> lstTiposCurso;
    private final List<CoordenadorAcademico> lstCA;
    private final List<Curso> cursos;
    // Completar
    public Empresa()
    {
        this.lstTiposCurso = new ArrayList<>();
        this.lstCA = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }
  
    public TipoCurso novoTipoCurso()
    {
        return new TipoCurso();
    }
    public boolean especificarTipoCurso(TipoCurso tipoCurso)
    {
        if (this.valida(tipoCurso))
        {
           adicionarTipoCurso(tipoCurso);
           return true;
        }
        return false;
    }
        
    private void adicionarTipoCurso(TipoCurso tipoCurso){
        lstTiposCurso.add(tipoCurso);
    }
    // Validação global
    public boolean valida(TipoCurso tipoCurso)
    {
        boolean resp = false;
        if (tipoCurso.valida())
        {
           // Completar        
           //
           resp = true; 
        }
        return resp;
    }
   
    // Completar com outras funcionalidades
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Empresa: \n");
        sb.append("Lista de tipos de cursos: "+ lstTiposCurso.toString()+"\n");
        return sb.toString();
    }

    /* NOVOS CAMPOS */


    /* -------------------------------------------------- */
    public CoordenadorAcademico novoCA() {
        return new CoordenadorAcademico(); }

    public boolean registaCA(CoordenadorAcademico ca) {
        if (validaCA(ca)) {
            lstCA.add(ca);
            return true;
        }
        return false;
    }

    private boolean validaCA(CoordenadorAcademico ca) {
        if (!ca.valida()) return false;
        /* regra de negócio: sigla única */
        boolean siglaExiste = lstCA.stream()
                .anyMatch(c -> c.getSigla().equalsIgnoreCase(ca.getSigla()));
        return !siglaExiste;
    }

    /* para enviar email (simulado) */
    public void enviarCredenciaisPorEmail(CoordenadorAcademico ca) {
        System.out.println("\n>>> EMAIL ENVIADO para " + ca.getEmail());
        System.out.println(">>> Login: " + ca.getCredenciais().getLogin());
        System.out.println(">>> Password: " + ca.getCredenciais().getPassword());
    }

    // Empresa.java
    public List<TipoCurso> obterListaTiposCurso() {
        return new ArrayList<>(lstTiposCurso);
    }
    public void addCurso(Curso curso) {
        this.cursos.add(curso);
    }

    public List<Curso> getCursos() {
        return cursos;
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
    /* ---------- MOCK ---------- */
    private final List<String> cursosMock = new ArrayList<>();
    private final List<Formador> formadoresMock = new ArrayList<>();
    private final List<Modulo> modulosRegistados = new ArrayList<>();
    private int seqModulo = 0;

    public List<String> obterCursosMock() {
        if (cursosMock.isEmpty()) {
            cursosMock.add("Curso-Java");
            cursosMock.add("Curso-Python");
        }
        return new ArrayList<>(cursosMock);
    }

    public List<Formador> obterFormadoresMock() {
        if (formadoresMock.isEmpty()) {
            Formador f = new Formador(); f.setNome("Formador-Teste");
            formadoresMock.add(f);
        }
        return new ArrayList<>(formadoresMock);
    }

    public String gerarCodigoModulo() { return "MOD" + (++seqModulo); }

    public boolean horarioDisponivel(Formador f, String horario) {
        for (Modulo m : modulosRegistados)
            if (m.getFormadorResponsavel().equals(f) &&
                    m.getHorario().equalsIgnoreCase(horario))
                return false;
        return true;
    }

    public boolean registaModulo(String curso, Modulo m) {
        modulosRegistados.add(m);
        System.out.println("\n>>> Módulo associado ao curso '" + curso + "': " + m.getCodigo());
        return true;
    }
    /* ---------- MOCK para este UC ---------- */
    private final List<String> cursosEstado = new ArrayList<>();

    /* devolve cursos dum estado (0-4) – SEM validações */
    public List<String> filtrarCursosPorEstado(int idx) {
        cursosEstado.clear();
        /* dados fictícios – substituir quando tiver Curso real */
        switch (idx) {
            case 0 -> { cursosEstado.add("Java-Básico"); cursosEstado.add("Excel-Iniciação"); }
            case 1 -> { cursosEstado.add("Python-Avançado"); }
            case 4 -> { cursosEstado.add("PowerPoint-Concluído"); }
        }
        return new ArrayList<>(cursosEstado);
    }
}
    
    
