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
        Parser parser = new Parser("src/test/fixtures/testFixtureParsing.txt","results.txt");
        parser.setDelimitador(";");
        parser.writeResults(1);
        File file = new File("results.txt");
        assertTrue(file.exists());
    }
}
