package com.company;

import java.awt.*;

//Heads Up Display
public class HUD {

    public static int HEALTH = 100;

    private int greenValue = 255; //0 is black 255 is a full array of colors
    private int score = 0;//Create a defualt score and level for the game
    private int level = 1;

    //If you set green Value to 0 ur gonna get a red color
    public void tick() {
        // HEALTH--;//This decreases our Health. BUt its irrelevent


        HEALTH = Game.clamp(HEALTH, 0, 100);//Makes sure the health bar doesnt go backward out of the board.
        greenValue = Game.clamp(greenValue, 0, 255);

        greenValue = HEALTH * 2;
        score++;
    }

    //This basically sets up our health bar.
    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 32);
        g.setColor(new Color(75, greenValue, 0));
        g.fillRect(15, 15, HEALTH * 2, 32);//Allthese 6 lines of code sets up our Health bar
        //Makes sure it turns red when Health is low.
        g.setColor(Color.white);
        g.drawRect(15, 15, 200, 32);

        g.drawString("Score: " + score, 15, 64);//Draws two strings score and level to the board
        g.drawString("Level: " + level, 15, 80);


    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
