package com.company;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 640;
    public static final int HEIGHT = WIDTH / 12 * 9;
    //Lets make a thread
    private Thread thread;
    private boolean running = false;
    private Handler handler;
    private Random r;
    private HUD hud;

    public Game() {

        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));


        Window window = new Window(WIDTH, HEIGHT, "Dodge Game", this);
        hud = new HUD();

        r = new Random();
        // for (int i = 0; i < 50; i++) {//This basically adds 50 objects
        //    handler.addObject(new Player(0, 0, ID.Player));//This gets us a white box!
        //handler.addObject(new Player(200, 200, ID.Player));//Adds another object to the box.
        // }

        handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player ,  handler));//Spawns in the middle of the screen
        //Only one player here .
        //handler.addObject(new Player(WIDTH/2+64, HEIGHT/2-32,ID.Player2));//Adds player 2 here

        //for(int i = 0 ; i< 20; i++) {//If we want 20 enemies in the room
        //  handler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy));
        //}
        for(int i = 0; i<5;i++) {//Adds a couple enemies to the game
            handler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy, handler));
        }
    }

    public synchronized void start() {
        thread = new Thread(this);
        //This instance of this class
        thread.start();
        running = true;

    }

    public synchronized void stop() {

        try {

            thread.join();
            running = false;

        } catch (Exception e) {
            e.printStackTrace();

        }


    }

    public void run() {
        this.requestFocus();//I dont need to click on the screen to enter my keybpard inputs.
        long lastTime = System.nanoTime(); // get current time to the nanosecond
        double amountOfTicks = 60.0; // set the number of ticks
        double ns = 1000000000 / amountOfTicks; // this determines how many times we can devide 60 into 1e9 of nano seconds or about 1 second
        double delta = 0; // change in time (delta always means a change like delta v is change in velocity)
        long timer = System.currentTimeMillis(); // get current time
        int frames = 0; // set frame variable
        while (running) {
            long now = System.nanoTime(); // get current time in nonoseconds durring current loop
            delta += (now - lastTime) / ns; // add the amount of change since the last loop
            lastTime = now;  // set lastTime to now to prepare for next loop
            while (delta >= 1) {
                // one tick of time has passed in the game this
                //ensures that we have a steady pause in our game loop
                //so we don't have a game that runs way too fast
                //basically we are waiting for  enough time to pass so we
                // have about 60 frames per one second interval determined to the nanosecond (accuracy)
                // once this pause is done we render the next frame
                tick();
                delta--;  // lower our delta back to 0 to start our next frame wait
            }
            if (running) {
                render(); // render the visuals of the game
            }
            frames++; // note that a frame has passed
            if (System.currentTimeMillis() - timer > 1000) { // if one second has passed
                timer += 1000; // add a thousand to our timer for next time
                System.out.println("FPS: " + frames); // print out how many frames have happend in the last second
                frames = 0; // reset the frame count for the next second
            }
        }
        stop(); // no longer running stop the thread
    }

    private void tick() {
        handler.tick();
        hud.tick();

    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {

            this.createBufferStrategy(3);//How many buffers it creates.


            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);
        hud.render(g);
        g.dispose();
        bs.show();


    }

    public static int clamp(int var, int min, int max) {
        if (var >= max) {//If our x value is greater than or equal to width return var = max so
            //player never goes out of the board.
            return var = max;
        } else if (var <= min) {
            return var = min;
        } else {
            return var;
        }


    }


    public static void main(String[] args) {
        Game game = new Game();

    }


}

