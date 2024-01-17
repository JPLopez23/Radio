import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarRadioTest {
    CarRadio radio = new CarRadio();

    @Test
    void testSwitchOnOff() {
        assertFalse(radio.isOn());
        radio.switchOnOff();
        assertTrue(radio.isOn());
    }

    @Test
    void testSwitchAMFM() {
        radio.switchOnOff(); // Encender el radio primero
        assertTrue(radio.isAm());
        radio.switchAMFM();
        assertFalse(radio.isAm());
    }

    @Test
    void testSaveAndSelectStation() {
        radio.switchOnOff(); // Encender el radio y establecer en AM por defecto
        radio.saveStation(1, 600); // Guardar una estación AM
        assertEquals(600, radio.selectStation(1), 0.0);
        radio.switchAMFM(); // Cambiar a FM
        radio.saveStation(1, 88.1); // Guardar una estación FM
        assertEquals(88.1, radio.selectStation(1), 0.0);
    }

}
