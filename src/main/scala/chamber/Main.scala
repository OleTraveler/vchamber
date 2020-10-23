package chamber

object Main extends App {

  val pos = args(0)
  val speed = args(1).toInt

  val chamber = Chamber(pos)
  val result = chamber.animate(speed)

  result.foreach(str => {
    print(str)
    Thread.sleep(1000)
    for (_ <- 0 to pos.length) {
      print('\b')
    }
  })



}
