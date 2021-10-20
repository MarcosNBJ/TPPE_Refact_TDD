/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPPE_TDD;

import java.util.List;
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
    public void testLeArquivo() throws ArquivoNaoEncontradoException {
        Parser parser = new Parser("src/test/fixtures/testFixture.txt","results.txt");
        List<String> fileContents = parser.readInput();
        assertEquals(fileContents.get(0), "test file contents");
    }
    
    @Test
    public void testLeArquivoDois() throws ArquivoNaoEncontradoException {
        Parser parser = new Parser("src/test/fixtures/testFixtureDois.txt","results.txt");
        List<String> fileContents = parser.readInput();
        assertEquals(fileContents.get(0), "second test file contents");
    }
    
    @Test
    public void testLeArquivoTres() throws ArquivoNaoEncontradoException {
        Parser parser = new Parser("src/test/fixtures/testFixtureTres.txt","results.txt");
        List<String> fileContents = parser.readInput();
        assertEquals(fileContents.get(0), "third test file contents");
    }
 
    @Test(expected = ArquivoNaoEncontradoException.class)
    public void testLeArquivoException() throws ArquivoNaoEncontradoException {
        Parser parser = new Parser("src/test/fixtures/unexistent.txt","results.txt");
        List<String> fileContents = parser.readInput();
        assertEquals(fileContents.get(0), "");
    }
}
