package chamber

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

class ChamberTest extends AnyFunSuite with Matchers {

  test("test case 0") {
    val expectedResult = Array("..X....", "....X..", "......X", ".......")
    Chamber("..R....").animate(2) mustEqual expectedResult
  }

  test("test case 1") {
    val expectedResult = Array("XX..XXX", ".X.XX..", "X.....X", ".......")
    Chamber("RR..LRL").animate(3) mustEqual expectedResult
  }
  test("test case 2") {
    val expectedResult =
      Array(
        "XXXX.XXXX",
        "X..X.X..X",
        ".X.X.X.X.",
        ".X.....X.",
        "........."
      )
    Chamber("LRLR.LRLR").animate(2) mustEqual expectedResult
  }

  test("test case 3") {
    val expectedResult = Array("XXXXXXXXXX", "..........")
    Chamber("RLRLRLRLRL").animate(10) mustEqual expectedResult
  }

  test("test case 4") {
    val expectedResult = Array("...")
    Chamber("...").animate(1) mustEqual expectedResult
  }

  test("test case 5") {
    val expectedResult =
      Array(
        "XXXX.XX.XXX.X.XXXX.",
        "..XXX..X..XX.X..XX.",
        ".X.XX.X.X..XX.XX.XX",
        "X.X.XX...X.XXXXX..X",
        ".X..XXX...X..XX.X..",
        "X..X..XX.X.XX.XX.X.",
        "..X....XX..XX..XX.X",
        ".X.....XXXX..X..XX.",
        "X.....X..XX...X..XX",
        ".....X..X.XX...X..X",
        "....X..X...XX...X..",
        "...X..X.....XX...X.",
        "..X..X.......XX...X",
        ".X..X.........XX...",
        "X..X...........XX..",
        "..X.............XX.",
        ".X...............XX",
        "X.................X",
        "..................."
      )

    Chamber("LRRL.LR.LRR.R.LRRL.").animate(1) mustEqual expectedResult
  }

}
