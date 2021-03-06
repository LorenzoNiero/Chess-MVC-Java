package Tests;

import static org.junit.Assert.*;
import ChessGame.GameViewer;

import org.junit.Before;
import org.junit.Test;

import Controller.Controller;

public class PieceMovements {
    GameViewer newBoard;

	@Before
	public void setUp() throws Exception
	{
		Controller c = new Controller();
		newBoard = new GameViewer(c);
	}


	@Test
	public void testPawn() {
		newBoard.mouseX = 3;
		newBoard.mouseY = 6;
		newBoard.getController().getBoard().moveSelectedPiece(3, 4);
		assertFalse("Piece didn't move to correct place!",
				(newBoard.getController().getBoard().player1.pawns[1].positions.getY() == 4 && newBoard.getController().getBoard().player1.pawns[1].positions.getX() == 3 ));

		newBoard.mouseX = 4;
		newBoard.mouseY = 6;
		newBoard.getController().getBoard().moveSelectedPiece(3, 4);
		assertFalse("Piece did move to incorrect place!", newBoard.getController().getBoard().player1.pawns[0].positions.getY() == 4 && newBoard.getController().getBoard().player1.pawns[0].positions.getX() == 3 );
	}

	@Test
	public void testCastle() {
		newBoard.mouseX = 0;
		newBoard.mouseY = 0;
		newBoard.getController().getBoard().moveSelectedPiece(5, 5);
		assertFalse("Piece didn't move to correct place!",
				(newBoard.getController().getBoard().player1.castles[0].positions.getY() == 5 && newBoard.getController().getBoard().player1.castles[0].positions.getX() == 5 ));

	}

	@Test
	public void testHorse() {
		newBoard.mouseX = 3;
		newBoard.mouseY = 1;
		newBoard.getController().getBoard().moveSelectedPiece(5, 5);
		assertFalse("Piece didn't move to correct place!",
				(newBoard.getController().getBoard().player1.pawns[0].positions.getY() == 5 && newBoard.getController().getBoard().player1.pawns[0].positions.getX() == 5 ));

	}

	@Test
	public void testBishop() {
		newBoard.mouseX = 0;
		newBoard.mouseY = 0;
		newBoard.getController().getBoard().moveSelectedPiece(5, 5);
		assertFalse("Piece didn't move to correct place!",
				(newBoard.getController().getBoard().player1.pawns[0].positions.getY() == 5 && newBoard.getController().getBoard().player1.pawns[0].positions.getX() == 5 ));

	}

	@Test
	public void testQueen() {
		newBoard.mouseX = 4;
		newBoard.mouseY = 9;
		newBoard.getController().getBoard().moveSelectedPiece(5, 5);
		assertFalse("Piece didn't move to correct place!",
				(newBoard.getController().getBoard().player1.pawns[0].positions.getY() == 5 && newBoard.getController().getBoard().player1.pawns[0].positions.getX() == 5 ));

	}

	@Test
	public void testKing() {
		newBoard.mouseX = 3;
		newBoard.mouseY = 7;
		newBoard.getController().getBoard().moveSelectedPiece(5, 5);
		assertFalse("Piece didn't move to correct place!",
				(newBoard.getController().getBoard().player1.pawns[0].positions.getY() == 5 && newBoard.getController().getBoard().player1.pawns[0].positions.getX() == 5 ));

	}

}
