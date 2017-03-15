
package sortowanie01;

import java.util.Scanner;

public class Sortowanie01 {
    
    

    static public void sort01(int n,float oceny[], int nr[], int s){
        int l = 0, p = n-1, rob2;
        float rob = 0;
        while (p > l) {            
            while((oceny[l] >= 3 ) && (l < p)){
                l ++;
            } 
            while((oceny[p] < 3) && (l<p)){
                p --;
            }
            if(p>l){
                rob = oceny[p];
                oceny[p] = oceny[l];
                oceny[l] = rob;
                rob2 = nr[p];
                nr[p] = nr[l];
                nr[l] = rob2;
                
                l ++;
                p --;
            }
            s++;           
        }
        
        System.out.println("Zdali:");
        for(int i = 0 ; i <= s ; i++){
            System.out.println(nr[i]+"\t"+oceny[i]);
        }
        
        System.out.println("Nie zdali:");
        for(int i = n-1 ; i > s ; i--){
            System.out.println(nr[i]+"\t"+oceny[i]);
        }
    }
    
    public static void main(String[] args) {
        Scanner wczytaj = new Scanner(System.in);
        System.out.println("Podaj ilosc studentow: ");
        int n = 5;//= wczytaj.nextInt();
        int[] nr_indeksu = {8870, 8876, 8865, 8782, 8900};
        float[] ocena = {2, 5, 3, 2, 4};
        
//        for(int i =0 ; i <n ; i++){
//           nr_indeksu[i] = wczytaj.nextInt();
//           ocena[i] = wczytaj.nextFloat();
//        }
        int s = 0;
        sort01(n, ocena, nr_indeksu, s);
        
    }
    
}
