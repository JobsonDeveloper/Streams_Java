package br.com.jobson;

import java.util.List;
import java.util.Objects;

public class Pessoa {
    private String nome;
    private String sexo;

    public Pessoa(String nome, String sexo) {
        this.nome = nome;
        this.sexo = sexo;
    }
//
//    public Pessoa(Pessoa pessoa) {
//        this();
//    }

    public String getSexo() {
        return sexo;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", sexo='" + sexo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(nome, pessoa.nome) && Objects.equals(sexo, pessoa.sexo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, sexo);
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

//    public void criaPessoa(String nome, String sexo) {
//            this.nome = nome;
//            this.sexo = sexo;
//        Pessoa pessoa2 = new Pessoa("Vilma", "F");
//        Pessoa pessoa3 = new Pessoa("Anderson", "M");
//        Pessoa pessoa4 = new Pessoa("Maria", "F");
//        return List.of(pessoa);
//    }
}
