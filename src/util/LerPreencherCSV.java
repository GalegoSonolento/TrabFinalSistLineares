package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LerPreencherCSV {
    private String header;

    public ArrayList<Pessoa> preencheLista(ArrayList<Pessoa> list){
        String path = "./resources/files/list.txt";

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
        System.out.println(list.size());
        return list;
    }
}
