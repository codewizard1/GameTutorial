package com.company;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

    //This handler classis going to update and render all the objects in our game
    //Handle and process each one of those objects
    //Will loop through every object and render and update them to the screen individually.

    LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick() {
        for (int i = 0; i < object.size(); i++) {//Going to loop through every one of our game objects
            GameObject tempObject = object.get(i);//Get an object at a position in a Linked List
            //We are setting our temp object to a function within the Linked List to get the Id of what object
            //we are at.
            tempObject.tick();


        }


    }

    public void render(Graphics g) {

        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.render(g);


        }

    }

    public void addObject(GameObject object) {

        this.object.add(object);


    }

    public void removeObject(GameObject object) {

        this.object.remove(object);

    }


}
