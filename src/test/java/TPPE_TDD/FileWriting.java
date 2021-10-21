/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPPE_TDD;

import java.io.File;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author marcos
 */
public class FileWriting {
    @Test
    public void testWriteResults() throws ArquivoNaoEncontradoException, DelimitadorInvalidoException {
        Parser parser = new Parser("analysisMemory.out");
        parser.setDelimitador(";");
        parser.writeResults(1,"results");
        File file = new File("results/analysisMemoryTab.out");
        assertTrue(file.exists());
    }

    @Test
    public void testWriteResultsDOis() throws ArquivoNaoEncontradoException, DelimitadorInvalidoException {
        Parser parser = new Parser("analysisTime.out");
        parser.setDelimitador(";");
        parser.writeResults(1,"results");
        File file = new File("results/analysisTimeTab.out");
        assertTrue(file.exists());
    }
    
    @Test
    public void testWriteResultsThree() throws ArquivoNaoEncontradoException, DelimitadorInvalidoException {
        Parser parser = new Parser("analysisMemory.out");
        parser.setDelimitador(",");
        parser.writeResults(0,"results");
        File file = new File("results/analysisMemoryTab.out");
        assertTrue(file.exists());
    }
}
