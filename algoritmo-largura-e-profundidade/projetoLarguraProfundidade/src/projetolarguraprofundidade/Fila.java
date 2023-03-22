/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetolarguraprofundidade;

/**
 *
 * @author ax414
 */
public class Fila {

    private int inicio;
    private int fim;
    private int tamanho;
    private int qtdElementos;
    private Elemento f[];

    public Fila() {
        this.inicio = this.fim = -1;
        this.tamanho = 100;
        this.f = new Elemento[this.tamanho];
        this.qtdElementos = 0;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getFim() {
        return fim;
    }

    public void setFim(int fim) {
        this.fim = fim;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getQtdElementos() {
        return qtdElementos;
    }

    public void setQtdElementos(int qtdElementos) {
        this.qtdElementos = qtdElementos;
    }

    public Elemento[] getF() {
        return f;
    }

    public void setF(Elemento[] f) {
        this.f = f;
    }

    public boolean filaVazia() {
        if (this.qtdElementos == 0) {
            return true;
        }
        return false;
    }

    public boolean filaCheia() {
        if (this.qtdElementos == this.tamanho - 1) {
            return true;
        }
        return false;
    }

    public void adicionarElemento(Elemento e) {
        if (!filaCheia()) {
            if (this.inicio == -1) {
                this.inicio = 0;
            }
            this.fim++;
            this.f[this.fim] = e;
            this.qtdElementos++;
        }
    }

    public Elemento removerElemento() {
        Elemento aux;
        if (!filaVazia()) {
            aux = f[qtdElementos];
            this.inicio++;
            qtdElementos--;
            return aux;
        }
        return null;
    }

    public void apresentarFila() {
        System.out.println("\n");
        if (filaVazia()) {
            System.out.println("\nA fila está vazia.");
        } else {
            for (int i = this.inicio; i <= this.fim; i++) {
                System.out.println("Fila[" + i + "] = " + f[i].getRotulo());
            }
        }
    }

    public int buscarElemento(String rotulo) {
        for (int i = this.inicio; i <= this.fim; i++) {
            if (f[i].getRotulo().equals(rotulo)) {
                //Retorna a posição do elemento do rotulo procurado
                return i;
            }
        }

        return -1;
    }
    
    public Elemento pegarElemento(String rotulo) {
        for (int i = this.inicio; i <= this.fim; i++) {
            if (f[i].getRotulo().equals(rotulo)) {
                //Retorna o elemento do rotulo procurado
                return f[i];
            }
        }

        return null;
    }

    
}
