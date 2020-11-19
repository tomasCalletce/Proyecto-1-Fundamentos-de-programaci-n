import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException;

import java.io.File;

public class Principal{

    private static Scanner sc = new Scanner(System.in);
    

    public static void main(String[] args) {
        Principal.mostrarMenu();
    }

    public static void mostrarMenu(){
        Scanner sc = new Scanner(System.in);

       
        while(true){
            System.out.println("Ingrese un codigo de Ejecución");
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
                case 9:
                    Principal.case9();
                
                break;
                case 10:
                    Principal.case10();

                case 666:
                    Principal.case666();

                break;
            }
            System.out.println("---------");
        }
    }

    public static void case1(){
        System.out.println("Ingrrese los 4 parametros de Vehiculo");
        Vehiculo nuevo = new Vehiculo(sc.nextInt(),sc.next(),sc.nextDouble(),sc.next());
    }

    public static void case2(){
        System.out.println("Vehiculos existentes:");
        System.out.println(Vehiculo.toStringVeiculos());
    }

    public static void case3(){
        System.out.println("Cantidad de vehiculos existentes:");
        System.out.println(Vehiculo.cantidadVeiculos());
    }

    public static void case4(){
        System.out.println("Cantidad de vehiculos  verdes existentes:");
        Vehiculo.vehiculosVerdes();
    }

    public static void case5(){
        System.out.println("Ingrese el id del veiculo que quire imprimir:");
        int id = sc.nextInt();
        try {
            System.out.println(Vehiculo.getVehiculoById(id).toString());
          }
          catch(Exception e) {
            System.out.println("No existe in Vehiculo con ese id");
          }
    }

    public static void case6(){
        System.out.println("Ingrese el id de un Vehiculo para crear un sensor: ");
        int id = sc.nextInt();
        try {
            Vehiculo vei = Vehiculo.getVehiculoById(id);
            System.out.println("Ingrese los 2 parametros de Sensor: ");
            String tipo = sc.next();
            int valor = sc.nextInt();
            Sensor senso = new Sensor(tipo,valor);
            vei.añadirSensor(senso);
          }
          catch(Exception e) {
            System.out.println("No existe in Vehiculo con ese id");
          }

    
    }

    public static void case7(){
        System.out.println("Ingrese el id del veiculo para imprimir sus sensores:");
        int id = sc.nextInt();
        try {
            Vehiculo vei = Vehiculo.getVehiculoById(id);
            System.out.println(vei.SensoresToString());
          }
          catch(Exception e) {
            System.out.println("No existe in Vehiculo con ese id");
          }

    }

    public static void case8(){
        System.out.println(Vehiculo.getAllSensoresTemperatura());
    }

    public static void case9(){
        System.out.println(Vehiculo.veiculoConMasSensores().toString());
    }

    public static void case10(){

        Principal.leerYAplicarBaseDeDatos();
        
    }


    public static void case666(){
        System.out.println(Vehiculo.ordernarSensordeTemperatura());
    }

    public static void leerYAplicarBaseDeDatos(){

        try{

            File info = new File("baseDatos.txt");
            Scanner lectorDeInfo = new Scanner(info);

            while(lectorDeInfo.hasNextLine()){
                String line = lectorDeInfo.nextLine();
                Principal.crearObjetosVehiculo(line);
        
             
            }
            lectorDeInfo.close();
        }catch(FileNotFoundException err){
            System.out.println("Hay un error en la lectura de la base de datos.");
        }


    }

    public static void crearObjetosVehiculo(String line){

        int año = Integer.parseInt(line.substring(0,line.indexOf(",")));
        String marca = line.substring(line.indexOf(",")+1,line.indexOf((","),line.indexOf(",")+1));
        double valor = Double.parseDouble(line.substring(line.indexOf(marca)+marca.length()+1,line.indexOf(",",line.indexOf(marca)+marca.length()+1)));
        String color = line.substring(String.valueOf(año).length()+marca.length()+String.valueOf(valor).length()+1,line.length());

        Vehiculo vei = new Vehiculo(año,marca,valor,color);

    }


}
