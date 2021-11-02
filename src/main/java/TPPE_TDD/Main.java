/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPPE_TDD;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author marcos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       String[] options_input = {"analysisTime.out", "analysisMemory.out"};
       int selected_input = JOptionPane.showOptionDialog(null, "Qual arquivo voce gostaria de ler?",
                            "Selecao de entrada",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options_input, options_input[0]);
       
       UseParser parser;
       parser = new UseParser(options_input[selected_input]);
       
       String delimitador = JOptionPane.showInputDialog("Qual delimitador voce gostaria de usar?");
        try {
            parser.setDelimitador(delimitador);
        } catch (DelimitadorInvalidoException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Erro" ,JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
        
        String[] options_format = {"Linhas", "Colunas"};
        int selected_format = JOptionPane.showOptionDialog(null, "Em qual formato voce deseja os resultados",
                          "Selecao de formato",
                          JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options_format, options_format[0]);    
        
        
        selected_format = 0==selected_format?1:2;
        
        String result_directory = JOptionPane.showInputDialog("Em que diretorio deseja salvar os resultados (digite sem a / no final)?");
        try {
            parser.selectFormatAndPersist(selected_format, result_directory);
        } catch (ArquivoNaoEncontradoException | EscritaNaoPermitidaException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Erro" ,JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
        
        JOptionPane.showMessageDialog(null, "Resultado gravado com sucesso");

    }
    
}
