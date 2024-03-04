// Changelog:
// 1. The framework of the game, including the objects (snake and fruit).
// 2. Specify the basic behaviours such as
//        a. moving behaviours (directions), and conditions of moving out of boundaries.
//        b. time intervals that allows the next keypress.

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.util.Timer;

public class Main extends JPanel implements KeyListener {
    public static final int CELL_SIZE = 20;
    public static int width = 400;
    public static int height = 400;
    public static int row = height / CELL_SIZE;
    public static int column = width / CELL_SIZE;
    private Snake snake;
    private Fruit fruit;
    private Timer t;
    private int speed = 150; // Delay between game updates in milliseconds.
    private static String direction;
    private boolean allowKeyPress; // Determine when the key press is allowed.

    public Main(){
        snake = new Snake();
        fruit = new Fruit();
        t = new Timer();
        // Schedules task execution at a fixed rate, with the provided delay between runs.
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            // Re-execute the component in 'paintComponent'.
            public void run() { repaint();}
        }, 0, speed);
        // Initial direction of the snake.
        direction = "right";
        addKeyListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        System.out.println("Repaint component...");
        g.fillRect(0, 0, width, height);
        snake.drawSnake(g);
        fruit.drawFruit(g);
//         Remove the last part of snake body and add a new one at topmost.
//         The full arraylist of coordinate is retrieved from Snake.java,
//         which we only care about the head part of snake
        int snakeX = snake.getSnakeBody().get(0).x;
        int snakeY = snake.getSnakeBody().get(0).y;
        System.out.println("Coordinate of Head:("+snakeX+", "+snakeY+")");

        // Update game state based on the current direction
        if(direction.equals("right")){
            snakeX += CELL_SIZE;
        } else if(direction.equals("left")){
            snakeX -= CELL_SIZE;
        } else if(direction.equals("up")){
            snakeY -= CELL_SIZE;
        } else if(direction.equals("down")){
            snakeY += CELL_SIZE;
        }

        // Create a new head node for the snake
        Node newHead = new Node(snakeX, snakeY);
//        Retrieve the full length of the snake and remove the last node of the snake.
//        Note that subtract by 1 to remove the last "index" of the snake.
        snake.getSnakeBody().remove(snake.getSnakeBody().size()-1);
        snake.getSnakeBody().add(0, newHead); // Put the new head into the top-most of the snake
        allowKeyPress = true;
        requestFocusInWindow(); // Ensures the panel receives keyboard input.
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("Snake Eating");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new Main());
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setResizable(false);
    }

    // The following code inherits the implements of 'KeyListener'

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // To specify the behaviour of the snake
        // System.out.println(e.getKeyCode()); // L:37, U:38, R:39, D:40
        if(allowKeyPress){
            if(e.getKeyCode() == 37 && !direction.equals("right")){
                direction = "left";
            } else if (e.getKeyCode() == 38 && !direction.equals("down")) {
                direction = "up";
            } else if (e.getKeyCode() == 39 && !direction.equals("left")) {
                direction = "right";
            } else if (e.getKeyCode() == 40 && !direction.equals("up")) {
                direction = "down";
            }
        }
        allowKeyPress = false;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

