package funcional;

import ui.Ui;
import util.ListaPessoas;
import util.Pessoa;

import java.io.IOException;
import java.util.Scanner;

public class Funcional {
    private final Ui ui = new Ui();
    ListaPessoas pessoas = new ListaPessoas();

    public void rodaPrograma(){
        Scanner scanner = new Scanner(System.in);
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
                System.out.println("mama");
                inserirPessoa();
                System.out.println("Inserido!");
                waitTime();
            }
            else if (opcao == 2) {
                System.out.println("opcao 2");
                waitTime();
            }
            else if (opcao == 3) {
                System.out.println("opcao 3");
                waitTime();
            }
            else if (opcao == 4){
                System.out.println("opcao 4");
                waitTime();
            }
            else if (opcao == 5) {
                System.out.println("opcao 5");
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

    private void waitTime(){
        try{
            Thread.sleep(1000);
        }catch(Exception ignored){}
    }

    private void inserirPessoa(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Forneça seus dados: ");

        System.out.println("Código: ");
        String codigo = scanner.next();

        System.out.println("Nome: ");
        String nome = scanner.next();

        System.out.println("Sexo [M/F]: ");
        String sexo = scanner.next();
        while (true){
            System.out.println("Input de sexo inválido! Tente novamente: ");
            sexo = scanner.next();
            if (sexo.equalsIgnoreCase("m") || sexo.equalsIgnoreCase("f")) break;
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
            if (altura < 0 || altura > 5) System.out.println("Coloque uma altura válida");
        } while (altura < 0 || altura > 5);

        Pessoa p1 = new Pessoa(codigo, nome, sexo, idade, peso, altura);
        pessoas.getPessoas().add(p1);
    }
}
