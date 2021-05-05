package com.company;

import javax.swing.*;
import java.awt.*;

public class Main extends JPanel{

    final int LOC_WIDTH = 576;
    final int LOC_HEIGHT = 576;

    Direction direction = Direction.UP;

    int x = 256;
    int y = 256;

    void moveNorth() throws Exception {
        direction = Direction.NORTH;
        while (y != 0) {
            y--;
            Thread.sleep(20);
            repaint();
        }
    }
    void moveSouth() throws Exception {
        direction = Direction.SOUTH;
        while (y != LOC_HEIGHT - 64) {
            y++;
            Thread.sleep(20);
            repaint();
        }
    }
    void moveWest() throws Exception {
        direction = Direction.WEST;
        while (x != 0) {
            x--;
            Thread.sleep(20);
            repaint();
        }
    }
    void moveEast() throws Exception {
        direction = Direction.EAST;
        while (x != LOC_WIDTH - 64) {
            x++;
            Thread.sleep(20);
            repaint();
        }
    }
    void moveUp() throws Exception {
        direction = Direction.UP;
        repaint();
        Thread.sleep(100);
    }
    void moveDown() throws Exception {
        direction = Direction.DOWN;
        repaint();
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        main.moveSouth();
        main.moveUp();
        main.moveEast();
    }

    Main() {
        JFrame frame = new JFrame("Doka2");
        frame.setMinimumSize(new Dimension(LOC_WIDTH + 20 ,LOC_HEIGHT + 43));
        frame.getContentPane().add(this);
        frame.setLocation(0,0);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.orange);
        g.fillRect(x,y,64,64);

        g.setColor(Color.DARK_GRAY);
        if (direction.equals(Direction.NORTH)) {
            g.fillRect(x,y + 10,64,54);
        }
        else  if (direction.equals(Direction.DOWN)) {
            g.fillRect(x,y,64,64);
        }
        else  if (direction.equals(Direction.UP)) {
            g.setColor(Color.WHITE);
            g.fillOval(x + 17,y + 10,10,10);
            g.fillOval(x + 49,y + 10,10,10);
            g.setColor(Color.RED);
            g.fillRect(x + 20,y + 50,25,8);
        }
        else  if (direction.equals(Direction.SOUTH)) {
            g.fillRect(x,y,64,54);
        }
        else  if (direction.equals(Direction.WEST)) {
            g.fillRect(x + 10,y,54,64);
        }
        else  if (direction.equals(Direction.EAST)) {
            g.fillRect(x,y,54,64);
        }
    }

}
