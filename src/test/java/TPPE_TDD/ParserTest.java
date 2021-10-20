/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPPE_TDD;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marcos
 */
public class ParserTest {
    

    @Test
    public void testLeArquivo() {
        Parser parser = new Parser("src/test/fixtures/testFixture.txt","results.txt");
        String fileContents = parser.readInput();
        assertEquals(fileContents, "test file contents");
    }
    
    @Test
    public void testLeArquivoDois() {
        Parser parser = new Parser("src/test/fixtures/testFixtureDois.txt","results.txt");
        String fileContents = parser.readInput();
        assertEquals(fileContents, "second test file contents");
    }
    
    
}
