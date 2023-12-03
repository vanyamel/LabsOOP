import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.Vegetable;


class VegetableTest {

    @Test
    void testVegetableCreation() {
        Vegetable tomato = new Vegetable("Tomato", 18, "red", 34);
        assertEquals("Tomato", tomato.getName());
        assertEquals(18, tomato.getCalories());
        assertEquals("red", tomato.getColor());
        assertEquals(1.2, tomato.getVitaminContent());
    }

    @Test
    void testSettersAndGetters() {
        Vegetable cucumber = new Vegetable("Cucumber", 16, "green", 11);
        cucumber.setName("Cucumber");
        cucumber.setCalories(15);
        cucumber.setColor("green");
        cucumber.setVitaminContent(11);

        assertEquals("Cucumber", cucumber.getName());
        assertEquals(15, cucumber.getCalories());
        assertEquals("green", cucumber.getColor());
        assertEquals(11, cucumber.getVitaminContent());
    }
}
