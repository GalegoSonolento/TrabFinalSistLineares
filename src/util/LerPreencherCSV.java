package util;

import java.io.*;
import java.util.ArrayList;

public class LerPreencherCSV {
    private String header;
    private String path = "./resources/files/list.txt";

    public ArrayList<Pessoa> preencheLista(ArrayList<Pessoa> list){

        header = "";

        try (BufferedReader br = new BufferedReader(new FileReader(path))){

            String line = br.readLine();
            header = line;
            line = br.readLine();
            while (line != null){
                String[] pes = line.split(",");
                String code = pes[0];
                String nome = pes[1];
                String sexo = pes[2];
                int idade = Integer.parseInt(pes[3]);
                double peso = Double.parseDouble(pes[4]);
                double altura = Double.parseDouble(pes[5]);
                Pessoa p1 = new Pessoa(code, nome, sexo, idade, peso, altura);
                list.add(p1);
                line = br.readLine();
            }

        } catch (IOException e){
            System.out.println("ERRO: " + e.getMessage());
        }
        return list;
    }

    public void geraCSV(ArrayList<Pessoa> list){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))){

            bw.write(header);
            for (Pessoa p : list){
                bw.newLine();
                String code = p.getCode();
                String nome = p.getNome();
                String sexo = p.getSexo();
                String idade = String.valueOf(p.getIdade());
                String peso = String.valueOf(p.getPeso());
                String altura = String.valueOf(p.getAltura());
                bw.write(code + "," + nome + "," + sexo + "," + idade + "," + peso + "," + altura);
            }
        } catch (IOException e){
            System.out.println("ERRO: " + e.getMessage());
        }
    }
}
