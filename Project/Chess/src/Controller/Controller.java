package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import ChessBoards.TraditionalBoard;
import ChessGame.GameViewer;
import Pieces.*;
import java.util.Vector;

public class Controller {

    static GameViewer viewer;
    public static TraditionalBoard board;

    public Controller()
    {
        board = new TraditionalBoard();
    }

    public static void main(String[] args) throws InterruptedException
    {
        Controller c = new Controller();
        viewer = new GameViewer(c);
    }

    public static MouseListener getMouse() {
        MouseListener mouselistener = new MouseListener(){
            public void mouseClicked(MouseEvent e) {

                int newx = (int) ((board.getWidth() * e.getX()) / viewer.getWidth() ) ;
                int newy = (int) ((board.getHeight() * (e.getY()-40)) / viewer.getHeight() );

                boolean movePiece = e.isShiftDown();
                if(movePiece)
                {
                    board.moveSelectedPiece(newx, newy);
                    movePiece = false;
                }
                else
                {
                    viewer.mouseX=newx;
                    viewer.mouseY=newy;
                    board.mouseX=newx;
                    board.mouseY=newy;
                    Vector<Pair> moves = board.getValidMoves();
                    viewer.addMoves(moves);
                    viewer.repaint();
                }
            }
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
        };
        return mouselistener;
    }

    public Piece getPieces(int player, char name, int index )
    {
        if(player ==1)
            return board.getPieces(board.player1, name, index);
        else
            return board.getPieces(board.player2, name, index);
    }

    public int getW(){ return board.getWidth(); }

    public int getH(){ return board.getHeight(); }

    public int gameOver()
    {
        if(board.player1.king.isEaten)
        {
            return 1;
        }
        else if(board.player2.king.isEaten)
        {
            return 2;
        }
        else
            return -1;
    }

	public static TraditionalBoard getBoard() {
		return board;
	}

	public static void setBoard(TraditionalBoard board) {
		Controller.board = board;
	}
}
