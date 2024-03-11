// Changelog 20240311:
// 1. Make fruits appear randomly when eaten.
// 2. Make sure the fruits do not appear on the snake's body.
// 3. Set the icon for the fruit.
// 4. Make the player lose the game if the snake bites itself.

// Changelog 20240304:
// 1. The framework of the game, including the objects (snake and fruit).
// 2. Specify the basic behaviours such as
//        a. moving behaviours (directions), and conditions of moving out of boundaries.
//        b. time intervals that allows the next key press.

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
        // Due to duplicate, all the following code can be replaced by the 'reset()' method:
        reset();
        addKeyListener(this);

//        snake = new Snake();
//        fruit = new Fruit();
//        t = new Timer();
//        // Schedules task execution at a fixed rate, with the provided delay between runs.
//        t.scheduleAtFixedRate(new TimerTask() {
//            @Override
//            // Re-execute the component in 'paintComponent'.
//            public void run() { repaint();}
//        }, 0, speed);
//        // Initial direction of the snake.
//        direction = "right";

    }
    private void setTimer(){
        t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                repaint();
            }
        }, 0, speed);
    }
    private void reset(){
        if(snake!=null){
            snake.getSnakeBody().clear();
        }
        allowKeyPress = true;
        direction = "right";
        snake = new Snake(); // Recall the constructor
        fruit = new Fruit();
        setTimer();
    }

    @Override
    public void paintComponent(Graphics g) {
        System.out.println("Repaint component...");
        g.fillRect(0, 0, width, height);
        // check if the snake bites itself
        ArrayList<Node> snake_body = snake.getSnakeBody();
        Node head = snake_body.get(0);
        for(int i=1; i<snake_body.size(); i++){
            if(snake_body.get(i).x == head.x &&
                    snake_body.get(i).y == head.y){
                allowKeyPress = false; // Stop action
                t.cancel(); // timer action: Terminate the timer.
                t.purge(); // timer action: Remove all cancelled timer.
                int response = JOptionPane.showOptionDialog(this, "Game Over! Would you like to continue?",
                        "Game Over", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null,
                        JOptionPane.YES_OPTION);
                switch (response){
                    case JOptionPane.CANCEL_OPTION -> {

                    }
                    case JOptionPane.NO_OPTION -> {
                        int confirm = JOptionPane.showOptionDialog(this, "Are You Handsome?",
                                "Warning", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,null,
                                JOptionPane.YES_NO_OPTION);
                        switch (confirm){
                            case JOptionPane.CANCEL_OPTION -> {
                                System.exit(0);
                                break;
                            }
                            case JOptionPane.NO_OPTION -> System.exit(0);
                            case JOptionPane.YES_OPTION -> { reset(); return; }
                        }

                    }
                    case JOptionPane.YES_OPTION -> {
                        // Reset all the parameters
                        reset(); return;
                    }
                }
            }
        }

        snake.drawSnake(g);
        fruit.drawFruit(g);
//         Remove the last part of snake body and add a new one at topmost.
//         The full arraylist of coordinate is retrieved from Snake.java,
//         which we only care about the head part of snake
        int snakeX = snake.getSnakeBody().get(0).x;
        int snakeY = snake.getSnakeBody().get(0).y;
        System.out.println("Coordinate of Head:("+snakeX+", "+snakeY+")");

        // Update game state based on the current direction
        switch (direction) {
            case "right" -> snakeX += CELL_SIZE;
            case "left" -> snakeX -= CELL_SIZE;
            case "up" -> snakeY -= CELL_SIZE;
            case "down" -> snakeY += CELL_SIZE;
        }

        // Create a new head node for the snake
        Node newHead = new Node(snakeX, snakeY);
//        Retrieve the full length of the snake and remove the last node of the snake.
//        Note that subtract by 1 to remove the last "index" of the snake.
        if(snake.getSnakeBody().get(0).x == fruit.getX() &&
                snake.getSnakeBody().get(0).y == fruit.getY()){
            // Random set the new coordinate for the fruit after eaten,
            // and which can't be set on the snake body.
            fruit.setNewLocation(snake);
            fruit.drawFruit(g);
            // System.out.println("Eating!");
        } else{
            snake.getSnakeBody().remove(snake.getSnakeBody().size()-1);
        }

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
        if (allowKeyPress) {
            switch (e.getKeyCode()) {
                case 37: // Left Arrow
                    if (!direction.equals("right")) {
                        direction = "left";
                    }
                    break;
                case 38: // Up Arrow
                    if (!direction.equals("down")) {
                        direction = "up";
                    }
                    break;
                case 39: // Right Arrow
                    if (!direction.equals("left")) {
                        direction = "right";
                    }
                    break;
                case 40: // Down Arrow
                    if (!direction.equals("up")) {
                        direction = "down";
                    }
                    break;
            }
        }
        allowKeyPress = false;
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}

