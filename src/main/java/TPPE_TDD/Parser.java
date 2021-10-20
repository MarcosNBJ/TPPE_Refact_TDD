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

    public Parser(String arquivoEntrada, String arquivoSaida) {
        this.arquivoEntrada = arquivoEntrada;
        this.arquivoSaida = arquivoSaida;
    }

    List<String> readInput() {
        
        List<String> content = new ArrayList<>();
        
        try {
            content = Files.readAllLines(Paths.get(this.arquivoEntrada), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            
        }
        return content;
    }

   
    
    
}
