/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetolarguraprofundidade;

import java.util.Scanner;

/**
 *
 * @author ax414
 */
public class PrincipalProfundidade {

    public static Pilha pilha = new Pilha();

    public static void inserirElemento() {
        Scanner ler = new Scanner(System.in);
        Elemento e = new Elemento();
        String rotulo;

        System.out.println("\nInserindo Elemento na Pilha: ");
        System.out.print("\nQual o rótulo?\nR.: ");
        rotulo = ler.nextLine();
        e.setRotulo(rotulo);

        //Não pode rotulo duplicado, pra não dar pau
        if (!pilha.pilhaVazia()) {
            for (int i = pilha.getPosicaoPilha(); i >= 0; i--) {
                if (e.getRotulo().equals(pilha.getPilha()[i].getRotulo())) {
                    System.out.println("\nEsse elemento já existe na pilha.");
                    return;
                }
            }
        }

        pilha.empilhar(e);
        System.out.println("\nElemento adicionado na pilha.");
    }

    public static void inserirVizinho() {
        Scanner ler = new Scanner(System.in);
        Elemento aux = new Elemento();
        String rotuloPai, rotuloFilho;
        int posicaoPai, posicaoFilho;

        //Busca se o elemento pai existe
        System.out.println("\nInserindo Elemento filho:");
        System.out.print("\nQual o rótulo do elemento pai?\nR.: ");
        rotuloPai = ler.nextLine();

        //Procura a posição do elemento pai
        posicaoPai = pilha.buscarElemento(rotuloPai);

        //Se sim, adiciona um vizinho nele
        if (posicaoPai != -1) {
            System.out.print("\nQual o rótulo do elemento filho?\nR.: ");
            rotuloFilho = ler.nextLine();

            posicaoFilho = pilha.buscarElemento(rotuloFilho);

            if (posicaoFilho != -1) {
                pilha.getPilha()[posicaoPai].adicionarVizinho(pilha.getPilha()[posicaoFilho]);
                System.out.println("\nElemento filho foi adicionado");
            } else {
                System.out.println("\nNão existe um elemento com esse rótulo na pilha.");
            }

        } else {
            System.out.println("\nNão existe um elemento com esse rótulo na pilha.");
        }
    }

    public static void apresentarVizinhos() {
        Scanner ler = new Scanner(System.in);
        String rotulo;
        int posicaoPai;

        System.out.println("\nApresentando filhos:");
        System.out.print("\nQual o rótulo do elemento para apresentar os filhos?\nR.: ");
        rotulo = ler.nextLine();

        posicaoPai = pilha.buscarElemento(rotulo);

        if (posicaoPai != -1) {
            pilha.getPilha()[posicaoPai].apresentarVizinhos();
        } else {
            System.out.println("\nNão existe elemento com esse rótulo.");
        }
    }

    //https://pt.wikipedia.org/wiki/Busca_em_profundidade
    public static Elemento buscaProfundidade(Elemento e, String rotulo) {
        Pilha pilhaVisitados = new Pilha();
        Pilha pilhaAux = new Pilha();

        e.setVisitado(true);
        pilhaAux.empilhar(e);
        pilhaVisitados.empilhar(e);

        System.out.println("\nPilha auxiliar:");
        pilhaAux.apresentarPilha();

        System.out.println("\nPilha visitados:");
        pilhaVisitados.apresentarPilha();

        System.out.println("\nO vértice atual é: " + e.getRotulo());
        //Passa por todos os vértices
        while (!pilhaAux.pilhaVazia()) {
            Elemento verticeAtual = pilhaAux.getTopo();
            pilhaAux.desempilhar();

            if (verticeAtual.getRotulo().equals(rotulo)) {
                System.out.println("\nVertice atual é igual.");
                return verticeAtual;
            }

            for (Elemento aux : verticeAtual.getVizinhos()) {
                if (!aux.isVisitado()) {
                    System.out.println("\nVertice adjacente " + aux.getRotulo() + " foi visitado.");
                    aux.setVisitado(true);
                    pilhaVisitados.empilhar(aux);
                    pilhaAux.empilhar(aux);
                }
            }

            System.out.println("\nPilha auxiliar:");
            pilhaAux.apresentarPilha();

            System.out.println("\nPilha visitados:");
            pilhaVisitados.apresentarPilha();

        }

        /*
        for (int i = 0; i < pilha.getPosicaoPilha(); i++) {
            //Se o vértice não foi visitado
            if (!pilha.getPilha()[i].isVisitado()) {
                //Empilha ele na pilha de visitados
                verticeAtual = pilha.getPilha()[i];
                verticeAtual.setVisitado(true);
                pilhaVisitados.empilhar(verticeAtual);
                System.out.println("\nPercorrendo os vizinhos de " + verticeAtual.getRotulo());
                //Agora percorre os vizinhos do vertice atual
                for (Elemento aux : verticeAtual.getVizinhos()) {
                    //Se tiver vizinhos, atualiza a posição
                    if (pilha.getPilha()[i].getVizinhos() != null) {
                        verticeAtual = pilha.getPilha()[i].getVizinhos().get(0);
                        System.out.println("\nVA: " + verticeAtual.getRotulo());
                        buscaProfundidade(pilha, pilha.buscarElemento(verticeAtual.getRotulo()));
                    }else{
                        System.out.println("\n"+pilha.getPilha()[i].getRotulo()+" não possui vizinhos.");
                    }
                }
            }
        }
         */
        return null;
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Elemento aux = new Elemento();
        int op = 0;

        do {
            System.out.println("\n<Menu>");
            System.out.println("1 - Inserir elemento na pilha.");
            System.out.println("2 - Inserir elemento adjacente.");
            System.out.println("3 - Dempilhar ultimo elemento da pilha.");
            System.out.println("4 - Apresentar topo.");
            System.out.println("5 - Apresentar pilha.");
            System.out.println("6 - Apresentar vizinhos de um elemento da pilha.");
            System.out.println("7 - Efetuar Busca em Profundidade.");
            System.out.println("0 - Encerrar Programa.");
            System.out.print("\n\nQual a Opção?\nR.: ");
            op = ler.nextInt();

            switch (op) {
                case 1:
                    inserirElemento();
                    break;
                case 2:
                    inserirVizinho();
                    break;
                case 3:
                    pilha.desempilhar();
                    if (!pilha.pilhaVazia()) {
                        pilha.apresentarPilha();
                    }
                    break;
                case 4:
                    pilha.getTopo();
                    break;
                case 5:
                    if (!pilha.pilhaVazia()) {
                        pilha.apresentarPilha();
                    } else {
                        System.out.println("\nA Pilha está vazia.");
                    }
                    break;
                case 6:
                    apresentarVizinhos();
                    break;
                case 7:
                    aux = buscaProfundidade(pilha.getPilha()[0], "4");
                    if(aux!=null){
                        System.out.println("\nEncontrado elemento "+aux.getRotulo()+"."); 
                    }else{
                        System.out.println("\nNão encontrado.");
                    }
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
