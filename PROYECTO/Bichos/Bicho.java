public class Bicho {

    private int salud;

    public Bicho(int salud){
        this.salud = salud;
    }

    public void setSalud(int salud){
        this.salud = salud;
    }

    public int getSalud(){
        return this.salud;
    }

    public void atacado(){

        this.setSalud(this.getSalud()-5);

    }

    
}
