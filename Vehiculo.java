public class Vehiculo {

    public static  Vehiculo[] vehiculos = new Vehiculo[10];
    public static int tamano = 10;
    public static int posAnadir = 0;
    private int modelo;
    private String marca;
    private double valorComercial;
    private String color;

    Vehiculo(){

        this(0,"",0,"");



    }

    Vehiculo(int mo, String ma, double va){

        this(mo,ma,va,"verde");
       

    }

    Vehiculo(int mo, String ma, double va,String co){

        this.modelo = mo;
        this.marca = ma;
        this.valorComercial = va;
        this.color = co;

        vehiculos[posAnadir] = this;
        posAnadir++;



    }

    public void setModelo(int modelo){this.modelo = modelo;};
    public int getModelo(){return this.modelo;};

    public void setMarca(String marca){this.marca = marca;}
    public String getMarca(){return this.marca;};

    public void setValorComercial(int valor){this.valorComercial = valor;};
    public double setValorComercial(){return this.valorComercial;};

    public void setColor(String color){this.color = color;};
    public String getColor(){return this.color;};

    public String toString(){

        return this.modelo + " " + this.marca + " " + this.valorComercial + " " + this.color;

    }

    public static String StringVehiculo(){

        String info = "";

        for(int num = 0; num < posAnadir ;num++){

            if(vehiculos[posAnadir - 1] == vehiculos[num]){

                info = info + vehiculos[num].toString();
                break;
             }

      

            info = info + vehiculos[num].toString() + "\n";
           
        }

        return info;


    }

    public static int cantidadVehiculos(){

        return posAnadir;
    }


    
}
