package util;

public class Calculos {
    public Calculos(){}

    public double calculaIMC(double peso, double altura){
        return peso / Math.pow(altura, 2);
    }

    public double pesoIdeal(String sexo, double altura){
        int k = testaSexo(1, sexo);
        altura = altura * 100;
        return (altura - 100) - ((altura - 150) / k);
    }

    public double taxaDeGorduraCorporal(String sexo, int idade, double peso, double altura){
        int S = testaSexo(0, sexo);
        double imc = calculaIMC(peso, altura);
        return (1.2 * imc) - (10.8 * S) + (0.23 * idade) - 5.4;
    }

    private int testaSexo(int opcao, String sexo){
        /**
         * Esse método recebe um inteiro de opção e uma String referente ao sexo
         * Se opcao == 1, o cálculo é referente ao peso ideal.
         * Se opcao == qql outra coisa (preferencialente 0), o cálculo é referente à taxa de gordura corporal
         * O sexo é autoexplicativo.
         */
        if (sexo.equalsIgnoreCase("m")){
            if (opcao == 1) return 4;
            return 1;
        }
        if (opcao == 1) return 2;
        return 0;
    }
}
