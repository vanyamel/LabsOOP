import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.example.model.Tariff;
import org.example.model.Parameters;
import org.example.model.CallPrices;

public class TariffTest {
    @Test
    public void testTariff() {
        CallPrices callPrices = new CallPrices(0.5, 1.0, 1.5);
        Parameters parameters = new Parameters(2, "Minute", 10);
        Tariff tariff = new Tariff("id1", "Basic Plan", "Operator A", 100.0, callPrices, 0.2, parameters);

        assertEquals("id1", tariff.getId());
        assertEquals("Basic Plan", tariff.getName());
        assertEquals("Operator A", tariff.getOperatorName());
        assertEquals(100.0, tariff.getPayroll());
        assertEquals(0.2, tariff.getSmsPrice());
        assertEquals(callPrices, tariff.getCallPrices());
        assertEquals(parameters, tariff.getParameters());
    }
}