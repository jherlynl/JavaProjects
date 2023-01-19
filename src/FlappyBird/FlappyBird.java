package FlappyBird;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

public class FlappyBird implements ActionListener, MouseListener {

    public static FlappyBird flappyBird;
    public final int width = 800;
    public final int height = 685;
    public renderer renderer;
    public Rectangle bird;
    public ArrayList<Rectangle> columns;
    public Random random;
    public int ticks, flaps, score;
    public boolean gameOver;
    public boolean started;

    public FlappyBird(){
        JFrame jframe= new JFrame();
        Timer timer = new Timer(20,this );
        renderer = new renderer();
        random = new Random();
        bird = new Rectangle(width/2 -10, height/2 -10, 20, 20 );
        columns = new ArrayList<Rectangle>();

        jframe.setTitle("Flappy Bird Game");
        jframe.add(renderer);
        jframe.setSize(width, height);
        jframe.setVisible(true);
        jframe.setResizable(false);
        jframe.addMouseListener(this);
        jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);

        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);

        timer.start();
    }

    public void addColumn(boolean Start) {
        int space = 300;
        int widthC = 100;
        int heightC = 50 + random.nextInt(300);

        if (Start) {
            columns.add(new Rectangle(width + widthC + columns.size() * 300, height - heightC - 120, widthC, heightC));
            columns.add(new Rectangle(width + widthC + (columns.size() - 1) * 300, 0, widthC, height - heightC - space));
        } else {
            columns.add(new Rectangle(columns.get(columns.size()-1).x+600, height - heightC - 120, widthC, heightC));
            columns.add(new Rectangle(columns.get(columns.size()-1).x, 0, widthC, height - heightC - space));
        }
    }

    public void paintTubes(Graphics g,Rectangle column){
        g.setColor(Color.green.darker().darker());
        g.fillRect(column.x,column.y,column.width,column.height);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int speed = 10;
        ticks++;
        if(started) {
            for (int i = 0; i < columns.size(); i++) {
                Rectangle column = columns.get(i);
                column.x -= speed;
            }
            if (ticks % 2 == 0 && flaps < 15) {
                flaps += 2;
            }

            for (int i = 0; i < columns.size(); i++) {
                Rectangle column = columns.get(i);
                if (column.x + column.width < 0) {
                    columns.remove(column);
                    if (column.y == 0) {
                        addColumn(false);
                    }
                }
            }
            bird.y += flaps;

            for (Rectangle column : columns) {

                if(bird.x+bird.width/2>column.x +column.width/2 - 10 && bird.x +bird.width/2 < column.x + column.width/2+10){
                    score++;
                }
                if (column.intersects(bird)) {
                    gameOver = true;
                    bird.x = column.x-bird.width;
                }
            }
            if ((bird.y > height - 120 || bird.y < 0)) {
                gameOver = true;
            }
            if (bird.y + flaps >=height-120) {
                bird.y=height-120 - bird.height;
            }
        }
        renderer.repaint();
    }
    public void repaint(Graphics g) {
        g.setColor(Color.pink);
        g.fillRect(0,0, width, height );

        g.setColor(Color.orange);
        g.fillRect(0, height -120, width,120);

        g.setColor(Color.green.darker());
        g.fillRect(0,height-120, width,20);

        g.setColor(Color.red);
        g.fillRect(bird.x, bird.y, bird.width, bird.height);

        for(Rectangle column: columns){
            paintTubes(g,column);
        }

        if(!started){
            g.setColor(Color.white);
            g.setFont(new Font("SansSerif", 1, 100));
            g.drawString("Click to start!", 75, height /2 - 10);
        }

        if(gameOver){
            g.setColor(Color.red.darker());
            g.setFont(new Font("SansSerif", 1, 110));
            g.drawString("Game Over!", 84, height/2-10);
        }
    }

    public void jump(){
        if(gameOver){

            bird = new Rectangle(width/2 -10, height/2 -10, 20, 20 );
            columns.clear();
            flaps=0;
            score = 0;

            addColumn(true);
            addColumn(true);
            addColumn(true);
            addColumn(true);

            gameOver=false;
        }

        if(!started){
            started=true;
        } else {
            if (flaps >0){
                flaps = 0;
            }
            flaps-=10;
        }

    }

    public static void main(String[] args) {
        flappyBird = new FlappyBird();

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        jump();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
