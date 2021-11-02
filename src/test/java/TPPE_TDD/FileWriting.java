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
    public void testWriteResults() throws ArquivoNaoEncontradoException, DelimitadorInvalidoException, EscritaNaoPermitidaException {
        UseParser parser = new UseParser("analysisMemory.out");
        parser.setDelimitador(";");
        parser.selectFormatAndPersist(1,"results");
        File file = new File("results/analysisMemoryTab.out");
        assertTrue(file.exists());
    }

    @Test
    public void testWriteResultsDOis() throws ArquivoNaoEncontradoException, DelimitadorInvalidoException, EscritaNaoPermitidaException {
        UseParser parser = new UseParser("analysisTime.out");
        parser.setDelimitador(";");
        parser.selectFormatAndPersist(1,"results");
        File file = new File("results/analysisTimeTab.out");
        assertTrue(file.exists());
    }
    
    @Test
    public void testWriteResultsThree() throws ArquivoNaoEncontradoException, DelimitadorInvalidoException, EscritaNaoPermitidaException {
        UseParser parser = new UseParser("analysisMemory.out");
        parser.setDelimitador(",");
        parser.selectFormatAndPersist(0,"results");
        File file = new File("results/analysisMemoryTab.out");
        assertTrue(file.exists());
    }
}
