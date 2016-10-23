package src;

import java.util.Set;
import java.util.HashSet;
import java.util.Random;

public class flappybird implements Jogo
{
        passaro bird;
        int largura, altura;
        double tempoSpawn = 0;
        Set<cano> listaTubos = new HashSet<cano>();
        
        public flappybird(){
            bird = new passaro();
            largura = getLargura();
            altura = getAltura();
        }
        public String getTitulo(){
            return "FlappyBird";
        }
        public int getLargura(){
            return 288;
        }
        public int getAltura(){
            return 512;
        }
        public void tique(Set<String> keys, double dt){
            bird.gravidade(dt);
            bird.pulando();
            bird.mover(dt);
            bird.kill();
            
            for(cano tubo: this.listaTubos){
                tubo.mover(dt);
                if( bird.hitbox.intersecao(tubo.pipeHitBoxCIMA)>0 || bird.hitbox.intersecao(tubo.pipeHitBoxBAIXO)>0 ){
                    bird.alive = false;
                    break;
                }
            }
            spawn(dt);
        }
        public void tecla(String tecla){
            if(tecla.contains(" ")) bird.pular();
        }
        public void desenhar(Tela screen){
            //CENARIO
            screen.imagem("flappy.png", 0, 0, 288, 512, 0, 0, 0);
            screen.imagem("flappy.png", 292, -450, 288, 512, 0, 0, 0);
            for(cano tubo: this.listaTubos){
                tubo.draw(screen);
            }
            //PASSARO
            bird.draw(screen);
        }
        public static void main(String[] args){
            new Motor(new flappybird());
        }
        public void spawn(double dt){
           double limite = 3;
           tempoSpawn += dt;
           if (tempoSpawn >= limite){
               cano temp = new cano();
               this.listaTubos.add(temp);
               tempoSpawn = 0;
           }
           }
}
