package chess;

import java.util.ArrayList;
import processing.core.PApplet;


public class Chess extends PApplet
{
	public ArrayList<Tile> tiles = new ArrayList<Tile>();
	public King greenKing = new King(this, 500, 100, 0);
	public Queen greenQueen  = new Queen(this, 400, 100, 0);
	public Knight greenKnight1 = new Knight(this, 700, 100, 0);
	public Knight greenKnight2 = new Knight(this, 200, 100, 0);
	public Bishop greenBishop1 = new Bishop(this, 300, 100, 0);
	public Bishop greenBishop2 = new Bishop(this, 600, 100, 0);
	public Rook greenRook1 = new Rook(this, 800, 100, 0);
	public Rook greenRook2 = new Rook(this, 100, 100, 0);
	public Pawn greenPawn1 = new Pawn(this, 100, 200, 0);
	public Pawn greenPawn2 = new Pawn(this, 200, 200, 0);
	public Pawn greenPawn3 = new Pawn(this, 300, 200, 0);
	public Pawn greenPawn4 = new Pawn(this, 400, 200, 0);
	public Pawn greenPawn5 = new Pawn(this, 500, 200, 0);
	public Pawn greenPawn6 = new Pawn(this, 600, 200, 0);
	public Pawn greenPawn7 = new Pawn(this, 700, 200, 0);
	public Pawn greenPawn8 = new Pawn(this, 800, 200, 0);

	public King redKing = new King(this, 400, 800, 1);
	public Queen redQueen  = new Queen(this, 500, 800, 1);
	public Knight redKnight1 = new Knight(this, 700, 800, 1);
	public Knight redKnight2 = new Knight(this, 200, 800, 1);
	public Bishop redBishop1 = new Bishop(this, 300, 800, 1);
	public Bishop redBishop2 = new Bishop(this, 600, 800, 1);
	public Rook redRook1 = new Rook(this, 800, 800, 1);
	public Rook redRook2 = new Rook(this, 500, 500, 1); //tester rook
	public Pawn redPawn1 = new Pawn(this, 100, 700, 1);
	public Pawn redPawn2 = new Pawn(this, 200, 700, 1);
	public Pawn redPawn3 = new Pawn(this, 300, 700, 1);
	public Pawn redPawn4 = new Pawn(this, 400, 700, 1);
	public Pawn redPawn5 = new Pawn(this, 500, 700, 1);
	public Pawn redPawn6 = new Pawn(this, 600, 700, 1);
	public Pawn redPawn7 = new Pawn(this, 700, 700, 1);
	public Pawn redPawn8 = new Pawn(this, 800, 700, 1);



	public static void main(String[] args)
	{
		PApplet.main("chess.Chess");
	}

	public void settings()
	{
		size(1000, 1000);
	}

