/***
 * 
 * @author Jean-Luc Busch
 *@brief subclass of MobUnit, symbolizes the paper
 */
public class Paper extends MovUnit {
	/***
	 * @brief constructor, calls the constructor of the motherclass
	 *        MovUnit,additional the weapon will be initialized as a paper
	 * @param xCordinate,type
	 *            of integer, symbolize the x-cordinate of the unit where it should
	 *            placed
	 * @param yCordinate,type
	 *            of integer, symbolize the y-cordinate of the unit where it should
	 *            placed
	 * @param owner,
	 *            type of char, shows the owning player of the unit in the next game
	 */
	public Paper(int xCordinate, int yCordinate, char owner) {
		super(xCordinate, yCordinate, owner);
		weapon = Art.paper;//the weapon of this of unit is paper
	}
}
