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
    public TicTacToeViewer(TicTacToe game) {
        this.game = game;
        setTitle("Tic Tac Toe");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);



    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        drawBoard(g);
        drawSquares(g);
        drawWinner(g);
    }

    private void drawBoard(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawString("0", 50, 150);
        g.drawString("1", 50, 240);
        g.drawString("2", 50, 340);

        g.drawString("0", 135, 90);
        g.drawString("1", 235, 90);
        g.drawString("2", 335, 90);

        for (int i = 0; i <= 3; i++) {
            g.drawLine(100, 100 + i * 100, 400, 100 + i * 100);
            g.drawLine(100 + i * 100, 100, 100 + i * 100, 400);
        }
}

    private void drawSquares(Graphics g) {
        for (Square[] row: game.getBoard()) {
            for (Square s: row){
                s.draw(g);
            }
        }
    }

    private void drawWinner(Graphics g) {
        if (game.getGameOver()) {
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.setColor(Color.BLACK);
            if (game.checkTie()) {
                g.drawString("It is a TIE!", 180, 480);

            }
            else{
                g.drawString(game.getWinner() + " Wins!", 180, 480);
            }

        }
    }

}
