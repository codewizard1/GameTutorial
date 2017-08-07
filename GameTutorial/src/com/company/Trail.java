package com.company;

import java.awt.*;

public class Trail extends GameObject {
    private Handler handler;
    private Color color;
    private int width, height;
    private float life;
    //This code literally is just for the trail in the game. Memorize it.

    //Life can be a value between 0.001 - 0.1
    public Trail(int x, int y, ID id, Color color, int width, int height, float life, Handler handler) {

        super(x, y, id);
        this.handler = handler;

        this.color = color;
        this.height = height;
        this.width = width;
        this.life = life;
    }

    private float alpha = 1F;

    public void tick() {
        if (alpha > life) {

            alpha -= (life - 0.0001f);
        } else {
            handler.removeObject(this);
        }
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g2d.setComposite(makeTransparent(1));//This has to be here
    }

    private AlphaComposite makeTransparent(float alpha) {

        int type = AlphaComposite.SRC_OVER;
        return AlphaComposite.getInstance(type, alpha);
    }

    public Rectangle getBounds() {
        return null;
    }
}





