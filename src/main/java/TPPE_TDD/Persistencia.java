/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPPE_TDD;

import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcos
 */
public class Persistencia {
    
    private String arquivoEntrada;
    private String caminhoSaida;
    
    public Persistencia(String arquivoEntrada){
        this.arquivoEntrada = arquivoEntrada;
    }
    
    public void setCaminhoSaida(String caminhoSaida){
        this.caminhoSaida = caminhoSaida;
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
    
    
    public void writeResultsToFile(String content) throws ArquivoNaoEncontradoException, EscritaNaoPermitidaException{
        
        String arquivoSaida = this.caminhoSaida+"/";
        arquivoSaida += "analysisTime.out".equals(this.arquivoEntrada) ? "analysisTimeTab.out" : "analysisMemoryTab.out";   
        
        try (PrintWriter out = new PrintWriter(arquivoSaida)) {
            out.println(content);
        } catch (Exception ex) {
           throw new EscritaNaoPermitidaException();
        }
    
    }
    
}
