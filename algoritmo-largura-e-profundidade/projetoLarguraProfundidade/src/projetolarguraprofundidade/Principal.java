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
public class Principal {

    public static void inserirElemento(Fila fila){
        Scanner ler = new Scanner(System.in);
        Elemento e = new Elemento();
        String rotulo;
        
        System.out.println("\nInserindo Elemento na Fila: ");
        System.out.print("\nQual o rótulo?\nR.: ");
        rotulo = ler.nextLine();
        e.setRotulo(rotulo);
        fila.adicionarElemento(e);   
    }
    
    public static void inserirVizinho(Fila fila){
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
        if(posicaoPai!=-1){
            System.out.print("\nQual o rótulo do elemento filho?\nR.: ");
            rotuloFilho = ler.nextLine();
            
            /*
                TEM UM PROBLEMA DE LÓGICA AQUI:
                1-O ELEMENTO FILHO DEVE SER INSERIDO NA FILA?
                2-O ELEMENTO FILHO DEVE SER PRÉ-EXISTENTE?
            
            posicaoFilho = fila.buscarElemento(rotuloFilho);
            
            if(posicaoFIlho!=-1){
                fila.getF()[posicaoPai].adicionarVizinho(fila.getF()[posicaoFilho])
            }
            
            
            */
            
            
            //Elemento filho
            aux.setRotulo(rotuloFilho);
            
            //Altera o Objeto Pai da Fila
            fila.getF()[posicaoPai].adicionarVizinho(aux);
            System.out.println("\nElemento filho foi adicionado");
            
        }else{
            System.out.println("\nNão existe um elemento com esse rótulo na fila.");
        }
    }
    
    public static void apresentarVizinhos(Fila fila){
        Scanner ler = new Scanner(System.in);
        String rotulo;
        int posicaoPai;
        
        System.out.println("\nApresentando filhos:");
        System.out.print("\nQual o rótulo do elemento para apresentar os filhos?\nR.: ");
        rotulo = ler.nextLine();
        
        posicaoPai = fila.buscarElemento(rotulo);
        
        if(posicaoPai!=-1){
            fila.getF()[posicaoPai].apresentarVizinhos();
        }else{
            System.out.println("\nNão existe elemento com esse rótulo.");
        }
        
    }
    
    
    
    public static void efetuarBuscaLargura(){
        
    }
    
    public static void efetuarBuscaProfundidade(){
        
    }
    
    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Fila fila = new Fila();
        int op = 0;
        
        do{
            System.out.println("\n<Menu>");
            System.out.println("1 - Inserir elemento na fila.");
            System.out.println("2 - Inserir elemento adjacente.");
            System.out.println("3 - Apresentar fila.");
            System.out.println("4 - Apresentar vizinhos de um elemento da fila.");
            System.out.println("5 - Efetuar Busca em Largura.");
            System.out.println("6 - Efetuar Busca em Profundidade.");
            System.out.println("0 - Encerrar Programa.");
            System.out.print("\n\nQual a Opção?\nR.: ");
            op = ler.nextInt();
            
            switch(op){
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
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Comando Inválido.");
                    break;
                case 0:
                    System.out.println("\n\nPrograma Encerrado.");
                    break;
            }
            
        }while(op!=0);
        
    }
    
}
