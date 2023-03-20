/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoalgoritmoguloso;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author joaov
 */
public class arvore {

    public static ArrayList<Cidade> cidades = new ArrayList<>();
    public static ArrayList<Rota> rotas = new ArrayList<>();

    public static void inserir(Cidade cidadeNova) {
        cidades.add(cidadeNova);
    }

    public static void adicionarVizinhos(Cidade cidadeRaiz, Cidade cidadeVizinha) {
        for (Cidade cidade : cidades) {
            if (cidade.equals(cidadeRaiz)) {
                cidadeRaiz.adicionarVizinho(cidadeVizinha);
                cidadeVizinha.adicionarVizinho(cidadeRaiz);
            }
        }
    }

    public static void adicionarRota(Cidade cidadeA, Cidade cidadeB, int distancia) {
        String aux;
        Rota rotaIda = null;
        Rota rotaVolta = null;

        for (Cidade cidade : cidades) {
            if (cidade.equals(cidadeA)) {
                rotaIda = new Rota(cidadeA, cidadeB, distancia);
                rotas.add(rotaIda);
                rotaVolta = new Rota(cidadeB, cidadeA, distancia);
                rotas.add(rotaVolta);
            }
        }
    }

    public static void apresentarVizinhos(Cidade cidadePesquisada) {
        for (Cidade aux : cidadePesquisada.getVizinhos()) {
            aux.getVizinhos();
        }
    }

    public static void desenharMapa() {
        //Adicionando cada Cidade
        Cidade arad = new Cidade("Arad", false, 366);
        inserir(arad);
        Cidade bucharest = new Cidade("Bucharest", false, 0);
        inserir(bucharest);
        Cidade craiova = new Cidade("Craiova", false, 160);
        inserir(craiova);
        Cidade dobreta = new Cidade("Dobreta", false, 242);
        inserir(dobreta);
        Cidade eforie = new Cidade("Eforie", false, 161);
        inserir(eforie);
        Cidade fagaras = new Cidade("Fagaras", false, 176);
        inserir(fagaras);
        Cidade giurgiu = new Cidade("Giurgiu", false, 77);
        inserir(giurgiu);
        Cidade hirsova = new Cidade("Hirsova", false, 151);
        inserir(hirsova);
        Cidade iasi = new Cidade("Iasi", false, 226);
        inserir(iasi);
        Cidade lugoj = new Cidade("Lugoj", false, 244);
        inserir(lugoj);
        Cidade mehadia = new Cidade("Mehadia", false, 241);
        inserir(mehadia);
        Cidade neamt = new Cidade("Neamt", false, 234);
        inserir(neamt);
        Cidade oradea = new Cidade("Oradea", false, 380);
        inserir(oradea);
        Cidade pitesti = new Cidade("Pitesti", false, 101);
        inserir(pitesti);
        Cidade rimnicu = new Cidade("Rimnicu Vilcea", false, 193);
        inserir(rimnicu);
        Cidade sibiu = new Cidade("Sibiu", false, 253);
        inserir(sibiu);
        Cidade timisoara = new Cidade("Timisoara", false, 329);
        inserir(timisoara);
        Cidade urziceni = new Cidade("Urziceni", false, 80);
        inserir(urziceni);
        Cidade vaslui = new Cidade("Vaslui", false, 199);
        inserir(vaslui);
        Cidade zerind = new Cidade("Zerind", false, 374);
        inserir(zerind);

        //Adicionando a conexão dos vizinhos
        adicionarVizinhos(arad, zerind);
        adicionarVizinhos(arad, sibiu);
        adicionarVizinhos(arad, timisoara);

        adicionarVizinhos(timisoara, lugoj);

        adicionarVizinhos(zerind, oradea);

        adicionarVizinhos(oradea, sibiu);

        adicionarVizinhos(sibiu, fagaras);
        adicionarVizinhos(sibiu, rimnicu);

        adicionarVizinhos(rimnicu, pitesti);
        adicionarVizinhos(rimnicu, craiova);

        adicionarVizinhos(pitesti, craiova);

        adicionarVizinhos(craiova, dobreta);

        adicionarVizinhos(dobreta, mehadia);

        adicionarVizinhos(mehadia, lugoj);

        adicionarVizinhos(bucharest, giurgiu);
        adicionarVizinhos(bucharest, urziceni);
        adicionarVizinhos(bucharest, fagaras);
        adicionarVizinhos(bucharest, pitesti);

        adicionarVizinhos(urziceni, hirsova);
        adicionarVizinhos(urziceni, vaslui);

        adicionarVizinhos(hirsova, eforie);

        adicionarVizinhos(vaslui, iasi);

        adicionarVizinhos(iasi, neamt);

        //=========================================================
        //Adicionando as rotas para o algoritmo A*
        adicionarRota(arad, zerind, 75);
        adicionarRota(arad, timisoara, 118);
        adicionarRota(arad, sibiu, 140);

        adicionarRota(zerind, oradea, 71);

        adicionarRota(oradea, sibiu, 151);

        adicionarRota(sibiu, fagaras, 99);
        adicionarRota(sibiu, rimnicu, 80);

        adicionarRota(timisoara, lugoj, 111);

        adicionarRota(lugoj, mehadia, 70);

        adicionarRota(mehadia, dobreta, 75);

        adicionarRota(dobreta, craiova, 120);

        adicionarRota(craiova, pitesti, 138);
        adicionarRota(craiova, rimnicu, 146);

        adicionarRota(rimnicu, pitesti, 97);

        adicionarRota(pitesti, bucharest, 101);

        adicionarRota(fagaras, bucharest, 211);

        adicionarRota(bucharest, urziceni, 85);
        adicionarRota(bucharest, giurgiu, 90);

        adicionarRota(urziceni, hirsova, 98);
        adicionarRota(urziceni, vaslui, 142);

        adicionarRota(hirsova, eforie, 86);

        adicionarRota(vaslui, iasi, 92);

        adicionarRota(iasi, neamt, 87);

    }

