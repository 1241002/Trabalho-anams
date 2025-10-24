package org.Controller;

import org.Model.Credenciais;
import org.Model.Empresa;
import org.Model.Formador;
import org.Utils.Utils;

import java.util.List;

public class RegistarFormador_Controller {
    private final Empresa empresa;
    private Formador formador;

    public RegistarFormador_Controller(Empresa empresa) {
        this.empresa = empresa;
    }

    public void novoFormador() {
        this.formador = empresa.novoFormador();
    }

    public void setDados(String nome, String dataNascimento, String cc, String email, String contacto, String areaEspecial) {
        this.formador.setNome(nome);
        this.formador.setDataNascimento(dataNascimento);
        this.formador.setCc(cc);
        this.formador.setEmail(email);
        this.formador.setContacto(contacto);
        this.formador.setAreaEspecial(areaEspecial);
    }

    public boolean registaFormador() {
        return this.empresa.registaFormador(this.formador);
    }

    public String getFormadorAsString() {
        return this.formador.toString();
    }

    public void geraIdentificadorECredenciais() {
        // Identificador único: sequencial com prefixo "FOR-"
        long seq = System.currentTimeMillis() % 100_000; // simples
        String id = "FOR-" + seq;
        formador.setIdentificadorUnico(id);

        // Login: primeira parte do email (antes do @)
        String login = formador.getEmail().split("@")[0];
        // Password: 6 caracteres aleatórios
        String password = Utils.geraPassword(6, 4, 2); // 4 letras + 2 dígitos
        formador.setCredenciais(new Credenciais(login, password));
    }

    // Adicionado o método listaFormadores
    public List<Formador> listaFormadores() {
        return empresa.obterListaFormadores();
    }
}