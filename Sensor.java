public class Sensor{

    public static Sensor[] sensores = new Sensor[8];
    public static int tamano = 8;
    public static int posAnadir = 0;
    private String tipo;
    private double valor;


    Sensor(){

        this("",0);

    }

    Sensor(String t,double v){

        this.tipo = t;
        this.valor = v;

        sensores[posAnadir] = this; 
        posAnadir++;

    }

    public void setTipo(String tipo){this.tipo = tipo;};
    public String getTipo(){return this.tipo;}

    public void setValor(double valor){this.valor = valor;};
    public double getValor(){return this.valor;};

    public String toString(){

        return this.tipo + " " + this.valor;
        

    }

    public static String toStringSensores(){

        String info = "";

        for (int num = 0; num < posAnadir;num++){

            info = info + sensores[num] + "\n";

        }

        return info;
    }

    public static int cantidadSensores(){

        return posAnadir;

    }



    




} 