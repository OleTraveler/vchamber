package chamber


object Chamber {
  /**
   * Create a new Chamber from a string.  Characters ofthe string should be:
   *  'L' for a left bound particle
   *  'R' for a right bound particle
   *  '.' signifying no particle at that space.
   * @return Chamber with initial state.
   */
  def apply(str: String): Chamber = {
    val (leftBound, rightBound) =
      str.zipWithIndex.foldLeft( (Set.empty[Int], Set.empty[Int]))( { case ( (lb, rb), (ch, index)) => {
        ch match {
          case 'L' => (lb + index, rb)
          case 'R' => (lb, rb + index)
          case '.' => (lb, rb)
        }
      }})
    Chamber(str.length, leftBound, rightBound)
  }

  /** Print the state of the chamber, then create a new chamber
   * whose state has changed based on the speed.  Repeat until the chamber is empty.
   **/
  implicit class AnimateChamber(originalChamber: Chamber) {

    def animate(speed: Int): Array[String] = {

      def recurseNextState(chamber: Chamber, result: Array[String]): Array[String] = {
        if (chamber.isEmpty) result.appended(chamber.print)
        else {
          val updatedArray = result.appended(chamber.print)
          recurseNextState(chamber.move(speed), updatedArray)
        }
      }
      recurseNextState(originalChamber, Array.empty[String])
    }
  }
}

/**
 * @param size The size of the chamber.
 * @param leftBound The coordinates of the left bound particles
 * @param rightBound The coordinates of the right bound particles
 */
case class Chamber(size: Int, leftBound: Set[Int], rightBound: Set[Int]) {

  /** Prints the current state of the chamber. */
  def print: String =
    (0 until size).map(i => {
      if (leftBound.contains(i) || rightBound.contains(i)) 'X' else '.'
    }).mkString

  /** Creates a new Chamber if particles are to move the specified speed.  */
  def move(speed: Int): Chamber =
    Chamber(size,
      leftBound.map(_ - speed).filter(_ >= 0),
      rightBound.map(_ + speed).filter(_ < size)
    )

  /** Deteremines if there are any particles in the chamber. */
  def isEmpty = leftBound.isEmpty && rightBound.isEmpty

}