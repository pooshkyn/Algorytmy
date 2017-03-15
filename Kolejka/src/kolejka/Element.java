package kolejka;

public class Element {
    private Element nastepny;
    private int wartosc;
    
    public Element(int wartosc){
        this.wartosc = wartosc;
        nastepny = null;
    }

    /**
     * @return the nastepny
     */
    public Element getNastepny() {
        return nastepny;
    }

    /**
     * @param nastepny the nastepny to set
     */
    public void setNastepny(Element nastepny) {
        this.nastepny = nastepny;
    }

    /**
     * @return the wartosc
     */
    public int getWartosc() {
        return wartosc;
    }

    /**
     * @param wartosc the wartosc to set
     */
    public void setWartosc(int wartosc) {
        this.wartosc = wartosc;
    }
    
    
}
