/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetolarguraprofundidade;

/**
 *
 * @author ax414
 */
public class Pilha {

    private Elemento[] pilha;
    private int posicaoPilha;

    public Pilha() {
        this.posicaoPilha = -1;
        this.pilha = new Elemento[100];
    }

    public Elemento[] getPilha() {
        return pilha;
    }

    public void setPilha(Elemento[] pilha) {
        this.pilha = pilha;
    }

    public int getPosicaoPilha() {
        return posicaoPilha;
    }

    public void setPosicaoPilha(int posicaoPilha) {
        this.posicaoPilha = posicaoPilha;
    }

    public boolean pilhaVazia() {
        if (this.posicaoPilha == -1) {
            return true;
        }
        return false;
    }

    public int tamanho() {
        if (pilhaVazia()) {
            return 0;
        }
        return this.posicaoPilha + 1;
    }

    public Elemento getTopo() {
        //top
        if (this.pilhaVazia()) {
            System.out.println("\nA Pilha está vazia.");
            return null;
        }
        System.out.println("\nPilha[" + this.posicaoPilha + "] = " + this.pilha[this.posicaoPilha].getRotulo());
        return this.pilha[this.posicaoPilha];
    }

    public Elemento desempilhar() {
        //pop
        if (pilhaVazia()) {
            System.out.println("\nA Pilha está vazia, não há o que desempilhar.");;
            return null;
        }
        return this.pilha[this.posicaoPilha--];
    }

    public void empilhar(Elemento e) {
        //push
        if (this.posicaoPilha < this.pilha.length - 1) {
            this.pilha[++posicaoPilha] = e;
        }
    }

    public void apresentarPilha() {
        Pilha pilhaAux = new Pilha();

        System.out.println("\n");
        for (int i = this.posicaoPilha; i >= 0; i--) {
            System.out.println("Pilha[" + i + "] = " + this.pilha[i].getRotulo());
        }
        System.out.println("\n");
    }

    public int buscarElemento(String rotulo) {
        for (int i = this.posicaoPilha; i >= 0; i--) {
            if (this.pilha[i].getRotulo().equals(rotulo)) {
                return i;
            }
        }
        return -1;
    }

    public Elemento pegarElemento(String rotulo) {
        for (Elemento aux : this.pilha) {
            if (aux.getRotulo().equals(rotulo)) {
                return aux;
            }
        }
        return null;
    }
}
