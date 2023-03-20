/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoalgoritmoguloso;

/**
 *
 * @author Aluno
 */
public class Rota {
    private Cidade cidadeA;
    private Cidade cidadeB;
    private int distancia;
    
    public Rota() {
    }

    public Rota(Cidade cidadeA, Cidade cidadeB, int distancia) {
        this.cidadeA = cidadeA;
        this.cidadeB = cidadeB;
        this.distancia = distancia;
    }

    public Cidade getCidadeA() {
        return cidadeA;
    }

    public void setCidadeA(Cidade cidadeA) {
        this.cidadeA = cidadeA;
    }

    public Cidade getCidadeB() {
        return cidadeB;
    }

    public void setCidadeB(Cidade cidadeB) {
        this.cidadeB = cidadeB;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }
    
    
}
