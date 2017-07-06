package dedikodu;

import java.util.Scanner;

public class Dedikodu {

    public static char[] harfler = {'A','B','C','D','E','F','G','H','I','J'};
    
    static int[][] dedikodu = new int[100][100];
    
    public static void olustur(int kisiSayisi){
        for(int i=0 ; i<kisiSayisi ; i++){
            for(int j=0 ; j<kisiSayisi ; j++){
                if(i==j){
                    dedikodu[i][j]=1;
                }
                else{
                    dedikodu[i][j]=0;
                }
            }
        }
    }
    
    public static void yaz(int kisiSayisi){
        for(int i=0 ; i<kisiSayisi ; i++){
            for(int j=0 ; j<kisiSayisi ; j++){
                System.out.print(dedikodu[i][j]+ " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Kişi sayisini giriniz : ");
        int kisiSayisi = input.nextInt();
        
        olustur(kisiSayisi);
        
        int yarisi = (int) Math.ceil((double)kisiSayisi/2);
        
        for(int i=0 ; i<yarisi ; i++){
            if(i==0){
                for(int j=1 ; j<yarisi ; j++){
                    dedikodu[i][j] = 1;
                    System.out.println(""+harfler[i]+" "+harfler[j]+ " ile konuşur.");
                }
            }
            else{
                for(int j=0 ; j<=i ; j++){
                    dedikodu[i][j]=1;
                }
            }
        }
        
        for(int i=yarisi ; i<kisiSayisi ; i++){
            if(i==yarisi){
                for(int j=yarisi+1 ; j<kisiSayisi ; j++){
                    dedikodu[i][j] = 1;
                    System.out.println(""+harfler[i]+" "+harfler[j]+ " ile konuşur.");
                }
            }
            else{
                for(int j=yarisi ; j<=i ; j++){
                    dedikodu[i][j]=1;
                }
            }
        }
        
       for(int i=0 ; i<kisiSayisi ;i++){
            if(dedikodu[0][i]!=1){
                dedikodu[0][i]+=dedikodu[yarisi][i];
            }
            else{
                dedikodu[yarisi][i]+=dedikodu[0][i];
            }
        }
       System.out.println(""+harfler[0]+ " " +harfler[yarisi]+ " ile konuşur.");
        
       for(int i=0 ; i<kisiSayisi ;i++){
            if(dedikodu[yarisi-1][i]!=1){
                dedikodu[yarisi-1][i]=1;
            }
            else{
                dedikodu[kisiSayisi-1][i]=1;
            }
        }
        System.out.println(""+harfler[yarisi-1]+" "+harfler[kisiSayisi-1]+ " ile konuşur.");
        
        for(int i=1 ; i<kisiSayisi ; i++){
            boolean bayrak = false;
            for(int j=0 ; j<kisiSayisi ;j++){
                if(dedikodu[i][j]==0){
                    bayrak=true;
                    dedikodu[i][j]=1;
                }
            }
            if(bayrak){
                System.out.println(""+harfler[0]+ " " +harfler[i]+ " ile konuşur.");
            }
        }
        
        yaz(kisiSayisi);
        
    }
    
}
