import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Fruit {
    private int x;
    private int y;
    private ImageIcon img;

    public Fruit(){
        // set the picture used for the fruit
        img = new ImageIcon("strawberry.png");
        // set the coordinate of fruit.
        // the domain of the .random is in [0,1]; therefore multiplying the range of the screen is necessary.
        // the object "Main.CELL_SIZE" specifies the area where the fruit appears.
        this.x = (int)(Math.floor(Math.random() * Main.column)) * Main.CELL_SIZE;
        this.y = (int)(Math.floor(Math.random() * Main.row)) * Main.CELL_SIZE;
    }
    // retrieve the coordinate to check if the snake eats the fruit.
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public void drawFruit(Graphics g){
        img.paintIcon(null, g, this.x, this.y);

        // set the colour
//        g.setColor(Color.RED);
////        // shape of the fruit
//        g.fillOval(this.x, this.y, Main.CELL_SIZE, Main.CELL_SIZE);


    }
    public void setNewLocation(Snake s){
        int new_x; int new_y;
        // check the new fruit can't overlap with the snake body.
        boolean overlapping;
        do{
            new_x = (int)(Math.floor(Math.random() * Main.column)) * Main.CELL_SIZE;
            new_y = (int)(Math.floor(Math.random() * Main.row)) * Main.CELL_SIZE;
            overlapping = check_overlap(new_x, new_y, s);
        }while(overlapping);
        this.x = new_x;
        this.y = new_y;
    }

    private boolean check_overlap(int x, int y, Snake s){
        ArrayList<Node> snake_body = s.getSnakeBody();
        // to get the node of the coordinate of the snake body
        for(int j=0; j<s.getSnakeBody().size(); j++)
            // the second 'x' below is the property value
            if(x == snake_body.get(j).x && y == snake_body.get(j).y){
                // if overlapping exist, then return true to the 'setNewLocation()'
                return true;
            }
        return false;
    }
}
