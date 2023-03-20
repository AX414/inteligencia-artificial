/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoalgoritmoguloso;

import java.util.ArrayList;

/**
 *
 * @author joaov
 */
public class Cidade {
    private String nome;
    private boolean visitado;
    private int distancia;
    private ArrayList<Cidade> vizinhos = new ArrayList<>();

    public Cidade() {
    }

    public Cidade(String nome, boolean visitado, int distancia) {
        this.nome = nome;
        this.visitado = visitado;
        this.distancia = distancia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public ArrayList<Cidade> apresentarVizinhos() {
        for(Cidade aux: this.vizinhos){
            System.out.println("|Cidade: "+aux.getNome()+" - Distância de Bucharest: "+aux.getDistancia());
        }
        return this.vizinhos;
    }

    public ArrayList<Cidade> getVizinhos() {
        return vizinhos;
    }

    public void setVizinhos(ArrayList<Cidade> vizinhos) {
        this.vizinhos = vizinhos;
    }
    
    public void adicionarVizinho(Cidade cidade){
        this.vizinhos.add(cidade);
        this.setVizinhos(vizinhos);
    }

    @Override
    public String toString() {
        return "Cidade{" + "nome=" + nome + ", visitado=" + visitado + ", distancia=" + distancia + ", vizinhos=" + vizinhos + '}';
    }

}
