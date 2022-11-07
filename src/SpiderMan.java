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


    //This is a constructor that takes 3 parameters.
    // This allows us to specify the hero's name and position when we build it.
    public SpiderMan(String pName, int pXpos, int pYpos) { // Astronaut constructor
        name = pName;
        xpos = pXpos;
        ypos = pYpos;
        dx = 2;
        dy = 2;
        width = 60;
        height = 60;
        isAlive = true;

    } // end Astronaut constructor

    //The move method.  Everytime this is run (or "called") the hero's x position and y position change by dx and dy
    public void move() { // move
        xpos = xpos + dx;
        ypos = ypos + dy;

    } // end move

    public void bounce() {
        xpos = xpos + dx;
        ypos = ypos + dy;
        //if alien hits the border, make dx and dy  negative
        if (xpos == 1000 - width || xpos <= 0) {
            dx = -dx;
        }
        if (ypos == 700 - height || ypos == 0) {
            dy = -dy;
        }
    }

    public void wraparound(){
        xpos = xpos + dx;
        ypos = ypos + dy;
        if(xpos >= 1000 && dx > 0){
            xpos = -width;
        }
        if(xpos <= -width && dx < 0){
            xpos = 1000;
        }
        if(ypos >= 700 && dy > 0){
            ypos = -height;
        }
        if(ypos <= -height && dy < 0){
            ypos = 700;
        }
    }
}






