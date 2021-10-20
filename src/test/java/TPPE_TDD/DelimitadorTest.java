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
    public void testDelimitador() {
        Parser parser = new Parser("src/test/fixtures/testFixture.txt","results.txt");
        parser.setDelimitador(';');
        assertEquals(parser.getDelimitador(), (Character)';');
    }
    
    @Test
    public void testDelimitadorDois() {
        Parser parser = new Parser("src/test/fixtures/testFixture.txt","results.txt");
        parser.setDelimitador('\t');
        assertEquals(parser.getDelimitador(), (Character)'\t');
    }    
    
}
