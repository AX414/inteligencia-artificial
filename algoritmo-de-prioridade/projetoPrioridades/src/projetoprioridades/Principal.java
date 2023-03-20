/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoprioridades;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Aluno
 */
public class Principal {

    public static String quadro[][] = new String[10][10];
    public static int vidaVilaoAtual = 3;
    public static int vidaVilaoAnterior = 3;

    public static int posicaoHeroi[] = new int[2];
    public static int posicaoVilao[] = new int[2];
    public static int posicaoBonus[] = new int[2];

    public static int prioridade[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    public static boolean pegouBonus = false;

    public static void inserirPersonagens() {
        Random linha = new Random();
        Random coluna = new Random();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                quadro[i][j] = "-";
            }

        }

        posicaoHeroi[0] = linha.nextInt(10);
        posicaoHeroi[1] = coluna.nextInt(10);

        posicaoVilao[0] = linha.nextInt(10);
        posicaoVilao[1] = coluna.nextInt(10);

        posicaoBonus[0] = linha.nextInt(10);
        posicaoBonus[1] = coluna.nextInt(10);

        quadro[posicaoHeroi[0]][posicaoHeroi[1]] = "H";
        quadro[posicaoVilao[0]][posicaoVilao[1]] = "V";
        quadro[posicaoBonus[0]][posicaoBonus[1]] = "B";

    }

    public static void teletransportarVilao() {
        Random linha = new Random();
        Random coluna = new Random();

        if (!(posicaoHeroi[0] == posicaoVilao[0]
                && posicaoHeroi[1] == posicaoVilao[1])) {
            //Tira da posição anterior
            quadro[posicaoVilao[0]][posicaoVilao[1]] = "-";
        }

        posicaoVilao[0] = linha.nextInt(10);
        posicaoVilao[1] = coluna.nextInt(10);

        quadro[posicaoVilao[0]][posicaoVilao[1]] = "V";
    }

    public static void pegarBonus() {
        if (posicaoHeroi[0] == posicaoBonus[0]
                && posicaoHeroi[1] == posicaoBonus[1]
                && pegouBonus == false) {
            pegouBonus = true;
           
            //Pega o Bonus e atualiza a posição do bonus.
            Random linha = new Random();
            Random coluna = new Random();
           
            posicaoBonus[0] = linha.nextInt(10);
            posicaoBonus[1] = coluna.nextInt(10);
        }
    }

    public static void apresentarQuadro(int vidaVilao) {
        int i = 0, j = 0;

        System.out.println("\n---------------------------------------\n"
                + "Apresentando o Tabuleiro:"
                + "\nVidas do Vilão: " + vidaVilao + "\n\n");
        for (i = 0; i < 10; i++) {
            for (j = 0; j < 10; j++) {
                System.out.print("|" + quadro[i][j] + "|");
            }
            System.out.println("\n");
        }

        System.out.println("Posição do Herói: [" + posicaoHeroi[0] + "][" + posicaoHeroi[1] + "]");
        System.out.println("Posição do Vilão: [" + posicaoVilao[0] + "][" + posicaoVilao[1] + "]");
        System.out.println("Posição do Bônus: [" + posicaoBonus[0] + "][" + posicaoBonus[1] + "]");
        if (pegouBonus == true) {
            System.out.println("Herói com Bonus!");
        } else {
            System.out.println("Herói sem Bonus.");
        }
    }

    public static int[] pegaPosicao(String rotulo) {
        int posicao[] = new int[2];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (quadro[i][j] == rotulo) {
                    posicao[0] = i;
                    posicao[1] = j;
                    return posicao;
                }
            }
        }

        return null;
    }

    public static void executarRegras(int regra) {

        switch (regra) {
            case 1:
                System.out.println("Mesma posição. Atacar!");
                vidaVilaoAnterior = vidaVilaoAtual;
                vidaVilaoAtual = vidaVilaoAtual - 1;
                break;
            case 2:
                System.out.println("\nHerói moveu para a esquerda.\n");
                posicaoHeroi[1] = posicaoHeroi[1] - 1;
                atualizarQuadro();
                break;
            case 3:
                System.out.println("\nHerói moveu para a direita.\n");
                posicaoHeroi[1] = posicaoHeroi[1] + 1;
                atualizarQuadro();
                break;
            case 4:
                System.out.println("\nHerói moveu para baixo.\n");
                posicaoHeroi[0] = posicaoHeroi[0] + 1;
                atualizarQuadro();
                break;
            case 5:
                System.out.println("\nHerói moveu para cima.\n");
                posicaoHeroi[0] = posicaoHeroi[0] - 1;
                atualizarQuadro();
                break;
            case 6:
                System.out.println("\nHerói atacou com o Bônus.");
                vidaVilaoAtual = vidaVilaoAtual - 2;
                pegouBonus = false;
                break;
            case 7:
                System.out.println("\n\nVilão Derrotado!");
                break;
            case 8:
                System.out.println("\nO Herói encontrou o Bônus!");
                pegarBonus();
                atualizarQuadro();
                break;
            case 9:
                System.out.println("\nO vilão mudou de posição.\n");
                teletransportarVilao();
                atualizarQuadro();
                vidaVilaoAnterior = vidaVilaoAtual;
                break;

        }

    }

    public static void atualizarQuadro() {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                quadro[i][j] = "-";
            }
        }
        quadro[posicaoVilao[0]][posicaoVilao[1]] = "V";
        quadro[posicaoBonus[0]][posicaoBonus[1]] = "B";
        quadro[posicaoHeroi[0]][posicaoHeroi[1]] = "H";

    }

    public static void regraProducao() {

        //R1: Se a posição do herói e do vilão for a mesma.
        if (posicaoHeroi[0] == posicaoVilao[0]
                && posicaoHeroi[1] == posicaoVilao[1]) {
            prioridade[4] = 1;
        }
        //R2: Se o número da coluna do herói for maior que o número da coluna do vilão.
        if (posicaoHeroi[1] > posicaoVilao[1]) {
            //ir para a esquerda
            prioridade[5] = 2;
        }
        //R3: Se o número da coluna do herói for menor que o número da coluna do vilão.
        if (posicaoHeroi[1] < posicaoVilao[1]) {
            //ir para a direita
            prioridade[6] = 3;
        }
        //R4: Se o número da linha do herói for menor que o número da linha do vilão.
        if (posicaoHeroi[0] < posicaoVilao[0]) {
            //ir para baixo
            prioridade[7] = 4;
        }
        //R5: Se o número da linha do herói for > que o número da linha do vilão.
        if (posicaoHeroi[0] > posicaoVilao[0]) {
            //ir para cima
            prioridade[8] = 5;
        }
        //R6: Se o herói tinha bônus e atacou o vilão.
        if (posicaoHeroi[0] == posicaoVilao[0]
                && posicaoHeroi[1] == posicaoVilao[1]
                && pegouBonus == true) {
            prioridade[3] = 6;

        }
        //R7: Se a posição do herói e do corpo sem vida do vilão for a mesma.
        if (posicaoHeroi[0] == posicaoVilao[0]
                && posicaoHeroi[1] == posicaoVilao[1]
                && vidaVilaoAtual == 0) {
            prioridade[0] = 7;
        }
        //R8: Se a posição do herói e do bônus forem a mesma.
        if (posicaoHeroi[0] == posicaoBonus[0]
                && posicaoHeroi[1] == posicaoBonus[1]) {
            prioridade[2] = 8;

        }
        //R9: Se o vilão foi atacado.
        if (vidaVilaoAtual < vidaVilaoAnterior) {
            //Se foi atacado, cria outra posição pro vilão 
            prioridade[1] = 9;
        }

    }

    public static void apresentarVetorPrioridade() {
        System.out.println("\nVetor de Prioridade: ");
        for (int i = 0; i < 9; i++) {
            System.out.print("|" + prioridade[i] + "|");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        inserirPersonagens();
        atualizarQuadro();
        apresentarQuadro(vidaVilaoAtual);

        do {
            regraProducao();

            apresentarVetorPrioridade();

            for (int i = 0; i < 9; i++) {
                if (prioridade[i] != 0) {
                    executarRegras(prioridade[i]);
                    for (int j = 0; j < 9; j++) {
                        prioridade[j] = 0;
                    }
                    break;
                }
            }

            apresentarQuadro(vidaVilaoAtual);
        } while (vidaVilaoAtual > 0 && vidaVilaoAtual <= 3);

        if (vidaVilaoAtual <= 0) {
            regraProducao();

            apresentarVetorPrioridade();

            for (int i = 0; i < 9; i++) {
                if (prioridade[i] != 0) {
                    executarRegras(prioridade[i]);

                    for (int j = 0; j < 9; j++) {
                        prioridade[j] = 0;
                    }
                    break;
                }
            }
        }

        System.out.println("\n\n");

    }

}
