/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoalgoritmosbusca;

import java.util.Scanner;

/**
 *
 * @author Aluno
 */
public class primeiroExercicio {

    public static void preencherVetor(int vetor[]) {
        int i = 0;
        System.out.println("\nPreenchendo o Vetor:");
        for (i = 0; i < 100000; i++) {
            vetor[i] = i + 1;
            System.out.println("[" + i + "] = " + vetor[i]);
        }

    }

    public static void apresentarVetor(int vetor[]) {
        int i = 0;

        System.out.println("\nApresentando o Vetor:");
        for (i = 0; i < 100000; i++) {
            System.out.println("[" + i + "] = " + vetor[i]);
        }
    }

// ===========================================================================
    public static int buscaSequencial(int elem, int vetor[]) {
        int i = 0;
        while (vetor != null) {

            if (vetor[i] == elem) {
                return i; // achou na posição i
            } else if (elem != vetor[i] && elem > vetor[i]) {
                i++;
            }

            if (vetor[i] > elem) {
                return -1; // não achou
            }

        }
        return 0;
    }

    public static int buscaBinaria(int elem, int vetor[]) {
        int inicio = 0;
        int fim = 99999;
        int meio;
        while (inicio <= fim) {
            meio = (inicio + fim) / 2;
            System.out.println("\nMeio: " + meio + "\n");
            if (elem == vetor[meio]) {
                return meio;
            }
            if (elem < vetor[meio]) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }
        return -1; // não encontrado
    }
// ===========================================================================

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int[] vetor = new int[100000];
        int op = 0, elem, retorno;

        do {
            System.out.println("\n\nMenu");
            System.out.println("\n1 - Preencher no Vetor");
            System.out.println("\n2 - Apresentar Vetor");
            System.out.println("\n3 - Executar Busca Sequencial no Vetor");
            System.out.println("\n4 - Executar Busca Binaria no Vetor");
            System.out.println("\n0 - Sair");

            System.out.print("\nSelecione uma Opção:\nR: ");
            op = ler.nextInt();

            switch (op) {
                case 1:
                    preencherVetor(vetor);
                    break;
                case 2:
                    apresentarVetor(vetor);
                    break;
                case 3:
                    System.out.print("\nInsira o elemento: ");
                    elem = ler.nextInt();
                    retorno = buscaSequencial(elem, vetor);
                    if (retorno != -1) {
                        System.out.println("\nA chave foi encontrada na posição " + retorno + ".\n\n");
                    } else {
                        System.out.println("\nA chave não foi encontrada no vetor.\n\n");
                    }
                    break;
                case 4:
                    System.out.print("\nInsira o elemento: ");
                    elem = ler.nextInt();
                    retorno = buscaBinaria(elem, vetor);
                    if (retorno != -1) {
                        System.out.println("\nA chave foi encontrada na posição " + retorno + ".\n\n");
                    } else {
                        System.out.println("\nA chave não foi encontrada no vetor.\n\n");
                    }

                    break;
                case 0:
                    System.out.println("\nPrograma Finalizado.\n");
                    break;
                default:
                    System.out.println("\nComando Inválido.\n");
                    break;
            }

        } while (op != 0);

    }

}
