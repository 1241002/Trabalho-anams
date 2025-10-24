package org.Controller;

import org.Model.*;
import java.util.List;

public class AdicionarModuloController {
    private final Empresa empresa;
    private String cursoEscolhido;
    private Modulo modulo;

    public AdicionarModuloController(Empresa empresa) { this.empresa = empresa; }

    public List<String> obterCursos() { return empresa.obterCursosMock(); }
    public List<Formador> obterFormadores() { return empresa.obterFormadoresMock(); }

    public void selecionarCurso(int idx) {
        List<String> c = obterCursos();
        if (idx >= 0 && idx < c.size()) cursoEscolhido = c.get(idx);
    }

    public void criarModulo(String titulo, int ch, String dataI, String dataF,
                            String horario, Formador formador) {
        modulo = new Modulo();
        modulo.setTitulo(titulo);
        modulo.setCargaHoraria(ch);
        modulo.setDataInicio(dataI);
        modulo.setDataConclusao(dataF);
        modulo.setHorario(horario);
        modulo.setFormadorResponsavel(formador);
        modulo.setCodigo(empresa.gerarCodigoModulo());
    }

    public boolean dadosOk() {
        return empresa.horarioDisponivel(modulo.getFormadorResponsavel(), modulo.getHorario());
    }

    public boolean confirmar() {
        if (cursoEscolhido == null || modulo == null) return false;
        return empresa.registaModulo(cursoEscolhido, modulo);
    }

    public String getDadosModulo() { return modulo.toString(); }
}