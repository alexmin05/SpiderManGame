//Basic Game Application
//Version 2
// Basic Object, Image, Movement
// Astronaut moves to the right.
// Threaded

//K. Chun 8/2018

//*******************************************************************************
//Import Section
//Add Java libraries needed for the game
//import java.awt.Canvas;

//Graphics Libraries
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;


//*******************************************************************************
// Class Definition Section

public class SpideyAndVenom implements Runnable {

    final int WIDTH = 1000;
    final int HEIGHT = 600;

    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;

    public BufferStrategy bufferStrategy;
    public Image spideyPic;
    public Image venomPic;
    public Image carnagePic;
    public Image cityPic;
    public Image bankPic;
    public Image damagedbankPic;
    public Image almostdestroyedbankPic;
    public Image rubblePic;

    public SpiderMan spidey;
    public SpiderMan venom;
    public SpiderMan carnage;
    public SpiderMan bank;

    public int damage;


    public static void main(String[] args) {
        SpideyAndVenom ex = new SpideyAndVenom();
        new Thread(ex).start();
    }

    public SpideyAndVenom() { // BasicGameApp constructor

        setUpGraphics();
      spideyPic = Toolkit.getDefaultToolkit().getImage("SpiderManPng.png"); //load the picture
        spidey = new SpiderMan("spidey",10,100); //construct the astronaut
        spidey.dy = 0;

        venomPic = Toolkit.getDefaultToolkit().getImage("Venom.png");
        venom = new SpiderMan("venom", 800, 400);

        carnagePic = Toolkit.getDefaultToolkit().getImage("carnage.png");
        carnage = new SpiderMan("carnage", 405, 250);

        cityPic = Toolkit.getDefaultToolkit().getImage("city.jpg");

        bankPic = Toolkit.getDefaultToolkit().getImage("bank.png");
        bank = new SpiderMan("bank", 0, 400);

        damagedbankPic = Toolkit.getDefaultToolkit().getImage("damagedbank.png");

        almostdestroyedbankPic = Toolkit.getDefaultToolkit().getImage("almostdestroyedbank.png");

        rubblePic = Toolkit.getDefaultToolkit().getImage("rubble.png");


    }
    public void run() {

        while (true) {
            movement();
            crashVS();
            crashCV();
            crashSC();
            crashBS();
            crashBC();
            crashBV();
            render();
            pause(20);
        }
    }

    public void movement() {
        spidey.wraparound();
        venom.bounce();
        carnage.carnagebounce();
        bank.bankstuff();
        damage = 0;
    }

    public void crashVS() {
        if(venom.rec.intersects(spidey.rec)) {
            venom.dx = -venom.dx;
            venom.dy = -venom.dy;
            spidey.dx = -spidey.dx;
            spidey.dy = -spidey.dy;
        }
    }

    public void crashSC() {
        if(spidey.rec.intersects(carnage.rec)) {
            carnage.dx = 1;
            carnage.dy = 4;
            spidey.dx = 3;
            spidey.dy = 2;
        }
    }

    public void crashCV() {
        if(carnage.rec.intersects(venom.rec)) {
            carnage.xpos = venom.xpos;
            carnage.ypos = venom.ypos;
            carnage.bounce();
        }
    }

    public void crashBS() {
        if(spidey.rec.intersects(bank.rec)) {
            spidey.dx = -spidey.dx;
            spidey.dy = -spidey.dy;
            damage = 1;
        }
    }

    public void crashBC() {
        if(carnage.rec.intersects(bank.rec)) {
            carnage.dx = -carnage.dx;
            carnage.dy = -carnage.dy;
            damage = 3;
        }
    }

    public void crashBV() {
        if(venom.rec.intersects(bank.rec)) {
            venom.dx = -venom.dx;
            venom.dy = -venom.dy;
            damage = 2;
        }
    }

    public void pause(int time ) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }


    private void setUpGraphics() {
        frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);

        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");
    }

    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);
        g.drawImage(cityPic,0,0, WIDTH, HEIGHT, null);

        if(damage == 0) {
            g.drawImage(bankPic, 0, 400, WIDTH / 4, HEIGHT / 3, null);
        }
        if(damage == 1) {
            g.drawImage(damagedbankPic, 0, 400, WIDTH/4, HEIGHT/3, null);
        }
        if(damage == 2) {
            g.drawImage(almostdestroyedbankPic, 0, 400, WIDTH/4, HEIGHT/3, null);
        }
        if(damage == 3) {
            g.drawImage(rubblePic, 0, 100, WIDTH, HEIGHT, null);
        }

        g.drawImage(spideyPic, spidey.xpos, spidey.ypos, spidey.width, spidey.height, null);

        g.drawImage(venomPic, venom.xpos, venom.ypos, venom.width, venom.height, null);

        g.drawImage(carnagePic, carnage.xpos, carnage.ypos, carnage.width, carnage.height, null);

        g.dispose();
        bufferStrategy.show();
    }
}