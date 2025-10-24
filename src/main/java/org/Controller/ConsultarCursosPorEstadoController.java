package org.Controller;

import org.Model.Empresa;
import java.util.List;

public class ConsultarCursosPorEstadoController {

    private final Empresa empresa;

    public ConsultarCursosPorEstadoController(Empresa empresa) {
        this.empresa = empresa;
    }

    /* devolve lista de strings com os 5 estados */
    public String[] obterOpcoesEstado() {
        return org.Model.EstadoCurso.NOMES;
    }

    /* devolve cursos de um estado (índice 0-4) */
    public List<String> obterCursosPorEstado(int idx) {
        return empresa.filtrarCursosPorEstado(idx);
    }
}