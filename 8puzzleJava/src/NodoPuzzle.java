
/**
 *
 * @author lenin
 */
public class NodoPuzzle {
    private Integer puzzle[][];
    private NodoPuzzle padre;
    private Integer gn = 0;
    private Integer hn = 0;
    private Integer fn = gn + hn;

    public NodoPuzzle getPadre() {
        return padre;
    }

    public void setPadre(NodoPuzzle padre) {
        this.padre = padre;
    }

    public Integer[][] getPuzzle() {
        return puzzle;
    }

    public void setPuzzle(Integer[][] puzzle) {
        this.puzzle = puzzle;
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
