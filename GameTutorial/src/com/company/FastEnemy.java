package com.company;

import java.awt.*;

//aNOTHER clASS FOr a faster enemy.

public class FastEnemy extends GameObject {
    private Handler handler;
    public FastEnemy(int x, int y, ID id, Handler handler) {

        super(x, y, id);
        this.handler = handler;
        velX = 5;
        velY = 9;

    }


    public void tick() {
        x += velX;
        y += velY;

        if(y<=0 || y>=Game.HEIGHT - 32){

            velY *= -1;
        }
        if(x<=0 || x>=Game.WIDTH - 16){

            velX *= -1;
        }
        handler.addObject(new Trail(x,y,ID.Trail, Color.CYAN,16,16,0.02F,handler));
    }


    public void render(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(x, y, 16, 16);
    }
    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
    }


}
