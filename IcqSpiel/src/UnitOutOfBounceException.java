/***
 * 
 * @author Jean-Luc Busch
 * @brief subclass of Exception, this class symbolizes the problem if an unit
 *        jumps out of the board
 * @var xCordinate,type of integer, x-Cordinate of the wrong moving unit
 *      yCordinate,type of integer, y-Cordinate of the wrong moving unit
 */
public class UnitOutOfBounceException extends Exception {

	private int xCordinate;// x-cordinate of the worng moving unit
	private int yCordinate;// y-cordinate of the wrong moving unit

	/***
	 * @author Jean-Luc Busch
	 * @brief construcor
	 * @param xCordinate,
	 *            x-Cordinate of the wrong moving unit
	 * @param yCordinate,
	 *            y-Cordinate of the wrong moving unit
	 */
	UnitOutOfBounceException(int xCordinate, int yCordinate) {

		this.xCordinate = xCordinate;
		this.yCordinate = yCordinate;

	}

	@Override
	/***
	 * @author Jean-Luc Busch
	 * @brief returns the place of the wrong moving unit
	 * @return String
	 */
	public String toString() {
		return "figure at field (" + xCordinate + "," + yCordinate + ") can´t go there";
	}
}
