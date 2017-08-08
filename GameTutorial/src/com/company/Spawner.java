package com.company;

import java.util.Random;

public class Spawner {//This class is for spawning the enemies

    private Handler handler;
    private HUD hud;
    private int scoreKeep = 0;
    private Random r = new Random();

    public Spawner(Handler handler, HUD hud) {

        this.handler = handler;
        this.hud = hud;


    }

    private int counter = 1;

    public void tick() {
        scoreKeep++;
        if (scoreKeep >= 100) {//Every time the score hits 1000 increase the level by one.
            //This will be go on forever.

            scoreKeep = 0;//If this wasent here the level would just keep increasing as it hits 1000
            //WE dont want that
            //Need to reset the counter.
            hud.setLevel(hud.getLevel() + 1);



         if (hud.getLevel() == 2) {

                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));

         }
         else if(hud.getLevel() == 3){
             //YOu can control the game right now. Two enemies will spawn every level 3 or more.

             handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
             handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));

         }
         else if(hud.getLevel() == 4){
        //Adds a new fast enemy once we get to level 4. 

             handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT-50), ID.fastEnemy, handler));


         }

        }


    }
}
