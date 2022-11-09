package util;

public class Calculos {
    public Calculos(){}

    public double calculaIMC(double peso, double altura){
        return peso / Math.pow(altura, 2);
    }
}
