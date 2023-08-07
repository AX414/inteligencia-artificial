/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetolarguraprofundidade;

import java.util.ArrayList;

/**
 *
 * @author ax414
 */
public class Elemento {

    private String rotulo;
    private boolean visitado;
    private ArrayList<Elemento> vizinhos = new ArrayList<>();

    public Elemento() {
    }

    public Elemento(String rotulo, boolean visitado) {
        this.rotulo = rotulo;
        this.visitado = false;
    }

    public String getRotulo() {
        return rotulo;
    }

    public void setRotulo(String rotulo) {
        this.rotulo = rotulo;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public ArrayList<Elemento> getVizinhos() {
        return vizinhos;
    }

    public void setVizinhos(ArrayList<Elemento> vizinhos) {
        this.vizinhos = vizinhos;
    }

    public void adicionarVizinho(Elemento e) {
        this.vizinhos.add(e);
    }

    public void apresentarVizinhos() {
        int i = 0;
        System.out.println("\nApresentando Vizinhos de " + this.rotulo + ":");

        if (this.getVizinhos().isEmpty()) {
            System.out.println("\nEste elemento não possui vizinhos.");
        } else {
            for (Elemento aux : this.vizinhos) {
                System.out.println("\nElemento[" + i + "] = " + aux.getRotulo());
                i++;
            }
        }
    }
}
