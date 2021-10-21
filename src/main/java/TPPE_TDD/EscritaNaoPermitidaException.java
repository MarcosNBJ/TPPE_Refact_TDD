/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPPE_TDD;

/**
 *
 * @author marcos
 */
public class EscritaNaoPermitidaException extends Exception {
    public EscritaNaoPermitidaException(){
        super("Escrita nesse diretorio nao eh permitida");
    }
    
}
