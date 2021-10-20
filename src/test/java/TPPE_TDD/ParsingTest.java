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
public class ParsingTest {
    @Test
    public void testParseLinhas() throws ArquivoNaoEncontradoException, DelimitadorInvalidoException {
        Parser parser = new Parser("src/test/fixtures/testFixtureParsing.txt","results.txt");
        parser.setDelimitador(";");
        assertEquals(parser.getParsedResultLines() "456;782;\\n523;861;");
    }
}
