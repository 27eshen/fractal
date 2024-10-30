import processing.core.PApplet;

public class Main extends PApplet {
    public static PApplet app;
    public boolean click = false;
    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public Main() {
        super();
        app = this;
    }

    public void settings() {
        size(500, 500);
    }

    public void draw() {
        drawFractal(height*2, width/2, height/2, 10);
        if (click){
            int rand = (int)((Math.random()*10) + 1);
            int randh = (int)(Math.random()*(height-1) + 2);
            int randw = (int)(Math.random()*(width-1) + 2);
            drawFractal(height/(rand+1), (randw+1), (randh+1), rand*5);
        }
        delay(200);
    }

    public void mouseClicked() {
        System.out.println("Mouse clicked");
        if (click){
            click = false;
        } else {
            click = true;
        }
    }

    private void drawFractal(int size, int w, int h, int thickness) {
        if (size <= 0) {
            return;
        }

        if (size % 2 == 0){
            Main.app.fill(124, 183, 242);
        } else {
            Main.app.fill(255);
        }

        ellipse(w, h, size, size);
        drawFractal(size-thickness-1, w, h, thickness);
    }
}