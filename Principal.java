import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Principal{

    private static Scanner sc = new Scanner(System.in);
    

    public static void main(String[] args) {

        Principal.mostrarMenu();




    }

    public static void mostrarMenu(){

        Scanner sc = new Scanner(System.in);

        while(true){

            int num = sc.nextInt();

            switch(num){
                case 0: 

                return;
                case 1:

                    Principal.case1();

                break;
                case 2 :

                    Principal.case2();

                break;
                case 3:

                    Principal.case3();

                break;
                case 4:

                    Principal.case4();

                break;
                case 5:

                    Principal.case5();

                break;
                case 6:

                    Principal.case6();

                break;
                case 7:

                Principal.case7();

                break;
                case 8:
                
                    Principal.case8();
                
                break;
                case 666:

                    Principal.case666();

                break;

                







              
            }


        }

      


    }

    public static void case1(){


        if(Vehiculo.tamano <= Vehiculo.posAnadir){
            System.out.println("“Error base de datos llena.");
            return;
        }


        Vehiculo nuevo = new Vehiculo(sc.nextInt(),sc.next(),sc.nextDouble(),sc.next());
    }

    public static void case2(){

      

        System.out.println(Vehiculo.StringVehiculo());



    }

    public static void case3(){

    

        System.out.println(Vehiculo.cantidadVehiculos());



    }

    public static void case4(){


        for(int tt = 0; tt < Vehiculo.posAnadir; tt++){

                 

            if (Vehiculo.vehiculos[tt].getColor().equals("verde")){

                System.out.println(Vehiculo.vehiculos[tt].toString());
            
            }

           

        }

    }

    public static void case5(){

      

        String tipo = sc.next();
        double valor = sc.nextDouble();

        if(Sensor.posAnadir > Sensor.tamano){
            System.out.println("Error base de datos llena");
            return;
        }

        Sensor newSensor = new Sensor(tipo,valor);


    }

    public static void case6(){

        System.out.println(Sensor.toStringSensores());

    }

    public static void case7(){

        System.out.println(Sensor.cantidadSensores());

    }

    public static void case8(){

        for(int i = 0; i < Sensor.posAnadir; i++){

            if(Sensor.sensores[i].getTipo().equals("temperatura")){
                System.out.print(Sensor.sensores[i].toString());
            }


        }

    }



    public static void case666(){

        Sensor[] lista = Principal.arrayCopySensor(Sensor.sensores,Sensor.cantidadSensores());
        ArrayList<Sensor> listaFinal = new ArrayList<>();

        Sensor menor;
        Sensor porahora;

        for(int grande = 0; grande < Sensor.cantidadSensores();grande++){
        
            menor = lista[grande];

            for(int peque = grande + 1; peque < Sensor.cantidadSensores(); peque++){

                if(lista[peque].getValor() < menor.getValor()){

                    menor = lista[peque];
                    porahora = lista[grande];
                    lista[grande] = menor;
                    lista[peque] = porahora;
                   
    
                }


            }

            if(menor.getTipo().equals("temperatura")){
                listaFinal.add(menor);
            }

        }

       System.out.println(listaFinal.toString());
  


    }




    public static Sensor[] arrayCopySensor(Sensor[] lista, int valoresUsados){

        Sensor[] copyList = new Sensor[valoresUsados];

        for (int num = 0; num < valoresUsados; num++){

            copyList[num] = lista[num];

        }

        return copyList;

    }



}
