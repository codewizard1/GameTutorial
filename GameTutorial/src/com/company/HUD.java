package com.company;

import java.awt.*;

//Heads Up Display
public class HUD {

    public static int HEALTH = 100;

    public void tick() {
       // HEALTH--;//This decreases our Health.


        HEALTH = Game.clamp(HEALTH, 0, 100);

    }

    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 32);
        g.setColor(Color.green);
        g.fillRect(15, 15, HEALTH * 2, 32);
        g.setColor(Color.white);
        g.drawRect(15, 15, 200, 32);
    }


}
