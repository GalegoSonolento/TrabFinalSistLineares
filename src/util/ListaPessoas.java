package util;

import java.util.ArrayList;

public class ListaPessoas {
    private ArrayList<Pessoa> pessoas = new ArrayList<>();

    public ListaPessoas(){}

    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(ArrayList<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
}
