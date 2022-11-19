package funcional;

import ui.Ui;
import util.LerPreencherCSV;
import util.ListaPessoas;
import util.Pessoa;
import util.Calculos;

import java.util.Scanner;

public class Funcional {
    private LerPreencherCSV csv = new LerPreencherCSV();
    private final Ui ui = new Ui();
    ListaPessoas pessoas = new ListaPessoas();
    Calculos c = new Calculos();

    public void rodaPrograma(){
        Scanner scanner = new Scanner(System.in);
        pessoas.setPessoas(csv.preencheLista(pessoas.getPessoas()));
        int opcao = 0;
        ui.telaIncial();
        do{
            ui.menu();
            System.out.println("Escolha sua opção: ");
            try {
                opcao = Integer.parseInt(scanner.next());
            } catch (Exception e){
                opcao = -1;
            }
            if (opcao == 1){
                inserirPessoa();
                System.out.println("Inserido!");
                waitTime();
            }
            else if (opcao == 2) {
                calculaIMC();
                waitTime();
            }
            else if (opcao == 3) {
                calculaPesoIdeal();
                waitTime();
            }
            else if (opcao == 4){
                calculaTaxaDeGordura();
                waitTime();
            }
            else if (opcao == 5) {
                for(int i=0;i<pessoas.getPessoas().size();i++ ){
                    System.out.println("----------------------------------------------");
                    System.out.println("Nome: " + pessoas.getPessoas().get(i).getNome());
                    System.out.println("IMC: " + c.calculaIMC(pessoas.getPessoas().get(i).getPeso(), pessoas.getPessoas().get(i).getAltura()));
                    System.out.println("Peso Ideal: " +  c.pesoIdeal(pessoas.getPessoas().get(i).getSexo(), pessoas.getPessoas().get(i).getAltura()));
                    System.out.println("Taxa de Gordura: " + c.taxaDeGorduraCorporal(pessoas.getPessoas().get(i).getSexo(), pessoas.getPessoas().get(i).getIdade(),  pessoas.getPessoas().get(i).getPeso(), pessoas.getPessoas().get(i).getAltura()));
                    System.out.println("---------------------------------------------");
                }
                waitTime();
            }
            else if (opcao == 6) {
                System.out.println("Volte sempre!");
                scanner.close();
                break;
            }
            else{
                System.out.println("Defina um valor inteiro válido!");
            }
        } while (true);
    }

   private void calculaIMC() {
       Scanner scanner  = new Scanner(System.in);
       System.out.println("Digite o seu código: ");
       String code = scanner.next();
       String nome = "";
       boolean achou = false;
       for(int i=0;i<pessoas.getPessoas().size();i++ ){
           if(pessoas.getPessoas().get(i).getCode().equalsIgnoreCase(code)){
                double resp = c.calculaIMC(pessoas.getPessoas().get(i).getPeso(), pessoas.getPessoas().get(i).getAltura());
                nome = pessoas.getPessoas().get(i).getNome();
                System.out.println("O IMC de " + nome + " é " + resp);
                achou = true;
                break;
           }
       }
       if (!achou)
           System.out.println("Código não encontrado no banco de dados!");
  }
    private void calculaPesoIdeal() {
        Scanner scanner  = new Scanner(System.in);
        System.out.println("Digite o seu código: ");
        String code = scanner.next();
        String nome = "";
        boolean achou = false;
        for(int i=0;i<pessoas.getPessoas().size();i++ ){
            if(pessoas.getPessoas().get(i).getCode().equalsIgnoreCase(code)){
                double resp = c.pesoIdeal(pessoas.getPessoas().get(i).getSexo(), pessoas.getPessoas().get(i).getAltura());
                nome = pessoas.getPessoas().get(i).getNome();
                System.out.println("O Peso ideal de " + nome + " é " + resp);
                achou = true;
                break;
            }
        }
        if (!achou)
            System.out.println("Código não encontrado no banco de dados!");
    }

    private void calculaTaxaDeGordura() {
        Scanner scanner  = new Scanner(System.in);
        System.out.println("Digite o seu código: ");
        String code = scanner.next();
        String nome = "";
        boolean achou = false;
        for(int i=0;i<pessoas.getPessoas().size();i++ ){
            if(pessoas.getPessoas().get(i).getCode().equalsIgnoreCase(code)){
                double resp = c.taxaDeGorduraCorporal(pessoas.getPessoas().get(i).getSexo(), pessoas.getPessoas().get(i).getIdade(),  pessoas.getPessoas().get(i).getPeso(), pessoas.getPessoas().get(i).getAltura());
                nome = pessoas.getPessoas().get(i).getNome();
                System.out.println("A taxa de gordura de " + nome + " é " + resp);
                achou = true;
                break;
            }
        }
        if (!achou)
            System.out.println("Código não encontrado no banco de dados!");
    }


    private void waitTime(){
        try{
            Thread.sleep(1000);
        }catch(Exception ignored){}
    }

    private void inserirPessoa() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Forneça seus dados: ");

        System.out.println("Código: ");
        String codigo = scanner.next();
        boolean testeCode;
        do {
            testeCode = false;
            for (Pessoa p1 : pessoas.getPessoas()) {
                if (codigo.equalsIgnoreCase(p1.getCode())) {
                    System.out.println("Código já utilizado! " +
                            "\nDigite outro: ");
                    codigo = scanner.next();
                    testeCode = true;
                }
            }
        } while (testeCode);

        System.out.println("Nome: ");
        String nome = scanner.next();

        System.out.println("Sexo [M/F]: ");
        String sexo = scanner.next();
        while (!sexo.equalsIgnoreCase("m") && !sexo.equalsIgnoreCase("f")) {
            System.out.println("Input de sexo inválido! Tente novamente: ");
            sexo = scanner.next();
        }

        System.out.println("Idade: ");
        int idade = -1;
        do {
            try {
                idade = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                idade = -1;
            }
            if (idade < 0) System.out.println("Coloque uma idade válida");
        } while (idade < 0);

        System.out.println("Peso: ");
        double peso = -1;
        do {
            try {
                peso = Double.parseDouble(scanner.next());
            } catch (Exception e) {
                peso = -1;
            }
            if (peso < 0) System.out.println("Coloque um peso válido");
        } while (peso < 0);

        System.out.println("Altura: ");
        double altura = -1;
        do {
            try {
                altura = Double.parseDouble(scanner.next());
            } catch (Exception e) {
                altura = -1;
            }
            if (altura < 0 || altura > 5) System.out.println("Coloque uma altura válida - altura dada em metros");
        } while (altura < 0 || altura > 5);

        Pessoa p1 = new Pessoa(codigo, nome, sexo, idade, peso, altura);
        pessoas.getPessoas().add(p1);
    }
}
