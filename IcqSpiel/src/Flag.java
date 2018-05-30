/***
 * 
 * @author Jean-Luc Busch
 * @brief subclass of NonMovUnit, it symbolizes the flag in this game
 */
public class Flag extends NonMovUnit {
	/***
	 * @brief constructor, calls the constructor of the motherclass
	 *        MovUnit,additional the weapon will be initialized as a flag
	 * @param xCordinate,type
	 *            of integer, symbolize the x-cordinate of the unit where it should
	 *            placed
	 * @param yCordinate,type
	 *            of integer, symbolize the y-cordinate of the unit where it should
	 *            placed
	 * @param owner,
	 *            type of char, shows the owning player of the unit in the next game
	 */
	public Flag(int xCordinate, int yCordinate, char owner) {
		super(xCordinate, yCordinate, owner);
		weapon = Art.flag;//the weapon of the unit is a flag

	}
}
