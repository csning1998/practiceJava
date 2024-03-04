import java.awt.*;

public class Fruit {
    private int x;
    private int y;

    public Fruit(){
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
        // set the colour
        g.setColor(Color.RED);
        // shape of the fruit
        g.fillOval(this.x, this.y, Main.CELL_SIZE, Main.CELL_SIZE);
    }
}
