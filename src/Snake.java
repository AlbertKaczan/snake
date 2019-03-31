import processing.core.PApplet;
import processing.core.PVector;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLOutput;
import java.util.ArrayList;

import static processing.core.PApplet.floor;

public class Snake {
    PVector pos;
    PVector vel;
    ArrayList<PVector> history;
    int len;
    int moveX;
    int moveY;
        Snake(){
            pos = new PVector(0,0);
            vel = new PVector();
            history = new ArrayList<PVector>();
            len = 0;

        }

        void update(){
            history.add(pos.copy());
            pos.x += vel.x* Main.skala;
            pos.y += vel.y* Main.skala;
            moveX = floor(vel.x);
            moveY = floor(vel.y);

            pos.x = (pos.x + Main.processing.width) % Main.processing.width;
            pos.y = (pos.y + Main.processing.height) % Main.processing.height;

            if(history.size() > len){
                history.remove(0);
            }
            for (PVector p : history){
                if(p.x == pos.x && p.y == pos.y){
                    Main.dead = true;
                    if(len > Main.highscore) {
                        Main.highscore = len;
                    }
                }
            }
        }

        void eat(){
            if(pos.x == Main.food.x && pos.y == Main.food.y){
                len++;
                if(Main.speed > 5){
                    Main.speed --;
                    System.out.println(Main.speed);
                    newFood();
                }
            }
        }

        void display(){
            Main.processing.fill(255);
            Main.processing.rect(pos.x,pos.y, Main.skala, Main.skala);
            for(PVector p : history){
                Main.processing.rect(p.x,p.y, Main.skala, Main.skala);
            }

        }
        public static void newFood() {
            Main.food.x = floor(Main.processing.random(Main.processing.width));
            Main.food.y = floor(Main.processing.random(Main.processing.height));
            Main.food.x = floor(Main.food.x / Main.skala) * Main.skala;
            Main.food.y = floor(Main.food.y / Main.skala) * Main.skala;
        }



}
