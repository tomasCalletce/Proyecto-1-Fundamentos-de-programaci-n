import java.util.ArrayList;

public class Sensor{

    private String tipo;
    private double valor;
  

    Sensor(){
        this("",0);
    }

    Sensor(String t,double v){
        this.tipo = t;
        this.valor = v;
    }

    public void setTipo(String tipo){this.tipo = tipo;};
    public String getTipo(){return this.tipo;}

    public void setValor(double valor){this.valor = valor;};
    public double getValor(){return this.valor;};

    public String toString(){
        return "| " + this.tipo + "-" + this.valor + " |" ;
    }

    



} 