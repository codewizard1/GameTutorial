package com.company;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {
    Random r = new Random();
    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {


        super(x, y, id);
        //  velX = r.nextInt(5) + 1;
        //velY = r.nextInt(5);
        this.handler = handler;


    }

    public void tick() {

        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.WIDTH - 37);
        y = Game.clamp(y, 0, Game.HEIGHT - 60);

        collision();


        //    handler.addObject(new Trail(x,y,ID.Trail,Color.red,32,32,0.02F,handler));
        //This makes a trail on the player. Optional Xd.

    }

    private void collision() {

        for (int i = 0; i < handler.object.size(); i++) {

            GameObject tempObject = handler.object.get(i);
            if (tempObject.getId() == ID.BasicEnemy) {

                //COllision code
                if (getBounds().intersects(tempObject.getBounds())) {//If the player intersects the enemy then decrease Health by 2
                    HUD.HEALTH -= 2;

                }
            }
        }
    }


    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        //Graphics 2D has the method that we need.

        if (id == ID.Player) {

            g.setColor(Color.white);
        }
        //else if(id == ID.Player2){

        //  g.setColor(Color.blue);

        // }

        g.fillRect(x, y, 32, 32);

    }


    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }

}
