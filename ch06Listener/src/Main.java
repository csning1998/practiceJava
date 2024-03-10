import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main extends JPanel implements KeyListener, MouseListener {

    public Main(){
        // Code for implementation.
        addKeyListener(this);
        addMouseListener(this);
    }
    @Override
    public void paintComponent(Graphics g){
        // Some request are focus on here for the generated window
        requestFocusInWindow();
    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        // Set the properties of the generated window
        window.setSize(250,250); // Size
        window.setContentPane(new Main()); // Instantiate the constructor from Main.java
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Show the "Close" button at top-right.
        window.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Get the ASCII code for characters.
        System.out.println(e.getKeyChar() + ": " + e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Get the coordinate of mouse click in the panel.
        System.out.println(e.getX() + ", " + e.getY());
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
