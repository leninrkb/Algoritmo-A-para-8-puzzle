/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package solucion;

/**
 *
 * @author lenin
 */
public class NodoPuzzle {
    private Integer puzzle[][];
    private Integer padre[][];
    private Integer gn;
    private Integer hn;
    private Integer fn;

    public Integer[][] getPuzzle() {
        return puzzle;
    }

    public void setPuzzle(Integer[][] puzzle) {
        this.puzzle = puzzle;
    }

    public Integer[][] getPadre() {
        return padre;
    }

    public void setPadre(Integer[][] padre) {
        this.padre = padre;
    }

    public Integer getGn() {
        return gn;
    }

    public void setGn(Integer gn) {
        this.gn = gn;
    }

    public Integer getHn() {
        return hn;
    }

    public void setHn(Integer hn) {
        this.hn = hn;
    }

    public Integer getFn() {
        return fn;
    }

    public void setFn(Integer fn) {
        this.fn = fn;
    }
    
}
