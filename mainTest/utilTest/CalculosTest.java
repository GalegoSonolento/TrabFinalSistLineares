package utilTest;

import org.junit.jupiter.api.Test;
import util.Calculos;
import util.Pessoa;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculosTest {
    @Test
    public void testaIMC(){
        Pessoa p1 = new Pessoa("01", "Jorge", "M", 35, 80, 1.70);
        Calculos c1 = new Calculos();
        assertEquals(27.68, c1.calculaIMC(p1.getPeso(), p1.getAltura()), 2);
    }
}
