import processing.core.PApplet;

public class Main extends PApplet {
    public static PApplet app;
    public boolean click = false;
    public int count = 0;

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

    public void setup() {
        background(200); // Set the background color
        drawFractal(height * 2, width / 2, height / 2, 10, false, false, 5); // Draw the initial large fractal
    }

    public void draw() {
        // Nothing here to avoid overwriting
    }

    public void mouseClicked() {
        System.out.println("Mouse clicked");

        if (count >= 15) {
            background(200);
            drawFractal(height * 2, width / 2, height / 2, 10, false, false, 10);
            count = 0;
        }

        int rand = (int) ((Math.random() * 10) + 10); // random size factor
        int randh = (int) (Math.random() * height); // random vertical position
        int randw = (int) (Math.random() * width); // random horizontal position

        drawFractal(rand * 10, randw, randh, rand, true, false, 10);
        count++;
    }

    private void drawFractal(int size, int w, int h, int thickness, boolean randomColor, boolean white, int minLayers) {
        if (size <= 0 && minLayers <= 0) {
            return;
        }

        if (!white) {
            if (randomColor) {
                int r = (int) random(0, 256);
                int g = (int) random(0, 256);
                int b = (int) random(0, 256);
                Main.app.fill(r, g, b, 50); //random color
            } else {
                Main.app.fill(252, 197, 214); // default pink color
            }
        } else {
            Main.app.fill(255); // white color
        }

        ellipse(w, h, size, size);

        white = !white; // alternate colors

        drawFractal(Math.max(size - thickness, 0), w, h, thickness, randomColor, white, minLayers - 1);
    }
}