    public static void apresentarCidades() {
        System.out.println("\nApresentando as Cidades:");
        for (Cidade aux : cidades) {
            System.out.println("Cidade: " + aux.getNome() + "- Distância de Bucharest: " + aux.getDistancia());
        }
    }

    public static void apresentarVizinhos() {
        Scanner ler = new Scanner(System.in);
        String cidadeEscolhida;

        System.out.print("\nDigite o nome da cidade que deseja para encontrar as cidades vizinhas: ");
        cidadeEscolhida = ler.nextLine();

        System.out.println("\n\nApresentando Vizinhos de " + cidadeEscolhida + ":");
        for (Cidade aux : cidades) {
            if (aux.getNome().equals(cidadeEscolhida)) {
                aux.apresentarVizinhos();
            }
        }
    }

    public static void menorCaminho() {
        Scanner ler = new Scanner(System.in);
        ArrayList<String> caminho = new ArrayList<>();
        Cidade cidadeAtual = null;
        String cidadeRaiz;
        boolean encontrada = false, chegou = false;;
        int menorDistancia = 1000, indice = 0;

        System.out.println("\nQual a cidade raiz?");
        cidadeRaiz = ler.nextLine();

        for (Cidade aux : cidades) {
            if (aux.getNome().equals(cidadeRaiz)) {
                //Se encontrou a cidade raiz, ela será a cidade atual (root/raiz)
                encontrada = true;
                cidadeAtual = aux;
                cidadeAtual.setVisitado(true);
                System.out.println("\n|Cidade Atual: " + cidadeAtual.getNome()
                        + " - Distância de Bucharest: " + cidadeAtual.getDistancia() + "\n");
            }
        }

        if (encontrada == false) {
            System.out.println("\nCidade não encontrada.");
            return;
        } else {
            if (!cidadeRaiz.equals("Bucharest")) {
                do {
                    indice = 0;
                    //Mostra os vizinhos e verifica a menor distancia
                    //System.out.println("FOR 1");
                    for (Cidade aux : cidadeAtual.getVizinhos()) {
                        System.out.println("|Cidade Vizinha: " + aux.getNome() + " - Distância até Bucharest: " + aux.getDistancia());
                        if (aux.getDistancia() < menorDistancia) {
                            menorDistancia = aux.getDistancia();
                        }
                        if (indice == (cidadeAtual.getVizinhos().size() - 1)) {
                            System.out.println("Todos os vizinhos foram apresentados");
                        }
                        indice++;
                    }

                    for (Cidade aux : cidades) {
                        if (aux.getNome().equals(cidadeAtual)) {
                            aux.apresentarVizinhos();
                        }
                    }

                    indice = 0;
                    //Se for realmente a menor distância encontrada, pula pra próxima cidade, tornando ela a atual
                    //System.out.println("FOR 2");
                    for (Cidade aux : cidadeAtual.getVizinhos()) {
                        if (!(indice == (cidadeAtual.getVizinhos().size() - 1)) && aux.getDistancia() == menorDistancia) {
                            indice++;
                            caminho.add(" -> " + aux.getNome());
                            cidadeAtual = aux;
                            cidadeAtual.setVisitado(true);
                            menorDistancia = 1000;
                            System.out.println("\nMudou de cidade: " + cidadeAtual.getNome());
                        }
                        if (aux.getDistancia() == 0) {
                            chegou = true;
                        }
                    }
                } while (chegou == false);
                if (chegou == true) {
                    System.out.println("\nVocê Chegou em Bucharest.");
                    System.out.println("\nEssa foi sua rota: ");
                    for (String aux : caminho) {
                        System.out.println(aux);
                    }
                }
            } else {
                System.out.println("\nVocê já estava em Bucharest.");
            }
        }
    }

