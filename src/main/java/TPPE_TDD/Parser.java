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
public class Parser {

   private String arquivoEntrada;
   private String delimitador;
   private Integer max;

    public Parser(String arquivoEntrada) {
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
    
    public String getParsedResultColumns() throws ArquivoNaoEncontradoException{
    
        String result = "";
        ArrayList<ArrayList<Double>> matriz = matrizDeValores();
        
        for(int i =1;i<=matriz.size();i++){
           result+= i+this.delimitador;
        }
        
        result+="\n";
        
        for(int j=0; j<max;j++){
          for(int i =0;i<matriz.size();i++){
             if(matriz.get(i).size()>j)
                result+= matriz.get(i).get(j)+this.delimitador;
             else
                 result+="\t";
          }  
          result+="\n";
        }
        
        return result;
    
    }

    public void writeResults(int mode, String caminhoSaida) throws ArquivoNaoEncontradoException, EscritaNaoPermitidaException{
        
        String result = 1==mode?getParsedResultLines():getParsedResultColumns();
        String arquivoSaida = caminhoSaida+"/";
        arquivoSaida += "analysisTime.out".equals(this.arquivoEntrada) ? "analysisTimeTab.out" : "analysisMemoryTab.out";

        
        try (PrintWriter out = new PrintWriter(arquivoSaida)) {
            out.println(result);
        } catch (Exception ex) {
           throw new EscritaNaoPermitidaException();
        }
    
    }
    

}
