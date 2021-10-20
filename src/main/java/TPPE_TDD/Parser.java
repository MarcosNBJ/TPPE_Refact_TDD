/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPPE_TDD;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcos
 */
public class Parser {

   private String arquivoEntrada;
   private String arquivoSaida;
   private Character delimitador;
   private Integer max;

    public Parser(String arquivoEntrada, String arquivoSaida) {
        this.arquivoEntrada = arquivoEntrada;
        this.arquivoSaida = arquivoSaida;
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
            this.delimitador = delimitador.charAt(0);
        }else{
            throw new DelimitadorInvalidoException();
        }
    }
    
    public Character getDelimitador(){
        return this.delimitador;
    } 
    

   
    
}
