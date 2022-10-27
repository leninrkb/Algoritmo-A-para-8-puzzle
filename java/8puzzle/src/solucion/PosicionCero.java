/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package solucion;

/**
 *
 * @author lenin
 */
public class PosicionCero {
    private String posicion;
    private Integer posicioni;    
    private Integer posicionj;

    PosicionCero(String pos, Integer i, Integer j) {
       this.posicion = pos;
       this.posicioni = i;
       this.posicionj = j;
    }

    PosicionCero() { }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Integer getPosicioni() {
        return posicioni;
    }

    public void setPosicioni(Integer posicionx) {
        this.posicioni = posicionx;
    }

    public Integer getPosicionj() {
        return posicionj;
    }

    public void setPosicionj(Integer posiciony) {
        this.posicionj = posiciony;
    }
}
