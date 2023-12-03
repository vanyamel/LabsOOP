import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.example.util.XmlValidator;

public class XmlValidatorTest {
    @Test
    public void testValidateXMLSchema() {
        boolean isValid = XmlValidator.validateXMLSchema("src/test/resources/tariffs.xsd", "src/test/resources/tariffs.xml");
        assertTrue(isValid);
    }
}