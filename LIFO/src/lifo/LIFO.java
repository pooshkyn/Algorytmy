package lifo;

import java.util.Scanner;

public class LIFO {

    public Element wierzcholek;
    
    public LIFO(){
        wierzcholek = null;
    }
    
    public Element getWierzcholek(){
        return wierzcholek;
    }
    
    public void dodaj(int x){
        Element temp = new Element(x, wierzcholek);
        wierzcholek = temp;
    }
    
    public void zdejmij(){
        if(wierzcholek != null){
            wierzcholek = wierzcholek.getNastepny();
        } else {
            System.out.println("Stos jest pusty.");
        }
    }
    
    public void dodajNaStosRoboczy(LIFO stos2){
        Element temp = wierzcholek;
        if(temp != null){
            stos2.dodaj(temp.getWartosc());
            temp.getNastepny();
        }
    }
    
    public void wyswietl(){
        if(wierzcholek != null){
            Element temp = wierzcholek;
            while(temp != null){
                System.out.print(temp.getWartosc() + " " );
                temp = temp.getNastepny();
            }
            System.out.println("");
        }
        else {
            System.out.println("Stos jest pusty.");
        }
    }
    
    public void menu(){
        System.out.println("Menu:");
        System.out.println("1. Dodaj element do stosu.");
        System.out.println("2. Zdejmij element ze stosu.");
        System.out.println("3. Wyswietl elementy ze stosu.");
        System.out.println("4. Pokaz liczbe elementow na stosie.");
        System.out.println("5. Odwroc stos.");
        System.out.println("6. Posortuj stos.");
        System.out.println("7. Wyjscie.");
        
        
    }
    
    public static void main(String[] args) {
        LIFO stos = new LIFO();
        LIFO roboczy = new LIFO();
        
        Scanner wczytaj = new Scanner(System.in);
        stos.menu();
        int k;
        while(true){
            
            k = wczytaj.nextInt();
            switch(k){
                case 1: {
                    System.out.println("Podaj element do dodania");
                    k = wczytaj.nextInt();
                    stos.dodaj(k);
                }; break;
                case 2: {
                    stos.dodajNaStosRoboczy(roboczy);
                    stos.zdejmij();
                }; break;
                case 3: {
                    System.out.println("Elementy stosu to: \n");
                    stos.wyswietl();
                }; break;
                case 4: {
                    System.out.println("Liczba elementow na stosie: " + stos.zlicz());
                }; break;
                case 5: {
            
                }; break;
                case 6: {
                    stos.sort(stos);
                }; break;
                case 7: {
                    break;
                }
                default: {
                    System.out.println("Opcja nie oprogramowana.");
                }    
            }
        }
        
    }

    public int zlicz() {
        int l = 0;
        if(wierzcholek != null){
            Element temp = wierzcholek;
            while(temp != null){
                l++;
                temp = temp.getNastepny();
            }
        }
        return l;
    }

    public void sort(LIFO stos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
