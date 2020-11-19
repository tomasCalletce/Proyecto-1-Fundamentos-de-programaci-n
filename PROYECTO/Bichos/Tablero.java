import java.util.ArrayList;
import java.util.Arrays;
import java.security.SecureRandom;
import java.util.Scanner;

public class Tablero {

    public Bicho[][] tableroTable;
    private SecureRandom sr = new SecureRandom();


    public Tablero(){
        this.tableroTable = new Bicho[2][2];
    }

    public void llenarTablero(){

        int cantidadDeBichos = sr.nextInt(4-1+1)+1;
       
        int contador = 0;
           
            for(int grande = 0; grande < this.tableroTable.length; grande++){
                for(int peque = 0; peque < this.tableroTable[grande].length; peque++){

                    if(contador >= cantidadDeBichos){
                        break;
                    }

                    Bicho newBicho;
                    int valor = sr.nextInt(2-1+1)+1;
                    contador++;

                    if(valor == 2){
                        newBicho = new BichoAlien();
                    }else{
                        newBicho = new BichoNormal();
                    }

                    this.tableroTable[grande][peque] = newBicho;

                }
            }
          

        
    }

    public void printTablro(){

        System.out.println("-------------------");

        for(int grande = 0; grande < this.tableroTable.length; grande++){
            for(int peque = 0; peque < this.tableroTable[grande].length; peque++){

                if(this.tableroTable[grande][peque] == null){
                    System.out.print("| " + "     " + " | ");
                    continue;
                }

                System.out.print("| " + this.tableroTable[grande][peque] + " | ");

                if(peque == 2){
                    System.out.println("|");
                }

            }
            System.out.println();
            System.out.println("-------------------");

        }
        

        
    }
    
    public boolean allDead(){

        boolean allDead = true;

        for(int grande = 0; grande < this.tableroTable.length; grande++){
            for(int peque = 0; peque < this.tableroTable[0].length; peque++){

                if(this.tableroTable[grande][peque] == null){
                    continue;
                }


                if(this.tableroTable[grande][peque].getSalud() > 0){
                    allDead = false;
              

                }
                if(this.tableroTable[grande][peque].getSalud() <= 0){
                    this.tableroTable[grande][peque] = null;
                }


            }
        }

    return allDead;

    }


    public static void iniciarJuego(Tablero tabala1){

        Scanner sc = new Scanner(System.in);
        
        
        
        boolean allDead = false;
        while(!allDead){
            
            String location = sc.next();

            switch(location){
                case "0.0": 
                    tabala1.tableroTable[0][0].atacado();
                    break;
                case "0.1": 
                    tabala1.tableroTable[0][1].atacado();
                    break;
                case "1.0": 
                    tabala1.tableroTable[1][0].atacado();
                    break;
                case "1.1": 
                    tabala1.tableroTable[1][1].atacado();
                    break;
                default :
                    System.out.println("eso no existe");

                
            }
           
            allDead = tabala1.allDead();
            tabala1.printTablro();
            
        }
     

    }

    

}
