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
public class DelimitadorInvalidoException extends Exception{
    
    public DelimitadorInvalidoException() {
       super("Delimitador Invalido, o delimitador deve ser um unico caracter");
    }
}