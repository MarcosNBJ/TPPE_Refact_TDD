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
public class FileReadingTest {
    

    @Test
    public void testLeArquivo() throws ArquivoNaoEncontradoException {
        UseParser parser = new UseParser("src/test/fixtures/testFixture.txt");
        List<String> fileContents = parser.readInput();
        assertEquals(fileContents.get(0), "test file contents");
    }
    
    @Test
    public void testLeArquivoDois() throws ArquivoNaoEncontradoException {
        UseParser parser = new UseParser("src/test/fixtures/testFixtureDois.txt");
        List<String> fileContents = parser.readInput();
        assertEquals(fileContents.get(0), "second test file contents");
    }
    
    @Test
    public void testLeArquivoTres() throws ArquivoNaoEncontradoException {
        UseParser parser = new UseParser("src/test/fixtures/testFixtureTres.txt");
        List<String> fileContents = parser.readInput();
        assertEquals(fileContents.get(0), "third test file contents");
    }
 
    @Test(expected = ArquivoNaoEncontradoException.class)
    public void testLeArquivoException() throws ArquivoNaoEncontradoException {
        UseParser parser = new UseParser("src/test/fixtures/unexistent.txt");
        List<String> fileContents = parser.readInput();
        assertEquals(fileContents.get(0), "");
    }
}
