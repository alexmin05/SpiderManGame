import java.awt.*;

public class SpiderMan {

    //VARIABLE DECLARATION SECTION
    //Here's where you state which variables you are going to use.
    public String name;               //name of the hero
    public int xpos;                  //the x position
    public int ypos;                  //the y position
    public int dx;                    //the speed of the hero in the x direction
    public int dy;                    //the speed of the hero in the y direction
    public int width;                 //the width of the hero image
    public int height;                //the height of the hero image
    public boolean isAlive;           //a boolean to denote if the hero is alive or dead
    public Rectangle rec;


    //This is a constructor that takes 3 parameters.
    // This allows us to specify the hero's name and position when we build it.
    public SpiderMan(String pName, int pXpos, int pYpos) { // SpiderMan constructor
        name = pName;
        xpos = (int)(Math.random()*900+0);
        ypos = (int)(Math.random()*500+0);
        dx = 2;
        dy = 2;
        width = 60;
        height = 60;
        isAlive = true;
        rec = new Rectangle(xpos, ypos, width, height);

    }
    public void carnagebounce() { // Carnage's unique bounce (not actually different from regular bounce)
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

    public void bounce() { // how Venom bounces off the limits of the city
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

    public void wraparound(){ // how Spidey "walks through walls" and appears on the opposite side
        dx = 2;
        dy = 1;
        xpos = xpos + dx;
        ypos = ypos + dy;
        if(xpos >= 1000 && dx > 0){
            xpos = -width;
        }
        if(xpos <= -width && dx < 0){
            xpos = 1000;
        }
        if(ypos >= 600 && dy > 0){
            ypos = -height;
        }
        if(ypos <= -height && dy < 0){
            ypos = 600;
        }
        rec = new Rectangle(xpos, ypos, width, height);
    }

    public void bankstuff(){ // bank's rectangle
        rec = new Rectangle(0, 400, 250, 220);
    }

    public void schoolstuff(){ // school's rectangle
        rec = new Rectangle(725, 350,300, 250);
    }
}






