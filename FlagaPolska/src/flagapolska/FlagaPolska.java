
package flagapolska;

import java.util.Scanner;



public class FlagaPolska {
    public static final Scanner wczytaj = new Scanner(System.in);
    public static int t;
    
    public static Student[] studenci(int n, Student[] s){       
        
        for(int i = 0 ; i < n; i++){
            System.out.println("Podaj nr indeksu i ocene "+(i+1)+"'ego studenta:");
            s[i] = new Student(wczytaj.nextInt(), wczytaj.nextFloat());
        }
        return s;
    }
    
    public static void wyswietl(Student[] student, int n){
        
        if(student[t].getOcena() > 3){
        System.out.println("Zdali:");
        for(int i = 0; i <= t; i++){
            System.out.println(student[i].getNr_indeksu()+"\t"+student[i].getOcena());
        }
        
        
        System.out.println("Nie zdali:");
        for(int i = t+1; i < n; i++){
            System.out.println(student[i].getNr_indeksu()+"\t"+student[i].getOcena());
        }
        }
        else{
           System.out.println("Zdali:");
        for(int i = 0; i < t; i++){
            System.out.println(student[i].getNr_indeksu()+"\t"+student[i].getOcena());
        }
        
        
        System.out.println("Nie zdali:");
        for(int i = t; i < n; i++){
            System.out.println(student[i].getNr_indeksu()+"\t"+student[i].getOcena());
        } 
        }

    }
    
    public static Student[] sort01(int n, Student[] s){
        int l = 0, p = n-1;
        Student rob;
        while(p>l){
            while((s[l].getOcena() >= 3) && (l < p)){
                l++;
            }
            while((s[p].getOcena() < 3) && (l < p)){
                p--;
            }
            if(p > l){
                rob = s[p];
                s[p] = s[l];
                s[l] = rob;
                
                l++;
                p--;
            }
            else t = p;
        }
        return s;
    }
    
    public static void main(String[] args) {
        
        System.out.println("Podaj liczbe studentow: ");
        int n = wczytaj.nextInt();
        Student[] student = new Student[n];
        studenci(n, student);
        sort01(n, student);
        wyswietl(student, n);
    }
    
}
