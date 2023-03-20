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

    public static String quadro[][] = new String[5][5];
    public static int vidaVilao = 3;

    public static int posicaoHeroi[] = new int[2];
    public static int posicaoVilao[] = new int[2];
    public static int posicaoBonus[] = new int[2];

    public static int prioridade[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    
    public static boolean pegouBonus = false;

    public static void inserirPersonagens(String quadro[][]) {
        Random linha = new Random();
        Random coluna = new Random();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                quadro[i][j] = "-";
            }

        }

        posicaoHeroi[0] = linha.nextInt(4);
        posicaoHeroi[1] = coluna.nextInt(4);
        
        posicaoVilao[0] = linha.nextInt(4);
        posicaoVilao[1] = coluna.nextInt(4);  
        
        posicaoBonus[0] = linha.nextInt(4);
        posicaoBonus[1] = coluna.nextInt(4);
        
            
        quadro[posicaoHeroi[0]][posicaoHeroi[1]] = "H";
        quadro[posicaoVilao[0]][posicaoVilao[1]] = "V";
        quadro[posicaoBonus[0]][posicaoBonus[1]] = "B";

}

    public static void apresentarQuadro(String quadro[][], int vidaVilao) {
        int i = 0, j = 0;

        System.out.println("\nApresentando o Tabuleiro:"
                + "\nVidas do Vilão: " + vidaVilao + "\n\n");
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                System.out.print("|" + quadro[i][j] + "|");
            }
            System.out.println("\n");
        }
        
        System.out.println("Posição do Herói: ["+posicaoHeroi[0]+"]["+posicaoHeroi[1]+"]");
        System.out.println("Posição do Vilão: ["+posicaoVilao[0]+"]["+posicaoVilao[1]+"]");
        System.out.println("Posição do Bônus: ["+posicaoBonus[0]+"]["+posicaoBonus[1]+"]");
    }

    public static int[] pegaPosicao(String quadro[][], String rotulo) {
        int posicao[] = new int[2];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (quadro[i][j] == rotulo) {
                    System.out.println("\nI: " + i + "\nJ:" + j);
                    posicao[0] = i;
                    posicao[1] = j;
                    return posicao;
                }
            }
        }

        return null;
    }

    public static void regraProducao(String quadro[][]) {
        
        //Atualiza as posições
        posicaoHeroi = pegaPosicao(quadro, "H");
        posicaoVilao = pegaPosicao(quadro, "V");
        posicaoBonus = pegaPosicao(quadro, "B");

        //R1
        if (posicaoHeroi[0] == posicaoVilao[0] 
         && posicaoHeroi[1] == posicaoVilao[1]){
            System.out.println("Mesma posição. Atacar!");
            vidaVilao-=vidaVilao;
        }
        //R2
        if(posicaoHeroi[1]>posicaoVilao[1]){
            //ir para a esquerda
        }
        //R3
        if(posicaoHeroi[1]<posicaoVilao[1]){
            //ir para a direita
        }
        //R4
        if(posicaoHeroi[0]<posicaoVilao[0]){
            //ir para baixo
        }
        //R5
        if(posicaoHeroi[0]>posicaoVilao[0]){
            //ir para cima
        }
        //R6
        if(posicaoHeroi[0] == posicaoVilao[0] 
        && posicaoHeroi[1] == posicaoVilao[1]
        && pegouBonus == true){
            vidaVilao=vidaVilao - 2;
        }
        //R7
        if(posicaoHeroi[0] == posicaoVilao[0] 
        && posicaoHeroi[1] == posicaoVilao[1]
        && vidaVilao == 0){
            System.out.println("\n\nVilão Derrotado!");
        }
        //R8
        if(true){
           //Se foi atacado, cria outra posição pro vilão 
        }
        
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        inserirPersonagens(quadro);
        apresentarQuadro(quadro, vidaVilao);

        System.out.println("\n\n");

        //um while com 5 ifs
    }

}
