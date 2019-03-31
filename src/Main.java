import processing.core.PApplet;
import processing.core.PVector;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends PApplet {
    public static PApplet processing;

    public static void main(String[] args) {
        PApplet.main("Main", args);
    }

    static Snake s;
    static int skala = 20;
    static boolean dead = true;
    static PVector food;
    static int speed = 10;
    static int highscore;

    public void settings(){
        size(640,480);
    }

    public void setup() {
        processing = this;
        s = new Snake();
        food = new PVector();
        Snake.newFood();
        //frameRate(10);
    }

     public void draw() {
        background(51);
        if(!dead){
            if (Main.processing.frameCount % Main.speed == 0) {
                s.update();
            }
            s.display();
            s.eat();
            fill(255, 0, 0);
            rect(food.x, food.y, skala, skala);
            textAlign(LEFT);
            textSize(19);
            fill(255);
            text("Score: " + s.len, 10, 20);
        }
        else{
            fill(255);
            textAlign(CENTER, CENTER);
            textSize(23);
            text("You dead bitshc \n Click to start", width / 2, height / 2);
         }

    }
    public void keyPressed (){
        if(Main.processing.keyCode == Main.processing.LEFT && Main.s.moveX !=1){
            Main.s.vel.x = -1;
            Main.s.vel.y = 0;
        }if(Main.processing.keyCode == Main.processing.RIGHT && Main.s.moveX !=-1){
            Main.s.vel.x = 1;
            Main.s.vel.y = 0;
        }if(Main.processing.keyCode == Main.processing.UP && Main.s.moveY !=-1){
            Main.s.vel.x = 0;
            Main.s.vel.y = -1;
        }if(Main.processing.keyCode== Main.processing.DOWN && Main.s.moveY !=1){
            Main.s.vel.x = 0;
            Main.s.vel.y = 1;
        }
    }

    public void mousePressed(){
        if(dead){
            s = new Snake();
            Snake.newFood();
            speed = 10;
            dead = false;
        }
    }

}

