/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoalgoritmosbusca;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Aluno
 */
public class segundoExercicio {

    public static void preencherVetor(int vetor[]) {
        Random random = new Random();
        int i = 0, numero;

        System.out.println("\nPreenchendo o Vetor:");

        for (i = 0; i < 49999; i++) {
            numero = random.nextInt(50000);
            System.out.println("[" + i + "] = " + numero);
            vetor[i] = numero;
        }
    }

    public static void apresentarVetor(int vetor[]) {
        int i = 0;

        System.out.println("\nApresentando o Vetor:");
        for (i = 0; i < 50000; i++) {
            System.out.println("[" + i + "] = " + vetor[i]);
        }
        System.out.println("\n===========================\n");
        System.out.println("[0] = " + vetor[0]);
        System.out.println("[10000] = " + vetor[10000]);
        System.out.println("[20000] = " + vetor[20000]);
        System.out.println("[30000] = " + vetor[30000]);
        System.out.println("[49999] = " + vetor[49999]);
        System.out.println("\n===========================\n");
    }

//===========================================================================
    public static void bubbleSort(int vetor[]) {
        int i, j, aux, trocas = 0;
        for (i = 0; i < 50000; i++) {
            for (j = i; j < 50000; j++) {
                if (vetor[j] < vetor[i]) {
                    aux = vetor[i];
                    vetor[i] = vetor[j];
                    vetor[j] = aux;
                    trocas++;
                    System.out.println("\n|Troca " + trocas + "->" + vetor[j] + " por " + vetor[i] + "|");
                }
            }
        }
        System.out.println("\n");
        apresentarVetor(vetor);
        System.out.println("\nFora(m) Realizada(s) " + trocas + " Troca(s).\n\n");
    }
//===========================================================================
    public static void trocar(int vetor[], int i, int j) {
        int aux = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = aux;
    }

    public static int dividir(int vetor[], int inicio, int fim) {
        int pivo, esquerda, direita = fim;
        esquerda = inicio + 1;
        pivo = vetor[inicio];

        while (esquerda <= direita) {
            //Percorrendo o vetor até ultrapassar o ponteiro
            //Ou até o elemento ser menor que o pivo
            while (esquerda <= direita && vetor[esquerda] <= pivo) {
                esquerda++;
            }

            //Percorrendo o vetor até ultrapassar o outro ponteiro
            //Ou até o elemento ser maior que o pivo
            while (direita >= esquerda && vetor[direita] > pivo) {
                direita--;
            }

            /*
            Caso os ponteiros não se cruzem
            Implica que os valores maiores e menores 
            foram encontrados nos dois lados. 
            Então trocamos estes elementos de lado.
             */
            if (esquerda < direita) {
                trocar(vetor, direita, esquerda);
                esquerda++;
                direita--;
            }
        }
        trocar(vetor, inicio, direita);
        return direita;
    }

    public static void quickSort(int vetor[], int inicio, int fim) {
        
        if (fim > inicio) {
            //Dividindo o vetor em 3 partes
            int indicePivo = dividir(vetor, inicio, fim);
            /*Uma chamada recursiva para dividir 
        elementos menores que o pivô*/
            quickSort(vetor, inicio, indicePivo - 1);
            /*Redividindo o vetor de elementos
         maiores que o pivô*/
            quickSort(vetor, indicePivo + 1, fim);

        }
    }
//===========================================================================
    public static void heapify(int vetor[], int n, int i) {
        int maior = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;

        //Se o elemento da esquerda for maior que o pivo
        if (esquerda < n && vetor[esquerda] > vetor[maior]) {
            maior = esquerda;
        }

        //Se o elemento da direita for o maior até então
        if (direita < n && vetor[direita] > vetor[maior]) {
            maior = direita;
        }

        //Se o maior não for o pivo
        if (maior != i) {
            int troca = vetor[i];
            vetor[i] = vetor[maior];
            vetor[maior] = troca;

            //Recursividade
            heapify(vetor, n, maior);
        }
    }

    public static void heapSort(int vetor[]) {
        int n = vetor.length;
        //Contruir Heap
        for (int i = ((n / 2) - 1); i >= 0; i--) {
            heapify(vetor, n, i);
        }
        //Extrai elemento por elemento
        for (int i = n - 1; i >= 0; i--) {
            //Move o pivo atual para a posição final
            int aux = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = aux;
            //Chama o heapfy no heap reduzido
            heapify(vetor, i, 0);
        }
    }
//===========================================================================
    public static void insertionSort(int vetor[]){
        int pivo, j;
        for(int i = 0; i<50000; i++){
            pivo = vetor[i];
            j = i - 1;
            /*
            Mover elementos de uma posição
            maior que o pivo, para uma posição acima
            da posição atual
            */
            while(j>= 0 && vetor[j]>pivo){
                vetor[j+1] = vetor[j];
                j = j - 1;
            }
            vetor[j+1]=pivo;
        }
    }
//===========================================================================
    


public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int[] vetor = new int[50000];
        int op = 0, elem;

        do {
            System.out.println("\n\nMenu");
            //Tive problemas para evitar criar numeros repetidos
            System.out.println("\n1 - Preencher no Vetor");
            System.out.println("\n2 - Apresentar Vetor");
            System.out.println("\n3 - Ordenar o Vetor com Bubble Sort");
            System.out.println("\n4 - Ordenar o Vetor com Quick Sort");
            System.out.println("\n5 - Ordenar o Vetor com Heap Sort");
            System.out.println("\n6 - Ordenar o Vetor com Insertion Sort");
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
                    bubbleSort(vetor);
                    break;
                case 4:
                    quickSort(vetor, 0, 49999);
                    break;
                case 5:
                    heapSort(vetor);
                    break;
                case 6:
                    insertionSort(vetor);
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