	public void setup()
	{

		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				tiles.add(new Tile (this, i * 100 + 100, j * 100 + 100));
			}
		}
	}

	public void draw()
	{
		for(int i= 0; i < 64; i++)
		{
			tiles.get(i).drawSelf();
		}

		greenKing.drawSelf();
		greenQueen.drawSelf();
		greenKnight1.drawSelf();
		greenKnight2.drawSelf();
		greenBishop1.drawSelf();
		greenBishop2.drawSelf();
		greenRook1.drawSelf();
		greenRook2.drawSelf();
		greenPawn1.drawSelf();
		greenPawn2.drawSelf();
		greenPawn3.drawSelf();
		greenPawn4.drawSelf();
		greenPawn5.drawSelf();
		greenPawn6.drawSelf();
		greenPawn7.drawSelf();
		greenPawn8.drawSelf();

		redKing.drawSelf();
		redQueen.drawSelf();
		redKnight1.drawSelf();
		redKnight2.drawSelf();
		redBishop1.drawSelf();
		redBishop2.drawSelf();
		redRook1.drawSelf();
		redRook2.drawSelf();
		redPawn1.drawSelf();
		redPawn2.drawSelf();
		redPawn3.drawSelf();
		redPawn4.drawSelf();
		redPawn5.drawSelf();
		redPawn6.drawSelf();
		redPawn7.drawSelf();
		redPawn8.drawSelf();

		updateBoardAndTileOccupations();
		displayRedRook2Moves();
	}

	public int convertCoordinatestoTileArrayPos(int xcoordinate, int ycoordinate)
	{
		return ((ycoordinate + (8 * xcoordinate)) / 100) - 9;
	}

	public void updateBoardAndTileOccupations()
	{
		tiles.get(convertCoordinatestoTileArrayPos(greenKing.getX(), greenKing.getY())).setUnavailable();
		tiles.get(convertCoordinatestoTileArrayPos(greenQueen.getX(), greenQueen.getY())).setUnavailable();
		tiles.get(convertCoordinatestoTileArrayPos(greenKnight1.getX(), greenKnight1.getY())).setUnavailable();
		tiles.get(convertCoordinatestoTileArrayPos(greenKnight2.getX(), greenKnight2.getY())).setUnavailable();
		tiles.get(convertCoordinatestoTileArrayPos(greenBishop1.getX(), greenBishop1.getY())).setUnavailable();
		tiles.get(convertCoordinatestoTileArrayPos(greenBishop2.getX(), greenBishop2.getY())).setUnavailable();
		tiles.get(convertCoordinatestoTileArrayPos(greenRook1.getX(), greenRook1.getY())).setUnavailable();
		tiles.get(convertCoordinatestoTileArrayPos(greenRook2.getX(), greenRook2.getY())).setUnavailable();
		tiles.get(convertCoordinatestoTileArrayPos(greenPawn1.getX(), greenPawn1.getY())).setUnavailable();
		tiles.get(convertCoordinatestoTileArrayPos(greenPawn2.getX(), greenPawn2.getY())).setUnavailable();
		tiles.get(convertCoordinatestoTileArrayPos(greenPawn3.getX(), greenPawn3.getY())).setUnavailable();
		tiles.get(convertCoordinatestoTileArrayPos(greenPawn4.getX(), greenPawn4.getY())).setUnavailable();
		tiles.get(convertCoordinatestoTileArrayPos(greenPawn5.getX(), greenPawn5.getY())).setUnavailable();
		tiles.get(convertCoordinatestoTileArrayPos(greenPawn6.getX(), greenPawn6.getY())).setUnavailable();
		tiles.get(convertCoordinatestoTileArrayPos(greenPawn7.getX(), greenPawn7.getY())).setUnavailable();
		tiles.get(convertCoordinatestoTileArrayPos(greenPawn8.getX(), greenPawn8.getY())).setUnavailable();

		tiles.get(convertCoordinatestoTileArrayPos(redKing.getX(), redKing.getY())).setUnavailable();
		tiles.get(convertCoordinatestoTileArrayPos(redQueen.getX(), redQueen.getY())).setUnavailable();
		tiles.get(convertCoordinatestoTileArrayPos(redKnight1.getX(), redKnight1.getY())).setUnavailable();
		tiles.get(convertCoordinatestoTileArrayPos(redKnight2.getX(), redKnight2.getY())).setUnavailable();
		tiles.get(convertCoordinatestoTileArrayPos(redBishop1.getX(), redBishop1.getY())).setUnavailable();
		tiles.get(convertCoordinatestoTileArrayPos(redBishop2.getX(), redBishop2.getY())).setUnavailable();
		tiles.get(convertCoordinatestoTileArrayPos(redRook1.getX(), redRook1.getY())).setUnavailable();
		tiles.get(convertCoordinatestoTileArrayPos(redRook2.getX(), redRook2.getY())).setUnavailable();
		tiles.get(convertCoordinatestoTileArrayPos(redPawn1.getX(), redPawn1.getY())).setUnavailable();
		tiles.get(convertCoordinatestoTileArrayPos(redPawn2.getX(), redPawn2.getY())).setUnavailable();
		tiles.get(convertCoordinatestoTileArrayPos(redPawn3.getX(), redPawn3.getY())).setUnavailable();
		tiles.get(convertCoordinatestoTileArrayPos(redPawn4.getX(), redPawn4.getY())).setUnavailable();
		tiles.get(convertCoordinatestoTileArrayPos(redPawn5.getX(), redPawn5.getY())).setUnavailable();
		tiles.get(convertCoordinatestoTileArrayPos(redPawn6.getX(), redPawn6.getY())).setUnavailable();
		tiles.get(convertCoordinatestoTileArrayPos(redPawn7.getX(), redPawn7.getY())).setUnavailable();
		tiles.get(convertCoordinatestoTileArrayPos(redPawn8.getX(), redPawn8.getY())).setUnavailable();
	}
	
	public void displayRedRook2Moves()
	{
		for(int j = 0; j < redRook2.returnPossibleTiles().size(); j++) //cycles through list of potential "open" tiles
		{
			if(tiles.get(redRook2.returnPossibleTiles().get(j)).available()==false) //if that potentially open tile is unavailable
			{
				if(tiles.get(redRook2.returnPossibleTiles().get(j)).getX() == redRook2.getX() && tiles.get(redRook2.returnPossibleTiles().get(j)).getY() > redRook2.getY()) //if that occupied tile is below the rook
				{

					for(int k = 0; k < tiles.size(); k++)
					{
						if(tiles.get(k).getY() > tiles.get(redRook2.returnPossibleTiles().get(j)).getY() && tiles.get(k).getX()==redRook2.getX())
						{
							tiles.get(k).setUnavailable();
						}
					}
				}
			}
		}

		for(int j = 0; j < redRook2.returnPossibleTiles().size(); j++) //cycles through list of potential "open" tiles
		{
			if(tiles.get(redRook2.returnPossibleTiles().get(j)).available()==false) //if that potentially open tile is unavailable
			{
				if(tiles.get(redRook2.returnPossibleTiles().get(j)).getX() == redRook2.getX() && tiles.get(redRook2.returnPossibleTiles().get(j)).getY() < redRook2.getY()) //if that occupied tile is above the rook
				{
					for(int k = 0; k < tiles.size(); k++)
					{
						if(tiles.get(k).getY() < tiles.get(redRook2.returnPossibleTiles().get(j)).getY() && tiles.get(k).getX()==redRook2.getX())
						{
							tiles.get(k).setUnavailable();
						}
					}
				}
			}
		}

		for(int j = 0; j < redRook2.returnPossibleTiles().size(); j++) //cycles through list of potential "open" tiles
		{
			if(tiles.get(redRook2.returnPossibleTiles().get(j)).available()==false) //if that potentially open tile is unavailable
			{
				if(tiles.get(redRook2.returnPossibleTiles().get(j)).getY() == redRook2.getY() && tiles.get(redRook2.returnPossibleTiles().get(j)).getX() < redRook2.getX()) //if that occupied tile is to the left of the rook
				{
					for(int k = 0; k < tiles.size(); k++)
					{
						if(tiles.get(k).getX() < tiles.get(redRook2.returnPossibleTiles().get(j)).getX() && tiles.get(k).getY()==redRook2.getY())
						{
							tiles.get(k).setUnavailable();
						}
					}
				}
			}
		}

		for(int j = 0; j < redRook2.returnPossibleTiles().size(); j++) //cycles through list of potential "open" tiles
		{
			if(tiles.get(redRook2.returnPossibleTiles().get(j)).available()==false) //if that potentially open tile is unavailable
			{
				if(tiles.get(redRook2.returnPossibleTiles().get(j)).getY() == redRook2.getY() && tiles.get(redRook2.returnPossibleTiles().get(j)).getX() > redRook2.getX()) //if that occupied tile is to the right of the rook
				{
					for(int k = 0; k < tiles.size(); k++)
					{
						if(tiles.get(k).getX() > tiles.get(redRook2.returnPossibleTiles().get(j)).getX() && tiles.get(k).getY()==redRook2.getY())
						{
							tiles.get(k).setUnavailable();
						}
					}
				}
			}
		}

		for(int i = 0; i < redRook2.returnPossibleTiles().size(); i++)
		{
			if(tiles.get(redRook2.returnPossibleTiles().get(i)).available() == true)
			{
				tiles.get(redRook2.returnPossibleTiles().get(i)).drawLight();
			}
		}
	}

}