    public static void aestrela() {
        Scanner ler = new Scanner(System.in);
        ArrayList<String> caminho = new ArrayList<>();
        Cidade cidadeAtual = null;
        String cidadeRaiz;
        boolean encontrada = false, chegou = false;
        int indiceA = 0, indiceB = 0, menorDistanciaAteBucharest = 1000, menorRota = 1000, soma = 0, somaTotal = 0;

        System.out.println("\nQual a cidade raiz?");
        cidadeRaiz = ler.nextLine();

        for (Cidade aux : cidades) {
            if (aux.getNome().equals(cidadeRaiz)) {
                //Se encontrou a cidade raiz, ela será a cidade atual (root/raiz)
                encontrada = true;
                cidadeAtual = aux;
                cidadeAtual.setVisitado(true);
                System.out.println("Cidade atual: " + cidadeAtual.getNome()
                        + " - Distância de Bucharest: " + cidadeAtual.getDistancia() + "\n");
            }
        }

        if (encontrada == false) {
            System.out.println("\nCidade não encontrada.");
            return;
        } else {
            if (!cidadeRaiz.equals("Bucharest")) {
                do {
                    indiceA = 0;
                    //Mostra os vizinhos e verifica a menor distancia até bucharest
                    //System.out.println("FOR 1");
                    for (Cidade aux : cidadeAtual.getVizinhos()) {
                        System.out.println("\n|Cidade Vizinha: " + aux.getNome() + " - Distância até Bucharest em linha reta: " + aux.getDistancia());
                        if (aux.getDistancia() < menorDistanciaAteBucharest) {
                            //Variável auxiliar para calcular a menor distancia até bucharest a cada cidade mudada
                            menorDistanciaAteBucharest = aux.getDistancia();
                        }

                        for (Rota rota : rotas) {
                            if (!(indiceB == rotas.size())
                                    && rota.getCidadeA().equals(cidadeAtual)
                                    && rota.getCidadeB().equals(aux)) {
                                System.out.println("|Rota de " + rota.getCidadeA().getNome()
                                        + " até " + rota.getCidadeB().getNome()
                                        + " - Distância: " + rota.getDistancia());
                                soma = rota.getDistancia() + menorDistanciaAteBucharest;
                                System.out.println("|Sub-Total: " + soma);
                            }
                            indiceB++;
                        }

                        if (soma < menorRota) {
                            menorRota = soma;
                        }
                        indiceA++;
                    }
                    System.out.println("|Menor Rota até Bucharest: " + menorRota + "\n");

                    indiceA = 0;
                    //Se for realmente a menor distância encontrada, pula pra próxima cidade, tornando ela a atual
                    //System.out.println("FOR 2");
                    for (Cidade aux : cidadeAtual.getVizinhos()) {
                        for (Rota rota : rotas) {
                            //Verificando os vizinhos e rotas
                            //Indo da cidade atual até o vizinho onde a soma
                            if (!(indiceB == rotas.size())
                                    && rota.getCidadeA().equals(cidadeAtual)
                                    && rota.getCidadeB().equals(aux)) {
                                soma = rota.getDistancia() + menorDistanciaAteBucharest;
                                if (soma == menorRota) {
                                    caminho.add(" -> " + aux.getNome());
                                    cidadeAtual = aux;
                                    cidadeAtual.setVisitado(true);
                                    menorDistanciaAteBucharest = 1000;
                                    menorRota = 1000;
                                    somaTotal += soma;
                                    soma = 0;
                                    System.out.println("\nMudou de cidade: " + cidadeAtual.getNome());
                                }
                                if (aux.getDistancia() == 0) {
                                    chegou = true;
                                }
                            }
                            indiceB++;
                        }
                        indiceA++;
                    }
                } while (chegou == false);

                if (chegou == true) {
                    System.out.println("\nVocê Chegou em Bucharest. Quantia andada: " + somaTotal);
                    System.out.println("\nEssa foi sua rota: ");
                    for (String aux : caminho) {
                        System.out.println(aux);
                    }
                }
            } else {
                System.out.println("\nVocê já estava em Bucharest.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String cidadeRaiz = null;
        int op;

        desenharMapa();

        do {
            System.out.println("\n--Menu----------------------------------------------------");
            System.out.println("\n1 - Apresentar Cidades.");
            System.out.println("\n2 - Apresentar Vizinhos de uma cidade.");
            System.out.println("\n3 - Apresentar menor caminho de uma cidade até Bucharest (Busca Gulosa).");
            System.out.println("\n4 - Apresentar menor caminho de uma cidade até Bucharest (Busca A*).");
            System.out.println("\n0 - Encerrar o programa.");
            System.out.println("\n----------------------------------------------------------");

            System.out.print("\nSelecione uma Opção: ");
            op = ler.nextInt();

            switch (op) {
                case 1:
                    apresentarCidades();
                    break;
                case 2:
                    apresentarVizinhos();
                    break;
                case 3:
                    menorCaminho();
                    break;
                case 4:
                    aestrela();
                    break;
                case 0:
                    System.out.println("\nPrograma Encerrado.");
                    break;
                default:
                    System.out.println("\nComando Inválido.");
                    break;
            }
        } while (op != 0);
    }
}
