/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetolarguraprofundidade;

import java.util.Scanner;

/**
 *
 * @author ax414
 */
public class PrincipalLargura {

    public static void inserirElemento(Fila fila) {
        Scanner ler = new Scanner(System.in);
        Elemento e = new Elemento();
        String rotulo;

        System.out.println("\nInserindo Elemento na Fila: ");
        System.out.print("\nQual o rótulo?\nR.: ");
        rotulo = ler.nextLine();
        e.setRotulo(rotulo);

        //Não pode rotulo duplicado, pra não dar pau
        for (int i = 0; i < fila.getQtdElementos(); i++) {
            if (e.getRotulo().equals(fila.getF()[i].getRotulo())) {
                System.out.println("\nEsse elemento já existe na fila.");
                return;
            }
        }

        fila.adicionarElemento(e);
        System.out.println("\nElemento adicionado na fila.");
    }

    public static void inserirVizinho(Fila fila) {
        Scanner ler = new Scanner(System.in);
        Elemento aux = new Elemento();
        String rotuloPai, rotuloFilho;
        int posicaoPai, posicaoFilho;

        //Busca se o elemento pai existe
        System.out.println("\nInserindo Elemento filho:");
        System.out.print("\nQual o rótulo do elemento pai?\nR.: ");
        rotuloPai = ler.nextLine();

        //Procura a posição do elemento pai
        posicaoPai = fila.buscarElemento(rotuloPai);

        //Se sim, adiciona um vizinho nele
        if (posicaoPai != -1) {
            System.out.print("\nQual o rótulo do elemento filho?\nR.: ");
            rotuloFilho = ler.nextLine();

            /*
                TEM UM PROBLEMA DE LÓGICA AQUI:
                1-O ELEMENTO FILHO DEVE SER INSERIDO NA FILA?
                                    OU
                2-O ELEMENTO FILHO DEVE SER PRÉ-EXISTENTE?
             */
            //Nesse caso eu fiz com que ele só adicionasse vizinhos se o vizinho existe na fila. 
            //Não sei se está errado.
            posicaoFilho = fila.buscarElemento(rotuloFilho);

            if (posicaoFilho != -1) {
                fila.getF()[posicaoPai].adicionarVizinho(fila.getF()[posicaoFilho]);
                System.out.println("\nElemento filho foi adicionado");
            } else {
                System.out.println("\nNão existe um elemento com esse rótulo na fila");
            }

        } else {
            System.out.println("\nNão existe um elemento com esse rótulo na fila.");
        }
    }

    public static void apresentarVizinhos(Fila fila) {
        Scanner ler = new Scanner(System.in);
        String rotulo;
        int posicaoPai;

        System.out.println("\nApresentando filhos:");
        System.out.print("\nQual o rótulo do elemento para apresentar os filhos?\nR.: ");
        rotulo = ler.nextLine();

        posicaoPai = fila.buscarElemento(rotulo);

        if (posicaoPai != -1) {
            fila.getF()[posicaoPai].apresentarVizinhos();
        } else {
            System.out.println("\nNão existe elemento com esse rótulo.");
        }
    }

    public static void buscaLargura(Fila fila) {
        //Fila para guardar os elementos que foram visitados.
        Fila filaVisitados = new Fila();
        Fila filaNaoVisitados = new Fila();

        //Presume-se que cada elemento inicialmente não foi visitado
        filaNaoVisitados = fila;

        //Pegando o vertice atual, ele será visitado
        Elemento verticeAtual = filaNaoVisitados.getF()[0];

        //Alterando o valor de visitado
        verticeAtual.setVisitado(true);

        //Adicionando ele na fila de visitados
        filaVisitados.adicionarElemento(verticeAtual);

        System.out.println("\nRaiz " + verticeAtual.getRotulo() + " foi vizitada. Adicionando na fila de visitados.\n");

        while (!filaNaoVisitados.filaVazia()) {
            //Apresentando as filas
            System.out.println("\nElementos não visitados:");
            filaNaoVisitados.apresentarFila();

            System.out.println("\nOrdem dos Elementos Visitados:");
            filaVisitados.apresentarFila();

            for (int i = 0; i < filaNaoVisitados.getFim(); i++) {
                System.out.println("\nVerificando os vizinhos de : " + filaNaoVisitados.getF()[i].getRotulo());
                //Para cada elemento da fila, ele verificará os vizinhos
                //Se tiver um vizinho, marca como visitado, adiciona aos visitados e move para o próximo da fila
                if (filaNaoVisitados.getF()[i].getVizinhos() != null) {
                    for (Elemento e : filaNaoVisitados.getF()[i].getVizinhos()) {
                        e.setVisitado(true);
                        System.out.println("\nElemento " + e.getRotulo() + " foi visitado. Adicionando na fila de visitados.");

                        //Adicionando ele na fila de visitados se ele não existe
                        filaVisitados.adicionarElemento(e);
                    }
                }
                System.out.println("\nRemove " + filaNaoVisitados.getF()[i].getRotulo() + ".");
                //Removendo da fila de não visitados
                filaNaoVisitados.removerElemento();
            }

        }

        //Apresentando as filas
        System.out.println("\nElementos não visitados:");
        filaNaoVisitados.apresentarFila();

        System.out.println("\nOrdem dos Elementos Visitados:");
        filaVisitados.apresentarFila();

    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Fila fila = new Fila();
        int op = 0;

        do {
            System.out.println("\n<Menu>");
            System.out.println("1 - Inserir elemento na fila.");
            System.out.println("2 - Inserir elemento adjacente.");
            System.out.println("3 - Apresentar fila.");
            System.out.println("4 - Apresentar vizinhos de um elemento da fila.");
            System.out.println("5 - Efetuar Busca em Largura.");
            System.out.println("0 - Encerrar Programa.");
            System.out.print("\n\nQual a Opção?\nR.: ");
            op = ler.nextInt();

            switch (op) {
                case 1:
                    inserirElemento(fila);
                    break;
                case 2:
                    inserirVizinho(fila);
                    break;
                case 3:
                    fila.apresentarFila();
                    break;
                case 4:
                    apresentarVizinhos(fila);
                    break;
                case 5:
                    buscaLargura(fila);
                    break;
                default:
                    System.out.println("Comando Inválido.");
                    break;
                case 0:
                    System.out.println("\n\nPrograma Encerrado.");
                    break;
            }

        } while (op != 0);

    }

}
