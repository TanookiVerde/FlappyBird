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
           if(bird.alive){
                bird.gravidade(dt);
                bird.pulando();
                bird.mover(dt);
                bird.kill();
                for(cano tubo: this.listaTubos){
                    tubo.mover(dt);
                    bird.AddScore(tubo);
                    tubo.kill();
                    if( bird.hitbox.intersecao(tubo.pipeHitBoxCIMA)>0 || bird.hitbox.intersecao(tubo.pipeHitBoxBAIXO)>0 && bird.alive && tubo.alive && tubo.print){
                        bird.alive = false;
                        tubo.alive = false;
                        ApagaTubos();
                        break;
                    }
                }
                spawn(dt);
        }
        }
        public void tecla(String tecla){
            if (bird.alive && tecla.contains(" ")){ 
                bird.pular();
            }
            else if(!bird.alive && tecla.contains(" ")){
                bird.Replay();                
            }
        }
        public void desenhar(Tela screen){
            //SE O PASSARO ESTIVER MORTO(GAMEOVER):
            if(!bird.alive){
                screen.imagem("flappy.png", 0, 0, 288, 512, 0, 0, 0);
                screen.texto(String.format("SCORE: %d", bird.score), 50, 50,40,Cor.BRANCO);
                screen.texto("REPLAY = SPACE", 50, 200,20,Cor.VERMELHO);
            }
            //SE O PASSARO ESTIVER VIVO:
            else{
                //CENARIO
                screen.imagem("flappy.png", 0, 0, 288, 512, 0, 0, 0);
                //TUBOS
                for(cano tubo: this.listaTubos){tubo.draw(screen);}
                //CHÃO
                screen.imagem("flappy.png", 292, -450, 288, 512, 0, 0, 0);
                //PASSARO
                bird.draw(screen);
                //SCORE
                screen.texto(String.format("SCORE: %d", bird.score), 50, 50,40,Cor.BRANCO);
            
            }
        }
        public static void main(String[] args){
            new Motor(new flappybird());
        }
        public void spawn(double dt){
           double limite = 4;
           if(!bird.alive){return;}
           tempoSpawn += dt;
           if (tempoSpawn >= limite){
               cano temp = new cano();
               this.listaTubos.add(temp);
               tempoSpawn = 0;
           }
        }
        public void ApagaTubos(){
            listaTubos.clear();
        }
}
