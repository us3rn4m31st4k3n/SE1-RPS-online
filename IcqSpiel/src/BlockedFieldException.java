/***
 * 
 * @author Jean-Luc Busch
 * @brief subclass of Exception, symboizes the problem a unit moves on a field
 *        which is blocked by an unit of the same owner
 * @var xCordinate,type of integer, x-cordinate of the wrong moving unit
 *      yCordinate,type of integer,y-cordinate of the wrong moving unit
 *      blockedXCordinate,type of integer, x-cordinate of the blocked field
 *      blockedYCordinate,type of integer, y-cordinate of the blocked field
 */
public class BlockedFieldException extends Exception {
	int xCordinate;// x-cordinate of the wrong moving unit
	int yCordinate;// y-cordinate of the wrong moving unit
	int blockedXCordinate;// x-cordinate of the blocked field
	int blockedYCordinate;// y-cordinate of the blocked field

	/***
	 * @author Jean-Luc Busch
	 * @brief constructor
	 * @param xCordinate,type
	 *            of integer, x-cordinate of the wrong moving unit
	 * @param yCordinate,type
	 *            of integer,y-cordinate of the wrong moving unit
	 * @param moveIndx,type
	 *            of integer, symbolizes the type of move that causes the
	 *            exception.8=foreward,2=backward,4=left,6=right
	 */
	public BlockedFieldException(int xCordinate, int yCordinate, int moveIndx) {
		this.xCordinate = xCordinate;
		this.yCordinate = yCordinate;
		switch (moveIndx) {// calculates the cordinates of the blocked field proofing the direction of the
							// move
		// Achtung!!!:
		// ist vielleicht intelligenter zu lösen wenn man statt dem moveIndx direkt die
		// Zielkoordinaten übergibt und in den einzelnen Move Methoden schon
		// entsprechend berechnet

		case 6://unit moves right
			blockedXCordinate = this.xCordinate;
			blockedYCordinate = yCordinate + 1;
			break;
		case 4://unit moves left
			blockedXCordinate = this.xCordinate;
			blockedYCordinate = yCordinate - 1;
			break;
		case 8://unit moved forward
			blockedXCordinate = xCordinate + 1;
			blockedYCordinate = this.yCordinate;
			break;
		case 2://unit moved backward
			blockedXCordinate = xCordinate - 1;
			blockedYCordinate = this.yCordinate;
			break;
		default:
			System.out.println("If you can red that, a big mistake happended");
		}

	}

	@Override
	public String toString() {
		return "Field " + blockedXCordinate + "/" + blockedYCordinate + " is blocked!/n Unit at field " + xCordinate
				+ "/" + yCordinate + "can´t go there";
	}
}
