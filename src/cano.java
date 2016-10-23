package src;

import java.util.Random;


public class cano {
    double posX,
           posY;
    int size;
    boolean alive;
    Random aleatorio = new Random();
    Hitbox pipeHitBoxCIMA;
    Hitbox pipeHitBoxBAIXO;
    
    public cano(){
        posX = 500;
        posY = -50;
        alive = true;
        size = aleatorio.nextInt(4);
        switch(this.size){
            case 1:
                posY = 0;
                break;
            case 2:
                posY = 0;
                break;
            case 3:
                posY = 0;
                break;
            case 4:
                posY = 0;
                break;
        }
        pipeHitBoxCIMA = new Hitbox(posX,posX+55,posY,posY+400);
        pipeHitBoxBAIXO = new Hitbox(posX,posX+55,posY,posY+400);
    }
    public void mover(double dt){
        posX -= 40*dt;
        this.pipeHitBoxCIMA.mover(-40*dt,0);
        this.pipeHitBoxBAIXO.mover(-40*dt,0);
    }
    public void draw(Tela tela){
        if(this.alive){
            System.out.println("009");
            tela.imagem("flappy.png", 602, 0, 55, 272, 0, this.posX, this.posY);
            tela.imagem("flappy.png", 658, 0, 55, 272, 0, this.posX, this.posY);
          }
    }
    public void kill(){
        if(this.posX < -100)this.alive = false;
    }
}
