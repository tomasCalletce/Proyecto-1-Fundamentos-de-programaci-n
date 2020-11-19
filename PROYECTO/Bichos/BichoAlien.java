public class BichoAlien extends Bicho{

    BichoAlien(){
        super(20);
    }

    @Override
    public String toString(){
        return "BA-" + this.getSalud();
    }
    
}
