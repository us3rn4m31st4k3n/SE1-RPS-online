/***
 * 
 * @author Jean-Luc Busch
 * @brief subclass of Unit and motherclass of all units which can move. It
 *        contains all methods for moving forward,backward,left and right
 * 
 * 
 * 		@Achtung, in dieser Klasse müssen den Methoden zum Bewegen das
 *        Duell(in Form einer Methode) noch eingefügt werden bevor der
 *        endgültige Zug passiert. Zudem sollte vor Rücken geprüft werden ob auf
 *        dem Zielfeld schon eine eigene Figur steht. Dem entsprechend sollte
 *        eine Exception geworfen werden und implementiert werden.@Erledigt
 * 
 * 		@Achtung2, soll hier geprüft werden ob angesprochene Figur dem Spieler
 *        gehört????
 *        
 *      @Achtung3, das board soll static sein!!!!!!
 */
public class MovUnit extends Unit {
	/***
	 * @author Jean-Luc Busch
	 * @brief constructor, calls the constructor of the motherclass, can only called
	 *        by subclasses
	 * @param xCordinate,type
	 *            of integer, symbolize the x-cordinate of the unit where it should
	 *            placed
	 * @param yCordinate,type
	 *            of integer, symbolize the y-cordinate of the unit where it should
	 *            placed
	 * @param owner,
	 *            type of char, shows the owning player of the unit in the next game
	 */
	protected MovUnit(int xCordinate, int yCordinate, char owner) {
		super(xCordinate, yCordinate, owner);
	}

	/***
	 * @author Jean-Luc Busch
	 * @brief method, for moving unit right
	 * @throws BlockedFieldException,
	 *             if aim is taken by an own unit this will be thrown
	 * @throws UnitOutOfBounceException,
	 *             if unit will be place out of the board this exception will be
	 *             thrown
	 */
	public void moveRight() throws BlockedFieldException, UnitOutOfBounceException {
		if (yCordinate == 6/* höhe des Spielfelds, Variable?) z.B. board[0].length */) {// proofs whether the unit is on
																						// the right border of the board
			throw new UnitOutOfBounceException(xCordinate, yCordinate);// if it is, it causes an exception
		} else {

			if (board[xCordinate][yCordinate + 1] != null && board[xCordinate][yCordinate + 1].getOwner == this.owner) {// ACHTUNG:PRÜFEN
																														// OB
																														// AUFRUF
																														// MIT
																														// THIS
																														// IN
				// ABGLEITETEN KLASSEN FÜR PROBLEME
				// SORGT!!!!!!
				// proofs whether the right field is blocked by an own unit
				throw new BlockedFieldException(xCordinate, yCordinate, 6);
			} else {
				if (board[xCordinate][yCordinate + 1] != null) {// proofs whether the field right is taken by an
																// opponent unit
					if (duell(board[xCordinate][yCordinate], board[xCordinate][yCordinate + 1])) {// if it is a duell
																									// betwenn the two
																									// starts

						// Testen ob man
						// ersten
						// Übergabeparameter
						// durch this
						// ersetzen kann!!!!
						// Prüfen ob duell methode auch verschiebt und löscht
						board[xCordinate][yCordinate + 1] = board[xCordinate][yCordinate];// if the unit won the unit go
																							// to his new field and
																							// change the reference on
																							// her own
						// ebenso hier das letze durch
						// this!!!
						// Kommentare gelten für alle folgenden Bewegungsmethoden
						board[xCordinate][yCordinate] = null;// the old field is empty now
						yCordinate++;// the yCordinate plus one
					} else {// if the unit lose the duell, it will be delete and his field becomes empty
						board[xCordinate][yCordinate] = null;
					}
				} else {// if the field is free
					board[xCordinate][yCordinate + 1] = board[xCordinate][yCordinate];// the unit goes to the free field
					board[xCordinate][yCordinate] = null;// and the old becomes empty
					yCordinate++;// the y-cordinate plus ont
				}

			}
		}

	}

