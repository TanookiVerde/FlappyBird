package src;

import java.util.Random;


public class cano {
    double posX,
           posY;
    int size;
    boolean alive;
    Random aleatorio = new Random();
    
    public cano(){
        posX = 850;
        posY = -50;
        alive = true;
        size = aleatorio.nextInt(4);
        switch(this.size){
            case 1:
                posY = -150;
                break;
            case 2:
                posY = -200;
                break;
            case 3:
                posY = -250;
                break;
            case 4:
                posY = -300;
                break;
        }
    }
    public void mover(double dt){
        posX -= 10*dt;
    }
    public void draw(Tela tela){
        if(this.alive){
            tela.imagem("flappy.png", 602, 0, 55, 272, 0, this.posX, this.posY);
            tela.imagem("flappy.png", 658, 0, 55, 272, 0, this.posX, this.posY);
          }
    }
    public void kill(){
        if(this.posX < -100)this.alive = false;
    }
}
