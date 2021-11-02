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

   private String arquivoEntrada;
   private String delimitador;
   private Integer max;

    public UseParser(String arquivoEntrada) {
        this.arquivoEntrada = arquivoEntrada;
    }

    public List<String> readInput() throws ArquivoNaoEncontradoException {
        
        List<String> content = new ArrayList<>();
        
        try {
            content = Files.readAllLines(Paths.get(this.arquivoEntrada), StandardCharsets.UTF_8);
        } catch (Exception e) {
           throw new ArquivoNaoEncontradoException();
        }
        return content;
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
        String result = parser.getParsedResultLines(readInput());
        return result;
    }
    
    public String getParsedResultColumns() throws ArquivoNaoEncontradoException{
        ContentParser parser = new ContentParser(this.delimitador);
        String result = parser.getParsedResultColumns(readInput());
        return result;
    
    }
    
    
    private void writeResultsToFile(String content, String arquivoSaida) throws ArquivoNaoEncontradoException, EscritaNaoPermitidaException{
                
        try (PrintWriter out = new PrintWriter(arquivoSaida)) {
            out.println(content);
        } catch (Exception ex) {
           throw new EscritaNaoPermitidaException();
        }
    
    }
    
    public void selectFormatAndPersist(int mode, String caminhoSaida)throws ArquivoNaoEncontradoException, EscritaNaoPermitidaException{
        String result = 1==mode?getParsedResultLines():getParsedResultColumns();
        String arquivoSaida = caminhoSaida+"/";
        arquivoSaida += "analysisTime.out".equals(this.arquivoEntrada) ? "analysisTimeTab.out" : "analysisMemoryTab.out";        
        writeResultsToFile(result,arquivoSaida);
        
    }

}
