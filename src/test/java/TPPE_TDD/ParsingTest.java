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
        assertEquals(parser.getParsedResultLines(), "1;456.0;782.0;\n2;523.0;861.0;\n");
    }
    @Test
    public void testParseLinhasDois() throws ArquivoNaoEncontradoException, DelimitadorInvalidoException {
        Parser parser = new Parser("src/test/fixtures/testFixtureParsing.txt","results.txt");
        parser.setDelimitador("-");
        assertEquals(parser.getParsedResultLines(), "1-456.0-782.0-\n2-523.0-861.0-\n");
    }
    @Test
    public void testParseLinhasTres() throws ArquivoNaoEncontradoException, DelimitadorInvalidoException {
        Parser parser = new Parser("src/test/fixtures/testFixtureParsingDois.txt","results.txt");
        parser.setDelimitador(";");
        assertEquals(parser.getParsedResultLines(), "1;1000.0;782.0;\n2;523.0;861.0;\n");
    }
}
