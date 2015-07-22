package Tests;

import static org.junit.Assert.*;

import ChessGame.GameViewer;
import org.junit.Before;
import org.junit.Test;

import Controller.Controller;

public class GameOverTest {
	GameViewer view;
	
	@Before
	public void setUp() throws Exception
	{
		Controller c  = new Controller();
		view = new GameViewer(c);
	}

	@Test
	public void test() {
		view.getController().getBoard().player1.king.isEaten = true;
		assertTrue("King not eaten", view.getController().getBoard().player1.king.isEaten);

		view.getController().getBoard().player2.king.isEaten = true;
		assertTrue("King not eaten", view.getController().getBoard().player2.king.isEaten);
	}
}
