package org.UI;

import java.io.IOException;

import org.Utils.Utils;
import org.Model.Empresa;
/**
 *
 * @author Dulce Mota <mdm@isep.ipp.pt>
 */
public class MenuAlu_UI
{
    private Empresa empresa;
    private String opcao;

    public MenuAlu_UI(Empresa empresa)
    {
        this.empresa = empresa;
    }
    public void run() throws IOException
    {
        do
        {
            System.out.println("###### MENU #####\n\n");
            System.out.println("1. Fazer inscrição num curso");
            System.out.println("2. Anular inscrição num curso");
            System.out.println("0. Voltar");

            opcao = Utils.readLineFromConsole("Escolha uma opção: ");

            if( opcao.equals("1") )
            {
                InscreverAluno_UI ui = new InscreverAluno_UI(empresa);
                ui.run();
                System.out.println("Selecionou a opção: Fazer inscrição num curso");

            }
            else
            if( opcao.equals("2") )
            {
                AnularInscricao_UI ui = new AnularInscricao_UI(empresa);
                ui.run();
                System.out.println("Selecionou a opção: Anular inscrição num curso");

            }

        }
        while (!opcao.equals("0") );
    }
}
