public class BichoNormal extends Bicho{

    BichoNormal(){
        super(10);
    }

    @Override
    public String toString(){
        return "BN-" + this.getSalud();
    }
    
}
