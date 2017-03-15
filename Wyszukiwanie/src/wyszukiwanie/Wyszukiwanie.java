package wyszukiwanie;

import java.util.Scanner;

public class Wyszukiwanie {
    
    public static int liniowe(int x, int t[], int n){
        int i = 0;
        while((i < n) && (t[i]!=x)){
            i = i + 1;
        }
        
        if(t[i] == x) {return i;}
        else {return -1;}
    }
    
    public static int bisekcyjne(int x, int t[], int n){
        int l = 0, p = n, s;
        while(p>l){
            s = (l+p)/ 2;
            if(x>t[s]) {l = s+1;}
            else {p = s;}
        }
        if (x == t[p]) {return p;}
        else {return -1;}
    }
    
    public static int rekursja(int x, int l, int p, int t[]){
        int s;
        if( l == p) {
            if(x == t[p]) {return p;}
            else { return -1;}
        }
        else {
            s = (l+p) / 2;
            if(x > t[s]) { return rekursja(x, s+1, p ,t);}
            else {return rekursja(x,l,s,t);}
        }
        
    }

    public static void main(String[] args) {
        Scanner wczytaj = new Scanner(System.in);
        int x, n = 9;
        int tab[] = {3,5,9,11,15,17,19,25,30,100};
        System.out.println("Podaj szukany element: ");
        x = wczytaj.nextInt();
        
        
        int rob = liniowe(x, tab, n);
        if(rob != -1){
            System.out.println("Element znajduje sie w komorce z indeksem "
                    + "(wyszukiwanie liniowe): "+rob);
        }
        else {
            System.out.println("Nie ma takiego elementu.");
        }
        
        rob = bisekcyjne(x, tab, n);
        
        if (rob != -1) {
            System.out.println("Element znajduje sie w komorce z indeksem "
                    + "(wyszukiwanie bisekcyjne): "+rob);
        }
        else{
            System.out.println("Nie ma takiego elementu.");
        }
        
        
        rob = rekursja(x, 0, n, tab);
        
        if (rob != -1) {
            System.out.println("Element znajduje sie w komorce z indeksem "
                    + "(wyszukiwanie bisekcyjne rekursyjnie): "+rob);
        }
        else{
            System.out.println("Nie ma takiego elementu.");
        }
        
    }
    
}
