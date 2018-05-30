/***
 * 
 * @author Jean-Luc Busch
 * @brief this class is a subclass of MovUnit and symbolizes the scissor
 */
public class Scissor extends MovUnit {
	/***
	 * @brief constructor, calls the constructor of the motherclass
	 *        MovUnit,additional the weapon will be initialized as a scissor
	 * @param xCordinate,type
	 *            of integer, symbolize the x-cordinate of the unit where it should
	 *            placed
	 * @param yCordinate,type
	 *            of integer, symbolize the y-cordinate of the unit where it should
	 *            placed
	 * @param owner,
	 *            type of char, shows the owning player of the unit in the next game
	 */
	public Scissor(int xCordinate, int yCordinate, char owner) {
		super(xCordinate, yCordinate, owner);
		weapon = Art.scissor;//the weapon of the unit becomes a scissor
	}
}
