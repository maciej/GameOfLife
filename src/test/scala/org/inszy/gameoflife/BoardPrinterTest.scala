package org.inszy.gameoflife

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FunSuite

/**
 * Created by IntelliJ IDEA.
 * User: Maciej Biłas
 * Date: 1/15/11
 * Time: 21:46
 */

@RunWith(classOf[JUnitRunner])
class BoardPrinterTest extends FunSuite with ShouldMatchers {

  test("a box with one cell in the centre") {
    val b = Board(Cell(0, 0))
    val bp = new BoardPrinter(b)

    bp.print() === "X\n"
  }
}