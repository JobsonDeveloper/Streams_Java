package br.com.jobson.tarefa_streams;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pessoa> listaCompleta = new ArrayList<>();
        String resposta = "";

        while (!"0".equals(resposta)) {
            System.out.println("Digite 0 para sair." +
                    "\nDigite o nome e o sexo da pessoa separados por uma vírgula." +
                    "\nExemplo: Carlos,masculino\n");
            resposta = scanner.nextLine();

            if (!"0".equals(resposta)) {
                String[] dados = verificaSexo(resposta.split(","));

                if(dados.length > 1) {
                    Pessoa pessoa =  new Pessoa(dados[0], dados[1]);
                    listaCompleta.add(pessoa);
                }
                else {
                    System.out.println("Os dados foram fornecidos de forma incorreta!\n");
                }
            }
        }

        imprimeResultado(listaCompleta);
    }

    private static String[] verificaSexo(String[] lista) {
        if (lista.length > 1) {
            if (lista[1].toLowerCase().contains("f")) {
                lista[1] = "F";
            } else {
                lista[1] = "M";
            }
        }

        return lista;
    }

    public static void imprimeResultado(ArrayList<Pessoa> lista) {
        if (lista.size() > 0) {
            // ---- Imprime a lista completa
            System.out.println("-----------LISTA-------------");
            lista.forEach(pessoa -> {
                System.out.println(pessoa.getNome() + ", " + pessoa.getSexo());
            });

            Stream<Pessoa> dadosStream = lista.stream();
            ArrayList<Pessoa> mulheres = dadosStream.filter(pessoa -> pessoa.getSexo().equals("F"))
                    .collect(Collectors.toCollection(ArrayList::new));

            if (mulheres.size() > 0) {
                System.out.println("------------MELHERES------------");
                mulheres.forEach(pessoa -> {
                    System.out.println(pessoa.getNome());
                });
            }
        } else {
            System.out.println("A lista está vazia.");
        }
    }
}
