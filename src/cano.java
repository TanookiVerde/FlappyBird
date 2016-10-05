import java.util.Random;


public class cano {
	double posX,
	       posY,
	       size;
    Random aleatorio = new Random();
    
	public cano(){
		posX = 850;
		posY = 400;
		size = aleatorio.nextInt(4);
	}
	public void mover(double dt){
		posX -= 10*dt;
	}
}
