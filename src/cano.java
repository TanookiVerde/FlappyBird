package src;

import java.util.Random;


public class cano{
    double posX,
           posY;
    int size;
    boolean alive, print;
    Random aleatorio = new Random();
    Hitbox pipeHitBoxCIMA;
    Hitbox pipeHitBoxBAIXO;
    
    public cano(){
        posX = 288;
        posY = -50;
        alive = true;
        print = true;
        size = aleatorio.nextInt(4);
        posY = -50*size;
        pipeHitBoxCIMA = new Hitbox(posX,posY,posX+55,posY+272);
        pipeHitBoxBAIXO = new Hitbox(posX,posY+400,posX+55,posY+400+272);
    }
    public void mover(double dt){
        posX -= 40*dt;
        this.pipeHitBoxCIMA.mover(posX,posY,posX+55,posY+272);
        this.pipeHitBoxBAIXO.mover(posX,posY+400,posX+55,posY+400+272);
    }
    public void draw(Tela tela){
        if(this.print){
            tela.imagem("flappy.png", 602, 0, 55, 272, 0, this.posX, this.posY);
            tela.imagem("flappy.png", 658, 0, 55, 272, 0, this.posX, this.posY+400);
          }
    }
    public void kill(){
        if(this.posX < -500)this.print = false;
    }
}
