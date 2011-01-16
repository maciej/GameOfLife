package org.inszy.gameoflife

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FunSuite
import io.Source

/**
 * Created by IntelliJ IDEA.
 * User: Maciej Biłas
 * Date: 1/16/11
 * Time: 2:01
 */

@RunWith(classOf[JUnitRunner])
class BoardReaderTest extends FunSuite with ShouldMatchers {

  test("it should load one dead cell board") {
    val b = new BoardReader(Source.fromString(".\n")).toBoard

    b.isCellAlive(Cell(0, 0)) === false
  }

  test("it should load one live cell board") {
    val b = new BoardReader(Source.fromString("X\n")).toBoard

    b.isCellAlive(Cell(0, 0)) === true
  }

  test("it should load square 4 element board") {
    val b = new BoardReader(Source.fromString("X.\n.X")).toBoard

    List((Cell(0, 0), true),
      (Cell(1, 0), false),
      (Cell(0, 1), false),
      (Cell(1, 1), true)
    ).foreach{
      case (c, state) => b.isCellAlive(c) === state
    }
  }
}