
package flagafrancuska;

import java.util.Scanner;

public class FlagaFrancuska {
    public static final Scanner wczytaj = new Scanner(System.in);
    
    public static Punkt[] punkty(int n, Punkt[] pkt){       
        //pkt[0] = new Punkt(50, 50);
        pkt[n+1] = new Punkt(0, 0);
        for(int i = 1 ; i <= n; i++){
            System.out.println("Podaj wspolrzedna x i y "+i+"'ego punktu:");
            pkt[i] = new Punkt(wczytaj.nextInt(), wczytaj.nextInt());
        }
        return pkt;
    }
    
    public static Punkt[] sort012(int n, Punkt[] pkt){
        int n1 = 0, n2 = 1, n3 = n + 1;
        Punkt p, rob;
        while(n2<n3){
            p = pkt[n2];
            if((p.getX() > 0 && p.getY() > 0) || (p.getX() < 0 && p.getY() < 0)){
                n2++;
            }
            else if((p.getX() > 0 && p.getY() < 0) || (p.getX() < 0 && p.getY() > 0)){
                n1++;
                rob = pkt[n1];
                pkt[n1] = pkt[n2];
                pkt[n2] = rob;
                n2++;
            }
            else{
                n3--;
                rob = pkt[n2];
                pkt[n2] = pkt[n3];
                pkt[n3] = rob;
            }
                
        }
        
        return pkt;
    }
    
    public static void wyswietl(Punkt[] pkt, int n){
        int i = 1;
        System.out.println("Wspolrzedne polozone w cwiartkach parzystych:");
        while((i <= n) && (pkt[i].getX() > 0 && pkt[i].getY() < 0) || (pkt[i].getX() < 0 && pkt[i].getY() > 0)){
            System.out.println("("+pkt[i].getX()+", "+pkt[i].getY()+")");
            i++;
        }
        
        System.out.println("Wspolrzedne polozone w cwiartkach nieparzystych:");
        while((i <= n) && (pkt[i].getX() > 0 && pkt[i].getY() > 0) || (pkt[i].getX() < 0 && pkt[i].getY() < 0) ){
            System.out.println("("+pkt[i].getX()+", "+pkt[i].getY()+")");
            i++;
        }
        System.out.println("Wspolrzedne polozone na osiach OX i OY:");
        while((i <= n) && (pkt[i].getX() == 0 || pkt[i].getY() == 0)){
            System.out.println("("+pkt[i].getX()+", "+pkt[i].getY()+")");
            i++;
        }

    }
    
    public static void main(String[] args) {
        System.out.println("Podaj liczbe punktow: ");
        int n = wczytaj.nextInt();
        Punkt[] punkt = new Punkt[n+2];
        punkty(n, punkt);
        sort012(n, punkt);
        wyswietl(punkt, n);
    }
    
}
