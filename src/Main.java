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
            background(200); // Clear the background
            drawFractal(height * 2, width / 2, height / 2, 10, false, false, 10); // Redraw the initial large fractal
            count = 0; // Reset the count
        }

        int rand = (int) ((Math.random() * 10) + 10); // Random size factor
        int randh = (int) (Math.random() * height); // Random vertical position
        int randw = (int) (Math.random() * width); // Random horizontal position

        drawFractal(rand * 10, randw, randh, rand, true, false, 10); // Draw a smaller fractal
        count++;
    }

    private void drawFractal(int size, int w, int h, int thickness, boolean randomColor, boolean white, int minLayers) {
        if (size <= 0 && minLayers <= 0) {
            return; // Stop recursion only if size is too small and minimum layers are exhausted
        }

        if (!white) {
            if (randomColor) {
                int r = (int) random(0, 256); // Generate random red value
                int g = (int) random(0, 256); // Generate random green value
                int b = (int) random(0, 256); // Generate random blue value
                Main.app.fill(r, g, b, 50); // Set random color
            } else {
                Main.app.fill(252, 197, 214); // Default pink color
            }
        } else {
            Main.app.fill(255); // White color
        }

        ellipse(w, h, size, size); // Draw the circle

        white = !white; // Alternate colors

        // Recursively draw the next layer
        drawFractal(Math.max(size - thickness, 0), w, h, thickness, randomColor, white, minLayers - 1);
    }
}