	/***
	 * @author Jean-Luc Busch
	 * @brief method for moving unit left
	 * @throws BlockedFieldException,if
	 *             an field is blocked by an own unit, this will be thrown
	 * @throws UnitOutOfBounceException,
	 *             if a unit jumps out of the board, this will be thrown
	 */
	public void moveLeft() throws BlockedFieldException, UnitOutOfBounceException {
		if (yCordinate == 0) {// proofs if the unit is on the left border of the board
			throw new UnitOutOfBounceException(xCordinate, yCordinate);// if it is, it causes an exception
		} else {
			if (board[xCordinate][yCordinate - 1] != null && board[xCordinate][yCordinate - 1].getOwner == this.owner) {// proofs
																														// if
																														// the
																														// field
																														// left
																														// is
																														// blocked
																														// by
																														// an
																														// own
																														// unit
				throw new BlockedFieldException(xCordinate, yCordinate, 4);// if it is, it causes an exception
			} else {
				if (board[xCordinate][yCordinate - 1] != null) {// if the field left, is taken by an opponent unit
					if (duell(board[xCordinate][yCordinate], board[xCordinate][yCordinate - 1])) {// a duell between
																									// that two units
																									// starts
						// siehe Kommentar moveRight
						board[xCordinate][yCordinate - 1] = board[xCordinate][yCordinate];
						board[xCordinate][yCordinate] = null;
						yCordinate--;
					} else {
						board[xCordinate][yCordinate] = null;
					}
				} else {// if the field is free
					board[xCordinate][yCordinate - 1] = board[xCordinate][yCordinate];
					board[xCordinate][yCordinate] = null;
					yCordinate--;
				}
			}

		}
	}

	/***
	 * @author Jean-Luc Busch
	 * @brief method for moving unit forwards
	 * @throws BlockedFieldException
	 * @throws UnitOutOfBounceException
	 */
	public void MoveForward() throws BlockedFieldException, UnitOutOfBounceException {
		if (xCordinate == 7/* breite des Spielfelds, Variable? board.length */) {// proofs if the unit is on the top of
																					// the board
			throw new UnitOutOfBounceException(xCordinate, yCordinate);// if it is, it causes an exception
		} else {
			if (board[xCordinate + 1][yCordinate] != null && board[xCordinate + 1][yCordinate].getOwner == this.owner) {// proofs
																														// the
																														// field
																														// above
																														// is
																														// blocked
																														// by
																														// an
																														// own
																														// unit
				throw new BlockedFieldException(xCordinate, yCordinate, 8);// if it is, it causes an exception
			} else {
				if (board[xCordinate + 1][yCordinate] != null) {// proofs if the field above is taken ba an opponent
																// unit
					if (duell(board[xCordinate][yCordinate], board[xCordinate + 1][yCordinate])) {// siehe Kommentar
																									// moveRight
						board[xCordinate + 1][yCordinate] = board[xCordinate][yCordinate];
						board[xCordinate][yCordinate] = null;
						xCordinate++;
					} else {
						board[xCordinate][yCordinate] = null;
					}
				} else {// if the field is free
					board[xCordinate + 1][yCordinate] = board[xCordinate][yCordinate];
					board[xCordinate][yCordinate] = null;
					xCordinate++;
				}

			}
		}
	}

	/***
	 * @author Jean-Luc Busch
	 * @brief method for moving unit backwards
	 * @throws BlockedFieldException,
	 *             it will be thrown when a field is blocked by an own unit
	 * @throws UnitOutOfBounceException,
	 *             it will be thrown when a unit jumps out of the board
	 */
	public void MoveBackward() throws BlockedFieldException, UnitOutOfBounceException {
		if (xCordinate == 0) {// proofs whether the unit is on the bottom of the board
			throw new UnitOutOfBounceException(xCordinate, yCordinate);// if it is, it causes an exception

		} else {
			if (board[xCordinate - 1][yCordinate] != null && board[xCordinate - 1][yCordinate].getOwner == this.owner) {// proofs
																														// whether
																														// the
																														// field
																														// is
																														// blocked
																														// by
																														// an
																														// own
																														// unit
				throw new BlockedFieldException(xCordinate, yCordinate, 2);// if it is, it causes an exception
			} else {
				if (board[xCordinate - 1][yCordinate] != null) {// proofs whether the field is taken by an opponent unit
					if (duell(board[xCordinate][yCordinate], board[xCordinate - 1][yCordinate])) {// if it is, an duell
																									// between that
																									// units starts

						// siehe Kommentar
						// moveRight
						board[xCordinate - 1][yCordinate] = board[xCordinate][yCordinate];
						board[xCordinate][yCordinate] = null;
						xCordinate--;
					}else {
						board[xCordinate][yCordinate]=null;
					}
				}else {
					board[xCordinate-1][yCordinate]=board[xCordinate][yCordinate];
					board[xCordinate][yCordinate]=null;
					xCordinate--;
				}
				
			}

		}
	}
/***
 * @author Alexander Rogausch,Jean-Luc Busch
 * @brief diese methode soll das Duell ausführen. Zu diskutieren ist was diese Methode leisten soll.
 * Soll sie die Einheiten bewegen oder nur zurückgeben ob der Angreifer gewonnen hat.
 * @param offender,type of unit, symbolizes the unit which wants to move on the taken field
 * @param defender,type ot unit, symbolizes the unit which is offended by an the offender
 * @return?????????
 */
	public boolean duell(Unit offender, Unit defender) {
		// kommt von Alex Rogausch
	}

}
