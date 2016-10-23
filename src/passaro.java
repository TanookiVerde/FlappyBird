package src;


public class passaro {
	int posX,
	    posY;
	boolean alive;
	double angulo,
	       forcaPulo,
	       gravidade,
	       velocidade;
	Hitbox hitbox;
	public passaro(){
		posX = 100;
		posY = 250;
		velocidade = 0.5;
		angulo = 0;
		forcaPulo = 0.0;
		gravidade = 10.0;
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
		this.hitbox.mover(0,this.velocidade*dt);
	}
	public void draw(Tela tela){
		if(this.alive)tela.imagem("flappy.png", 528, 180, 34, 24, this.angulo, this.posX, this.posY);
	}
	public void kill(){
		if(this.posY > 450)this.alive = false;
	}
}
