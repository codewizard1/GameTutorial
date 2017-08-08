package com.company;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler) {

        this.handler = handler;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        //System.out.println(key);//When you press a key it prints out a random number
        for (int i = 0; i < handler.object.size(); i++) {

            GameObject tempObject = handler.object.get(i);
            if (tempObject.getId() == ID.Player) {

                //Key events for player 1

                if (key == KeyEvent.VK_W) {//If we are hitting w do this code

                    tempObject.setVelY(-5);//THis la.st number is the velocity of the moving object

                }
                if (key == KeyEvent.VK_S) {//If we are hitting S do this code

                    tempObject.setVelY(5);//THis la.st number is the velocity of the moving object

                }
                if (key == KeyEvent.VK_D) {//If we are hitting D do this code

                    tempObject.setVelX(5);//THis la.st number is the velocity of the moving object

                }
                if (key == KeyEvent.VK_A) {//If we are hitting A do this code

                    tempObject.setVelX(-5);//THis la.st number is the velocity of the moving object

                }

            }
            /*
            if (tempObject.getId() == ID.Player2) {

                //Key events for player 2


                if (key == KeyEvent.VK_UP) {//If we are hitting w do this code

                    tempObject.setVelY(-5);//THis la.st number is the velocity of the moving object

                }
                if (key == KeyEvent.VK_DOWN) {//If we are hitting S do this code

                    tempObject.setVelY(5);//THis la.st number is the velocity of the moving object

                }
                if (key == KeyEvent.VK_RIGHT) {//If we are hitting D do this code

                    tempObject.setVelX(5);//THis la.st number is the velocity of the moving object

                }
                if (key == KeyEvent.VK_LEFT) {//If we are hitting A do this code

                    tempObject.setVelX(-5);//THis la.st number is the velocity of the moving object

                }

            }*/


        }

        if (key == KeyEvent.VK_ESCAPE) {//If we hit escape exits out of the game

            System.exit(1);
        }


    }


    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        //System.out.println(key);//When you press a key it prints out a random number
        for (int i = 0; i < handler.object.size(); i++) {

            GameObject tempObject = handler.object.get(i);
            if (tempObject.getId() == ID.Player) {

                //Key events for player 1

                if (key == KeyEvent.VK_W) {//If we are hitting w do this code

                    tempObject.setVelY(0);//THis la.st number is the velocity of the moving object

                }
                if (key == KeyEvent.VK_S) {//If we are hitting S do this code

                    tempObject.setVelY(0);//THis la.st number is the velocity of the moving object

                }
                if (key == KeyEvent.VK_D) {//If we are hitting D do this code

                    tempObject.setVelX(0);//THis la.st number is the velocity of the moving object

                }
                if (key == KeyEvent.VK_A) {//If we are hitting A do this code

                    tempObject.setVelX(0);//THis la.st number is the velocity of the moving object

                }

            }
            //0 tells the to stop moving the object
            /*
            if (tempObject.getId() == ID.Player2) {

                //Key events for player 2


                if (key == KeyEvent.VK_UP) {//If we are hitting w do this code

                    tempObject.setVelY(0);//THis la.st number is the velocity of the moving object

                }
                if (key == KeyEvent.VK_DOWN) {//If we are hitting S do this code

                    tempObject.setVelY(0);//THis la.st number is the velocity of the moving object

                }
                if (key == KeyEvent.VK_LEFT) {//If we are hitting D do this code

                    tempObject.setVelX(0);//THis la.st number is the velocity of the moving object

                }
                if (key == KeyEvent.VK_RIGHT) {//If we are hitting A do this code

                    tempObject.setVelX(0);//THis la.st number is the velocity of the moving object

                }

            }
            */


        }
    }
}
