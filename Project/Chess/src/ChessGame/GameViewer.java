package ChessGame;

import java.awt.*;
import javax.swing.*;
import Controller.Controller;
import Images.Images;
import Pieces.Pair;
import Pieces.Piece;
import java.awt.Container;
import java.util.Vector;

public class GameViewer extends JPanel {

    public int mouseX, mouseY;
    private Images pieces;
    private int xDimensions, yDimensions;
    private Controller controller;
    private static JFrame frame;
    private static JFrame scoreBoard;
    private String p1Name = "White Player";
    private String p2Name = "Black Player";
    private int p1Score;
    private int p2Score;
    private Vector<Pair>moves;

    public GameViewer(Controller c)
    {
        initializeBoard();
        controller = c;
        p1Score = 0;
        p2Score = 0;

        setupFrame();
    }
    
    private void setupScoreBoard()
    {
        scoreBoard = new JFrame("Score Board");
        scoreBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel p1 = new JLabel("Player 1: "+p1Name);
        JLabel p2 = new JLabel("Player 2: "+p2Name);
        JLabel p1s = new JLabel(""+p1Score);
        JLabel p2s = new JLabel(""+p2Score);

        Container content = scoreBoard.getContentPane();
        SpringLayout layout = new SpringLayout();
        content.setLayout(layout);

        content.add(p1);
        content.add(p2);
        content.add(p1s);
        content.add(p2s);

        SpringLayout.Constraints labelCons = layout.getConstraints(p1);
        labelCons.setX(Spring.constant(5));
        labelCons.setY(Spring.constant(25));


        SpringLayout.Constraints labelCon = layout.getConstraints(p2);
        labelCon.setX(Spring.constant(5));
        labelCon.setY(Spring.constant(75));


        SpringLayout.Constraints scoreCons = layout.getConstraints(p1s);
        scoreCons.setX(Spring.constant(50));
        scoreCons.setY(Spring.constant(50));

        SpringLayout.Constraints scoreCon = layout.getConstraints(p2s);
        scoreCon.setX(Spring.constant(50));
        scoreCon.setY(Spring.constant(100));

        scoreBoard.setSize(250, 250);
        scoreBoard.setLocation(560, 0);
        scoreBoard.setVisible(true);
    }

    public void updateScore(int turn)
    {
        if(turn%2== 0)
            p2Score++;
        else
            p1Score++;
        setupScoreBoard();
    }

    public void initializeBoard()
    {
        pieces = new Images();
    }

    private void setupFrame()
    {
        frame = new JFrame("Chess");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setSize(550,550);
        frame.addMouseListener(controller.getMouse());
        frame.setVisible(true);
    }

    public void paint(Graphics g)
    {
        boardBackground(g);
        highlightMoves(g);
        displayPieces(g);
        GameOver(g);
        repaint();
    }

    private void boardBackground(Graphics g)
    {
        xDimensions=( getWidth() / controller.getW());
        yDimensions=( getHeight()/ controller.getH());

        int count = 0;
        for(int i=0; i< controller.getW();i++)
        {
            for (int j=0; j<controller.getH(); j++)
            {
                if(count%2==0)
                {
                    g.setColor(new Color(51,51,51));
                    g.fillRect(i * xDimensions, j * yDimensions, xDimensions, yDimensions);
                }
                else
                {
                    g.setColor(new Color(255,255,255));
                    g.fillRect(i * xDimensions, j * yDimensions, xDimensions, yDimensions);
                }
                count++;
            }
            count++;
        }

        g.setColor(Color.green);
        g.drawRect(mouseX * xDimensions, mouseY * yDimensions, xDimensions, yDimensions);
    }

    private void displayPieces(Graphics g)
    {
        getPieces(g, 1, 'P', 8);
        getPieces(g, 1, 'C', 2);
        getPieces(g, 1, 'B', 2);
        getPieces(g, 1, 'H', 2);
        getPieces(g, 1, 'K', 1);
        getPieces(g, 1, 'Q', 1);
        
        getPieces(g, 2, 'P', 8);
        getPieces(g, 2, 'C', 2);
        getPieces(g, 2, 'B', 2);
        getPieces(g, 2, 'H', 2);
        getPieces(g, 2, 'K', 1);
        getPieces(g, 2, 'Q', 1);
    }

    private void getPieces(Graphics g, int player, char name, int numElements)
    {

        Image img;
        switch (name) {
            case 'P':
                if(player == 1)
                	img = pieces.whitePawnImage;
                else
                	img = pieces.blackPawnImage;
                break;
            case 'C':
                if(player ==1)
                    img = pieces.whiteCastleImage;
                else
                    img = pieces.blackCastleImage;
                break;
            case 'H':
                if(player == 1)
                    img = pieces.whiteHorseImage;
                else
                    img = pieces.blackHorseImage;
                break;
            case 'B':
                if(player == 1)
                    img = pieces.whiteBishopImage;
                else
                    img = pieces.blackBishopImage;
                break;
            case 'Q':
                if(player == 1)
                    img = pieces.whiteQueenImage;
                else
                    img = pieces.blackQueenImage;
                break;
            case 'K':
                if(player == 1)
                    img = pieces.whiteKingImage;
                else
                    img = pieces.blackKingImage;
                break;
            case 'W':
                if(player == 1)
                    img = pieces.whiteWazirImage;
                else
                    img = pieces.blackWazirImage;
                break;
            case 'A':
                if(player == 1)
                    img = pieces.whiteBerolinaImage;
                else
                    img = pieces.blackBerolinaImage;
                break;
            default :
                img = pieces.whitePawnImage;
                System.out.println("Invalid Image Selection");
                break;
        }
        
        for(int index = 0; index < numElements; index++)
        {
            Piece p = controller.getPieces(player, name, index);

            if(p != null && !p.isEaten )
                g.drawImage(img, xDimensions*p.positions.getX()+7, yDimensions*p.positions.getY(), null);
        }

    }

    public void addMoves(Vector<Pair> moves)
    {
        this.moves = moves;
    }

    public void highlightMoves(Graphics g)
    {
        if(moves != null)
        {
            for(int i = 0; i < moves.size(); i++)
            {
                Pair p = moves.elementAt(i);
                g.setColor(Color.green);
                g.fillRect(p.getX() * xDimensions, p.getY() * yDimensions, xDimensions, yDimensions);
            }
        }
    }

    public void GameOver(Graphics g)
    {
        int over = controller.gameOver();

        if(over == 1)
        {
            g.setColor(Color.GREEN);
            Font p3= new Font("Algerian",Font.PLAIN,50);
            g.setFont(p3);
            g.drawString("Player Black Wins!", getWidth() / 3 - 100, getHeight() / 3);
        }
        else if(over == 2)
        {
            g.setColor(Color.GREEN);
            Font p3= new Font("Algerian",Font.PLAIN,50);
            g.setFont(p3);
            g.drawString("Player White Wins!", getWidth() / 3 - 100, getHeight() / 3);
        }
    }

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

}

