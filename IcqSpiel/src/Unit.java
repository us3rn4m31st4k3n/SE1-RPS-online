/***
 * 
 * @author Jean-Luc Busch
 * @brief This class is the motherclass of all kind of units. Can only called by subclasses
 * @ xCordinate, type of integer, symbolize the x-cordinate of the unit
 * yCordinate, type of integer, symbolize the y-cordinate of the unit
 * owner, type of char, shows the owning player of the unit
 * weapon, type of Art, is the weapon of the unit
 * visible,type of boolean, shows if the weapon can see by the opponent
 */
public class Unit {
 
	protected int xCordinate;
	protected int yCordinate;
	protected char owner;
	protected Art weapon;// Enumeration of all weapons
	protected boolean visible=false;
	
/***
 * @author Jean-Luc Busch	
 * @param xCordinate,type of integer, symbolize the x-cordinate of the unit where it should placed
 * @param yCordinate, type of integer, symbolize the y-cordinate of the unit where it should placed
 * @param owner, type of char, shows the owning player of the unit in the next game
 */
	protected Unit(int xCordinate, int yCordinate, char owner) {
		this.xCordinate = xCordinate;
		this.yCordinate = yCordinate;
		this.owner = owner;
		// beim Aufruf des Konstruktors könnten per Übergabeparameter aus
		// Spielbrettklasse oder Spielerklasse die Startkoordinaten
		// Figur bestimmt werden. Auch zuordnung waffen.
	}
/***
 * @author Jean-Luc Busch
 * @brief getter method of xCordinate
 * @return xCordinate, the latest x-cordinate of the unit
 */
	public int getXCordinate() {
		return xCordinate;
	}
/***
 * @author Jean-Luc Busch
 * @brief getter method of yCordinate
 * @return yCordinate , the latest y-cordinate of the unit
 */
	public int getYCordinate() {
		return yCordinate;
	}
/***
 * @author Jean-Luc Busch
 * @brief getter method of owner
 * @return owner, the actual symbol of the owner
 */
	public char getOwner() {
		return owner;
	}
/***
 * @author Jean-Luc Busch
 * @description setter method of weapon
 * @param newWeapon, type of Art, is the new weapon of the unit
 */
	public void setWeapon(Art newWeapon) {
		this.weapon = newWeapon;
	}
/***
 * @author Jean-Luc Busch
 * @description getter method of weapon
 * @return weapon, the actual weapon of the unit
 */
	public Art getWeapon() {
		return weapon;
	}

}
