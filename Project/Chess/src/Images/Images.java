package Images;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Images {

	public BufferedImage whitePawnImage;
	public BufferedImage whiteCastleImage;
	public BufferedImage whiteHorseImage;
	public BufferedImage whiteBishopImage;
	public BufferedImage whiteQueenImage;
	public BufferedImage whiteKingImage;
	public BufferedImage whiteWazirImage;
	public BufferedImage whiteBerolinaImage;
	public BufferedImage blackPawnImage;
	public BufferedImage blackCastleImage;
	public BufferedImage blackHorseImage;
	public BufferedImage blackBishopImage;
	public BufferedImage blackQueenImage;
	public BufferedImage blackKingImage;
	public BufferedImage blackWazirImage;
	public BufferedImage blackBerolinaImage;
	
	final private String PATH_IMG="ChessPieces/"; 
	/**
	 * Initialize all the images
	 */
	public Images() {
		
		//white pawn
		try {
			whitePawnImage = ImageIO.read(new File(PATH_IMG+"White_pawn.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//white castle
		try {
			whiteCastleImage = ImageIO.read(new File(PATH_IMG+"White_castle.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//white horse
		try {
			whiteHorseImage = ImageIO.read(new File(PATH_IMG+"White_horse.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//white bishop
		try {
			whiteBishopImage = ImageIO.read(new File(PATH_IMG+"White_bishop.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//white queen
		try {
			whiteQueenImage = ImageIO.read(new File(PATH_IMG+"White_queen.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//white king
		try {
			whiteKingImage = ImageIO.read(new File(PATH_IMG+"White_king.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		
		//black pawn
		try {
			blackPawnImage = ImageIO.read(new File(PATH_IMG+"Black_pawn.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//black castle
		try {
			blackCastleImage = ImageIO.read(new File(PATH_IMG+"Black_castle.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//black horse
		try {
			blackHorseImage = ImageIO.read(new File(PATH_IMG+"Black_horse.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//black bishop
		try {
			blackBishopImage = ImageIO.read(new File(PATH_IMG+"Black_bishop.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//black queen
		try {
			blackQueenImage = ImageIO.read(new File(PATH_IMG+"Black_queen.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//black king
		try {
			blackKingImage = ImageIO.read(new File(PATH_IMG+"Black_king.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
				
	}

}
