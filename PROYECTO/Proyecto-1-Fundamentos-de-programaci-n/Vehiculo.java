import java.util.ArrayList;
import java.util.Arrays;

public class Vehiculo {

    public static  ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    public static int idActual = 1;

    private ArrayList<Sensor> sensores = new ArrayList<>();
    private int id;
    private int modelo;
    private String marca;
    private double valorComercial;
    private String color;

    Vehiculo(){
        this.id = Vehiculo.idActual;
        Vehiculo.idActual++;
        Vehiculo.vehiculos.add(this);
    }

    Vehiculo(int mo, String ma, double va){
        this(mo,ma,va,"verde");
    }

    Vehiculo(int mo, String ma, double va,String co){
        this.modelo = mo;
        this.marca = ma;
        this.valorComercial = va;
        this.color = co;
        this.id = Vehiculo.idActual;
        Vehiculo.idActual++;
        Vehiculo.vehiculos.add(this);
    }

    public void setModelo(int modelo){this.modelo = modelo;};
    public int getModelo(){return this.modelo;};

    public void setMarca(String marca){this.marca = marca;}
    public String getMarca(){return this.marca;};

    public void setValorComercial(int valor){this.valorComercial = valor;};
    public double setValorComercial(){return this.valorComercial;};

    public void setColor(String color){this.color = color;};
    public String getColor(){return this.color;};

    public ArrayList<Sensor> getSensores(){
        return this.sensores;
    }

    public void setSensores(ArrayList<Sensor> senso){
        this.sensores = senso;
    }

    public int getId(){return this.id;};

    public int cantidadSensores(){
        return this.sensores.size();
    }

    public void añadirSensor(Sensor senso){
        this.sensores.add(senso);
    }

    public static String toStringVeiculos(){
        String infoFinal = "";
        for(Vehiculo vei : Vehiculo.vehiculos){

            if(Vehiculo.vehiculos.get(Vehiculo.vehiculos.size()-1).equals(vei)){
                infoFinal = infoFinal + vei.toString();
                break;
            }
            infoFinal = infoFinal + vei.toString() + " , ";
        }
        return infoFinal;
    }

    public static int cantidadVeiculos(){
        return Vehiculo.vehiculos.size();
    }

    public String toString(){
        return "[" + this.modelo + " | " + this.marca + " | " + this.valorComercial + " | " + this.color + " | "  + this.id + " --Sensores: " + this.SensoresToString() + " ]" ;
    }

    public String SensoresToString(){
        String sensoresLista = "";

        for(Sensor senso : this.sensores){
            sensoresLista = sensoresLista + senso.toString();
        }

        return sensoresLista;
    }
   
    public static String vehiculosVerdes(){
        String infoFinal = "";
        for(Vehiculo vei : Vehiculo.vehiculos){

            if(Vehiculo.vehiculos.get(Vehiculo.vehiculos.size()-1).equals(vei)&&vei.getColor().equals("verde")){
                infoFinal = infoFinal + vei.toString();
                break;
            }
            if(vei.getColor().equals("verde")){
                infoFinal = infoFinal + vei.toString() + " , ";
            }
            
        }
        return infoFinal;
    }

   public static Vehiculo getVehiculoById(int id){
       return Vehiculo.vehiculos.get(id-1);
   }
    
   public static String getAllSensoresTemperatura(){
        ArrayList<Sensor> sensoTipoTemperatura = new ArrayList<>();
        String sensoresLista = "";
        for(Vehiculo vei : Vehiculo.vehiculos){

            for(Sensor senso : vei.sensores){
                if(senso.getTipo().equals("temperatura")){
                    sensoTipoTemperatura.add(senso);
                }
            }
        }
        for(Sensor senso : sensoTipoTemperatura){
            sensoresLista = sensoresLista + senso.toString();
        }

        return sensoresLista;

   }

   public static Object veiculoConMasSensores(){

    try {
        int maximo = Vehiculo.vehiculos.get(0).sensores.size();
        Vehiculo masGrande = Vehiculo.vehiculos.get(0);
        for(Vehiculo vei : Vehiculo.vehiculos){
            if(vei.sensores.size()>maximo){
                masGrande = vei;
                maximo = vei.sensores.size();
            }
        }
        return masGrande;
      }
      catch(Exception e) {
        System.out.println("No hay vehiculo existente");
        return "";
      }
      

   }

   public static String ordernarSensordeTemperatura(){
    
    ArrayList<Sensor> listaSensores = Vehiculo.hacerListadeSensoresTempo();

 

    for(int grande = 0; grande < listaSensores.size();grande++){
        for(int peque = grande + 1; peque < listaSensores.size(); peque++){

            if(listaSensores.get(grande).getValor() > listaSensores.get(peque).getValor()){
                Sensor porelmomento = listaSensores.get(grande);
                listaSensores.set(grande,listaSensores.get(peque));
                listaSensores.set(peque,porelmomento);
            }
        }
     
    }

    return listaSensores.toString();

   }

   public static ArrayList<Sensor> hacerListadeSensoresTempo(){

    ArrayList<Sensor> sensoTipoTemperatura = new ArrayList<>();

    for(Vehiculo vei : Vehiculo.vehiculos){

        for(Sensor senso : vei.sensores){
            if(senso.getTipo().equals("temperatura")){
                sensoTipoTemperatura.add(senso);
            }
        }
    }

    return sensoTipoTemperatura;

    }

}
