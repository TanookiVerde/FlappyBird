package src;


public class passaro {
    int posX,//Posicao X
        posY,//Posicao Y
        score;//Pontuacao
    boolean alive;//Passaro esta vivo?
    double angulo,//angulo para sprite
           forcaPulo,//a forca que bater asas dá ao corpo
           gravidade,//gravidade
           velocidade;//velocidade vertical
    Hitbox hitbox;//hitbox
    public passaro(){
        posX = 100;
        posY = 250;
        score = 0;
        velocidade = 0.3;
        angulo = 0;
        forcaPulo = 0.0;
        gravidade = 7.0;
        alive = true;
        hitbox = new Hitbox(posX,posY,posX+34,posY+24);
    }
    public void gravidade(double dt){
        this.velocidade += gravidade*dt;
        if(this.angulo < Math.PI/2)this.angulo += Math.PI*5/4*dt; 
    }
    public void pulando(){
        this.velocidade -= forcaPulo;
        if(forcaPulo >= 0){this.forcaPulo -= 10;}
        }
    public void pular(){
        this.forcaPulo = 110.0;
        this.angulo = -Math.PI/3;
    }
    public void mover(double dt){
        this.posY += this.velocidade*dt;
        this.hitbox.mover(posX,posY,posX+34,posY+24);
    }
    public void draw(Tela tela){
        if(this.alive)tela.imagem("flappy.png", 528, 180, 34, 24, this.angulo, this.posX    , this.posY);
    }
    public void kill(){
        if(this.posY > 450)this.alive = false;
    }
    public void AddScore(cano tubo){
       if(tubo.posX+55 < this.posX && tubo.alive && this.alive){
           this.score++;
           tubo.alive = false;
           }
       }
    public void Replay(){
       this.alive = true;
       this.posX = 100;
       this.posY = 250;
       this.angulo = 0;
       this.score = 0;
       this.velocidade = 0.3;
       this.forcaPulo = 0.0;
       this.hitbox.mover(posX,posY,posX+34,posY+24);
       }
}
