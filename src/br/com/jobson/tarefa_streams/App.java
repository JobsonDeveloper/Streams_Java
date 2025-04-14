package br.com.jobson.tarefa_streams;

import br.com.jobson.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome e o sexo das pessoas dividido por uma vírgula.");
        System.out.println("Exemplo: Carlos,masculino");
        String resposta = scanner.nextLine();

        String[] arrayPessoas = resposta.split(",");
        List<Pessoa> lista = new ArrayList<>();

        // Forma a lista separando por masculino e feminino
        for (int i = 0; i < arrayPessoas.length; i++) {
            if ((i != 0) && (i % 2 != 0)) {
                if (arrayPessoas[i].toLowerCase().contains("f")) {
                    arrayPessoas[i] = "F";
                } else {
                    arrayPessoas[i] = "M";
                }

                Pessoa pessoa = new Pessoa(arrayPessoas[i - 1], arrayPessoas[i]);
                lista.add(pessoa);
            }
        }

        // Imprime a lista completa
        if (lista.size() > 0) {
            System.out.println("-----------LISTA-------------");
            lista.forEach(pessoa -> {
                System.out.println(pessoa.getNome() + ", " + pessoa.getSexo());
            });
        }

        // Verifica se tem mulheres na lista e forma uma lista só com elas
        if (lista.size() >= 0) {
            Stream<Pessoa> mulheres = lista.stream().filter(pessoa -> pessoa.getSexo().equals("F"));

            System.out.println("------------MELHERES------------");
            mulheres.forEach(pessoa -> {
                System.out.println(pessoa.getNome());
            });
        } else {
            System.out.println("A lista está vazia.");
        }
    }
}
