/***
 * 
 * @author Jean-Luc Busch
 *@brief subclass of unit and motherclass of all units which can´t move
 */
public class NonMovUnit extends Unit {
/***
 * @author Jean-Luc Busch
 * @brief constructor, calls the constructor of the motherclass,can only called by subclasses
 * @param xCordinate,type of integer, symbolize the x-cordinate of the unit where it should placed
 * @param yCordinate,type of integer, symbolize the y-cordinate of the unit where it should placed
 * @param owner, type of char, shows the owning player of the unit in the next game
 */
	protected NonMovUnit(int xCordinate, int yCordinate, char owner) {
		super(xCordinate, yCordinate, owner);
	}
}
