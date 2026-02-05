import javax.swing.*;
import java.awt.image.BufferStrategy;
import java.awt.*;

public class TicTacToeViewer extends JFrame{
    // TODO: Complete this class
    private Image xImage;
    private Image oImage;
    private TicTacToe game;


    public static final int WINDOW_WIDTH = 500;
    public static final int WINDOW_HEIGHT = 500;

    private TicTacToe window;
    public TicTacToeViewer(TicTacToe window) {
        this.window = window;
        xImage = new ImageIcon("Resources/x.png").getImage();
        oImage = new ImageIcon("Resources/o.png").getImage();


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tic Tac Toe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
        createBufferStrategy(2);

    }

    @Override
    public void paint(Graphics g) {
        for (Square[] square: window.getBoard()) {
            for (Square squares: square) {
                squares.draw(g);
            }
        }
    }
}
