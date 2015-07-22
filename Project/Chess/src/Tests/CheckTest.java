package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ChessGame.GameViewer;
import Controller.Controller;

public class CheckTest {
	GameViewer viewer;
	
	@Before
	public void setUp() {
		Controller c = new Controller();
	    viewer = new GameViewer(c);
	}
	
	@Test
	public void test()
	{
		viewer.getController().getBoard().player1.queen.isEaten = true;
		assertTrue("Queen was not eaten", viewer.getController().getBoard().player1.queen.isEaten);
		
		viewer.getController().getBoard().player2.horses[0].positions.setCoords(4, 5);
		assertTrue("Horse can eat king if king is moved to 3, 7",viewer.getController().getBoard().player2.horses[0].positions.getX()==4 );

		viewer.mouseX = 4;
		viewer.mouseY = 7;
		viewer.getController().getBoard().moveSelectedPiece(3, 7);
		assertFalse("King cannot move there, or else will be eaten!",
				(viewer.getController().getBoard().player1.pawns[1].positions.getY() == 7 && viewer.getController().getBoard().player1.pawns[1].positions.getX() == 3 ));
	}

}
