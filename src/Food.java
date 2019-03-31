public class Food {
    float x;
    float y;
    float skala;

    Food(){

    }
    void pickLocation(){
        float rows = Main.processing.floor(Main.processing.width/skala);
        float cols = Main.processing.floor(Main.processing.height/skala);
        this.x = Main.processing.floor(Main.processing.random(rows))*skala;
        this.y = Main.processing.floor(Main.processing.random(cols))*skala;
    }
}
