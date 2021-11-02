/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPPE_TDD;

import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author marcos
 */
public class DelimitadorTest {
    
    @Test
    public void testDelimitador() throws DelimitadorInvalidoException {
        UseParser parser = new UseParser("src/test/fixtures/testFixture.txt");
        parser.setDelimitador(";");
        assertEquals(parser.getDelimitador(), ";");
    }
    
    @Test
    public void testDelimitadorDois() throws DelimitadorInvalidoException {
        UseParser parser = new UseParser("src/test/fixtures/testFixture.txt");
        parser.setDelimitador("\t");
        assertEquals(parser.getDelimitador(), "\t");
    }    
    
    @Test
    public void testDelimitadorTres() throws DelimitadorInvalidoException {
        UseParser parser = new UseParser("src/test/fixtures/testFixture.txt");
        parser.setDelimitador("-");
        assertEquals(parser.getDelimitador(), "-");
    }    
    
    @Test(expected = DelimitadorInvalidoException.class)
    public void testDelimitadorException() throws DelimitadorInvalidoException {
        UseParser parser = new UseParser("src/test/fixtures/testFixture.txt");
        parser.setDelimitador("delimitador-invalido");
        assertEquals(parser.getDelimitador(), ";");
    }
    
}
