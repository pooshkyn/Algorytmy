package kolejka;

import java.util.Scanner;

public class Kolejka {
    public Element poczatek;
    public Element koniec;
    
    Kolejka(){
        poczatek = koniec = null;
        
    }
    
    public Element getPoczatek(){
        return poczatek;
    }
    
    public Element getKoniec(){
        return koniec;
    }
    
    public void setKoniec(Element k){
        koniec = k;
    }
    
    public void setPoczatek(Element p){
        poczatek = p;
    }
    
    
    public void dodaj(int x){
        Element temp = new Element(x);
        if(poczatek == null){
            poczatek = koniec = temp;
        }
        else {
            koniec.setNastepny(temp);
            koniec = temp;
        }
    }
       
    public void zdejmij(){
        
        if(poczatek != null){
            if(poczatek.getNastepny() == null){
                poczatek = null;
               
           }
            poczatek = poczatek.getNastepny();
            
        }
    }
    
    public void wyswietl(){
        if(poczatek != null){
            Element temp = poczatek;
            while(temp != null){
                System.out.print(temp.getWartosc() + " ");
                temp = temp.getNastepny();
            }
            System.out.println();
        } else {
            System.out.println("Kolejka jest pusta");
        }
    }
    
    public void dodajNaKolejkeRobocza(Kolejka kolejka2){
        Element temp = poczatek;
        if(temp != null){
            kolejka2.dodaj(temp.getWartosc());
            temp = temp.getNastepny();
        }
    }
    
    public void copy(Kolejka kolejka2){
        Element temp = poczatek;
        if(temp != null){
            while(temp != null){
            kolejka2.dodaj(temp.getWartosc());
            temp = temp.getNastepny();
        }
        } else {
            System.out.println("kolejka jest pusta");
        }
    }
    
    public static void main(String[] args) {
        Kolejka kolejka = new Kolejka();
        Kolejka robocza = new Kolejka();
        
        Scanner wczytaj = new Scanner(System.in);
        kolejka.menu();
        int k;
        while(true){
            
            k = wczytaj.nextInt();
            switch(k){
                case 1: {
                    System.out.println("Podaj element do dodania");
                    k = wczytaj.nextInt();
                    kolejka.dodaj(k);
                }; break;
                case 2: {
                    kolejka.dodajNaKolejkeRobocza(robocza);
                    kolejka.zdejmij();
                }; break;
                case 3: {
                    kolejka.wyswietl();
                }; break;
                case 4: {
                    System.exit(0);
                } 
                default: {
                    System.out.println("Opcja nie oprogramowana.");
                }     
                    
            }
        }
    }
    
    public void menu(){
        System.out.println("Menu:");
        System.out.println("1. Dodaj element do kolejki.");
        System.out.println("2. Zdejmij element z kolejki.");
        System.out.println("3. Wyswietl elementy z kolejki.");
        System.out.println("4. Zatrzymaj program.");
    }
    
    
    
}
