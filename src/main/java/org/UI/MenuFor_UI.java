package org.UI;

import org.Utils.Utils;
import org.Model.Empresa;
import org.Controller.RegistarFormador_Controller;
import org.Model.Formador;
import java.util.List;

/**
 *
 * @author Dulce Mota <mdm@isep.ipp.pt>
 */
public class MenuFor_UI {
    private Empresa empresa;
    private RegistarFormador_Controller controller;

    public MenuFor_UI(Empresa empresa) {
        this.empresa = empresa;
        controller = new RegistarFormador_Controller(empresa);
    }

    public void run() {
        System.out.println("\nRegistar Formador:");
        controller.novoFormador();

        introduzDados();
        controller.geraIdentificadorECredenciais(); // ← aqui

        System.out.println("Formadores existentes:");
        listaFormadores();

        apresentaDados();

        if (Utils.confirma("Confirma os dados? (S/N)")) {
            if (controller.registaFormador()) {
                System.out.println("Dados do formador guardados com sucesso.");
            } else {
                System.out.println("Não foi possível guardar os dados do formador.");
            }
        }
    }

    private void introduzDados() {
        String nome = Utils.readLineFromConsole("Nome: ");
        String dataNascimento = Utils.readLineFromConsole("Data de nascimento: ");
        String cc = Utils.readLineFromConsole("Número de cartão de cidadão: ");
        String email = Utils.readLineFromConsole("Email: ");
        String contacto = Utils.readLineFromConsole("Contacto: ");
        String areaEspecial = Utils.readLineFromConsole("Área de especialização: ");
        controller.setDados(nome, dataNascimento, cc, email, contacto, areaEspecial);
    }

    private void listaFormadores() {
        List<Formador> formadores = controller.listaFormadores();
        for (Formador f : formadores) {
            System.out.println(f);
        }
    }

    private void apresentaDados() {
        System.out.println("\nFormador:\n" + controller.getFormadorAsString());
    }
}
