import java.awt.*;

public class SpiderMan {

    public String name;
    public int xpos;
    public int ypos;
    public int dx;
    public int dy;
    public int width;
    public int height;
    public boolean isAlive;
    public Rectangle rec;

    public boolean right;
    public boolean down;
    public boolean left;
    public boolean up;


    public SpiderMan(String pName, int pXpos, int pYpos) { // SpiderMan constructor
        name = pName;
        xpos = (int) (Math.random() * 900 + 0);
        ypos = (int) (Math.random() * 500 + 0);
        dx = 2;
        dy = 2;
        width = 60;
        height = 60;
        isAlive = true;
        rec = new Rectangle(xpos, ypos, width, height);

    }

    public void move() {

        if (right) {
            xpos = xpos + dx;
            if (xpos >= 1000 && dx > 0) {
                xpos = -width;
            }
        }

        if (down) {
            ypos = ypos + dy;
            if (ypos >= 600 && dy > 0) {
                ypos = -height;
            }
        }

        if (left) {
            xpos = xpos - dx;
            if (xpos <= -width && dx > 0) {
                xpos = 1000;
            }
        }

        if (up) {
            ypos = ypos - dy;
            if (ypos <= -height && dy > 0) {
                ypos = 600;
            }
        }
         rec = new Rectangle(xpos, ypos, width, height);

            }

            public void carnagebounce () { // Carnage's unique bounce (not actually different from regular bounce)
                xpos = xpos - dx;
                ypos = ypos - dy;
                if (xpos >= 1000 - width || xpos <= 0) {
                    dx = -dx;
                }
                if (ypos >= 600 - height || ypos <= 0) {
                    dy = -dy;
                }
                rec = new Rectangle(xpos, ypos, width, height);
            }

            public void bounce () { // how Venom bounces off the limits of the city
                xpos = xpos + dx;
                ypos = ypos + dy;
                //if alien hits the border, make dx and dy  negative
                if (xpos >= 1000 - width || xpos <= 0) {
                    dx = -dx;
                }
                if (ypos >= 600 - height || ypos <= 0) {
                    dy = -dy;
                }
                rec = new Rectangle(xpos, ypos, width, height);
            }

            public void wraparound () { // how Spidey "walks through walls" and appears on the opposite side
                dx = 2;
                dy = 1;
                xpos = xpos + dx;
                ypos = ypos + dy;
                if (xpos >= 1000 && dx > 0) {
                    xpos = -width;
                }
                if (xpos <= -width && dx < 0) {
                    xpos = 1000;
                }
                if (ypos >= 600 && dy > 0) {
                    ypos = -height;
                }
                if (ypos <= -height && dy < 0) {
                    ypos = 600;
                }
                rec = new Rectangle(xpos, ypos, width, height);
            }

            public void bankstuff () { // bank's rectangle
                rec = new Rectangle(0, 400, 250, 220);
            }

            public void schoolstuff () { // school's rectangle
                rec = new Rectangle(725, 350, 300, 250);
            }
        }






