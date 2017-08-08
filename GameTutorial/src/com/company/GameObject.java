package com.company;

import java.awt.*;

public abstract class GameObject {
    //This is going to represent all of our game objects
    protected int x, y; // Protected means it can only be accessable by subclasses or a inherited class
    protected ID id;
    protected int velX, velY;//Velocitys of our game objects

    public GameObject(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;


    }


    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract Rectangle getBounds();//We are going to use rectangle to handle collisions.

    //We need to use the intersects method. If the rectangles intersect each other they return true.
    //Each object has a rectangular bound. If it touches that bound it counts as a intersection other wise it does not.
    //So if we deal with objects other than rectangles it would take some math to calculate the collison area.
    public void setX(int x) {

        this.x = x;
    }

    public void setY(int y) {
        this.y = y;


    }

    public int getX() {

        return x;
    }

    public int getY() {
        return y;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    public int getVelX() {
        return velX;
    }

    public int getVelY() {
        return velY;
    }

    //Just a whole bunch of getters and setters.


}
