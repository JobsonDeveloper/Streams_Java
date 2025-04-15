package br.com.jobson;

import br.com.jobson.tarefa_streams.Pessoa;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppTest {
    @Test
    public void imprimeResultado() {
        Pessoa carlos = new Pessoa("Carlos", "M");
        Pessoa ana = new Pessoa("Ana", "F");
        Pessoa victor = new Pessoa("Victor", "M");

        ArrayList<Pessoa> lista = new ArrayList<>();
        lista.add(carlos);
        lista.add(ana);
        lista.add(victor);

        if (lista.size() > 0) {
            // ---- Imprime a lista completa
            System.out.println("-----------LISTA-------------");
            lista.forEach(pessoa -> {
                System.out.println(pessoa.getNome() + ", " + pessoa.getSexo());
            });

            Stream<Pessoa> dadosStream = lista.stream();
            ArrayList<Pessoa> mulheres = dadosStream.filter(pessoa -> pessoa.getSexo().equals("F"))
                    .collect(Collectors.toCollection(ArrayList::new));

            /* Adicionando um homem após a criação da Stream de mulheres,
            * Para validar se o teste está funcionando */
//            mulheres.add(carlos);

            if (mulheres.size() > 0) {
                System.out.println("------------MELHERES------------");
                mulheres.forEach(pessoa -> {
                    System.out.println(pessoa.getNome());

                    // TESTE DE VERIFICAÇÃO DE SEXO FEMININO
                    Assert.assertEquals("F", pessoa.getSexo());
                });
            }
        } else {
            System.out.println("A lista está vazia.");
        }
    }
}
