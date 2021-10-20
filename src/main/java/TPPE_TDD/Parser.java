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
   private String delimitador;
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
            this.delimitador = delimitador;
        }else{
            throw new DelimitadorInvalidoException();
        }
    }
    
    public String getDelimitador(){
        return this.delimitador;
    } 

    private ArrayList<ArrayList<Double>> matrizDeValores() throws ArquivoNaoEncontradoException{
        ArrayList<ArrayList<Double>> matriz = new ArrayList<>();
        ArrayList<Double> temp= new ArrayList<>();
        Integer current = 0;
        this.max=0;
    
        for(String line : readInput()){
                            
            if(line.startsWith("-")){
                if(current>0){
                    if(current>this.max)this.max=current;
                    current=0;
                    matriz.add(temp);
                    temp = new ArrayList<>();              
                }
                continue;
            }
            temp.add(Double.parseDouble(line));
            current++;
        }
            
            
        if(current>this.max)this.max=current;
        matriz.add(temp);
        
        return matriz;
    }
    
    public String getParsedResultLines() throws ArquivoNaoEncontradoException{
    
        String result = "";
        
        int evolution = 1 ;
        for(ArrayList<Double> item: matrizDeValores()){
            result+= evolution+ this.delimitador;
            for(Double number: item){
               result+= number+ this.delimitador;
            }
            result+= "\n";
            evolution++;
        }
      
        return result;
    
    }

   
}
