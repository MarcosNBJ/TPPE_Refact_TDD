/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPPE_TDD;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcos
 */
public class UseParser {
   
    private String delimitador;
    private Persistencia persistencia;
    List<String> input;

    public UseParser(String arquivoEntrada) {
        try {
            this.persistencia = new Persistencia(arquivoEntrada);
            this.input = persistencia.readInput();
        } catch (ArquivoNaoEncontradoException ex) {
            Logger.getLogger(UseParser.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }

    public void setDelimitador(String delimitador) throws DelimitadorInvalidoException {
       
        if(1==delimitador.length()){
            this.delimitador = delimitador;
        }else{
            throw new DelimitadorInvalidoException();
        }
    }
    
    public String getDelimitador(){
        return this.delimitador;
    } 

    
    public String getParsedResultLines() throws ArquivoNaoEncontradoException{
        ContentParser parser = new ContentParser(this.delimitador);
        String result = parser.getParsedResultLines(this.input);
        return result;
    }
    
    public String getParsedResultColumns() throws ArquivoNaoEncontradoException{
        ContentParser parser = new ContentParser(this.delimitador);
        String result = parser.getParsedResultColumns(this.input);
        return result;
    
    }
    
    
    public void selectFormatAndPersist(int mode, String caminhoSaida)throws ArquivoNaoEncontradoException, EscritaNaoPermitidaException{
        String result = 1==mode?getParsedResultLines():getParsedResultColumns();
        this.persistencia.setCaminhoSaida(caminhoSaida);
        this.persistencia.writeResultsToFile(result);
    }

}
