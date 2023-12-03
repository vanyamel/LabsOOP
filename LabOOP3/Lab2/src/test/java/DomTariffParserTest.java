import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.example.parser.DomTariffParser;
import org.example.model.Tariff;

import java.util.List;

public class DomTariffParserTest {
    @Test
    public void testParseTariffs() throws Exception {
        DomTariffParser parser = new DomTariffParser();
        List<Tariff> tariffs = parser.parseTariffs("src/test/resources/tariffs.xml");

        assertFalse(((List<?>) tariffs).isEmpty());
    }
}