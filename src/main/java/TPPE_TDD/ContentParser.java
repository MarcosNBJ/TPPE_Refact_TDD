/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPPE_TDD;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcos
 */
public class ContentParser {
    
    
    private Integer maxLines;
    private String delimitador;

    public ContentParser(String delimitador){
        this.delimitador = delimitador;
    }
    
    private ArrayList<ArrayList<Double>> matrizDeValores(List<String> content) throws ArquivoNaoEncontradoException{
        ArrayList<ArrayList<Double>> matriz = new ArrayList<>();
        ArrayList<Double> temp= new ArrayList<>();
        Integer current = 0;
        this.maxLines=0;

        for(String line : content){

            if(line.startsWith("-")){
                if(current>0){
                    if(current>this.maxLines)this.maxLines=current;
                    current=0;
                    matriz.add(temp);
                    temp = new ArrayList<>();              
                }
                continue;
            }
            temp.add(Double.parseDouble(line));
            current++;
        }


        if(current>this.maxLines)this.maxLines=current;
        matriz.add(temp);

        return matriz;
    }   
        
    public String getParsedResultLines(List<String> content) throws ArquivoNaoEncontradoException{
    
        String result = "";
        
        int evolution = 1 ;
        for(ArrayList<Double> item: matrizDeValores(content)){
            result+= evolution+ this.delimitador;
            for(Double number: item){
               result+= number+ this.delimitador;
            }
            result+= "\n";
            evolution++;
        }
      
        return result;
    
    }
    
    public String getParsedResultColumns(List<String> content) throws ArquivoNaoEncontradoException{
    
        String result = "";
        ArrayList<ArrayList<Double>> matriz = matrizDeValores(content);
        
        for(int i =1;i<=matriz.size();i++){
           result+= i+this.delimitador;
        }
        
        result+="\n";
        
        for(int j=0; j<maxLines;j++){
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
    
    
}
