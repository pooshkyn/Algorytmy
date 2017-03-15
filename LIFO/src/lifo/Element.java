
package lifo;

public class Element {
    private int wartosc;
    private Element nastepny;
    
    public Element(int x, Element n){
        nastepny = n;
        wartosc = x;
    }
    
    public Element getNastepny(){
        return nastepny;
    }
    
    public int getWartosc(){
        return wartosc;
    }
}
