package utilTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Calculos;
import util.Pessoa;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculosTest {
    private Pessoa p1;
    private Calculos c1;
    @BeforeEach
    public void inicializaExemplos(){
        p1 = new Pessoa("01", "Jorge", "M", 35, 80, 1.70);
        c1 = new Calculos();
    }
    @Test
    public void testaIMC(){
        assertEquals(27.68, c1.calculaIMC(p1.getPeso(), p1.getAltura()), 2);
    }
    @Test
    public void testaPesoIdeal(){
        assertEquals(65, c1.pesoIdeal(p1.getSexo(), p1.getAltura()), 2);
    }
    @Test
    public void testaTaxaDeGorduraCorporal(){
        assertEquals(25.066, c1.taxaDeGorduraCorporal(p1.getSexo(), p1.getIdade(), p1.getPeso(), p1.getAltura()), 3);
    }
}
