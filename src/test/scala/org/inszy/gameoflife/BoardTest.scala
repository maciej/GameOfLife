package org.inszy.gameoflife

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

/**
 * Created by IntelliJ IDEA.
 * User: Maciej Biłas
 * Date: 1/15/11
 * Time: 19:20
 */

@RunWith(classOf[JUnitRunner])
class BoardTest extends FunSuite with ShouldMatchers {

  test("should init cell 0,0") {
    val b = Board(Cell(0, 0))
    b.isCellAlive(Cell(0, 0)) should be(true)
  }

  test("should kill single lonely cell") {
    val b = Board(Cell(0, 0))
    val nextBoard = b.next
    nextBoard.isCellAlive(Cell(0, 0)) should be(false)
  }

  test("should spawn cells with three neighbours") {
    val b = Board(Cell(-1, 0), Cell(0, 0), Cell(1, 0))
    val nextBoard = b.next

    nextBoard.isCellAlive(Cell(0, 0)) === true
    nextBoard.isCellAlive(Cell(0, -1)) === true
    nextBoard.isCellAlive(Cell(0, 1)) === true

    // now check the ones that should be dead
    nextBoard.isCellAlive(Cell(-1, 0)) === false
    nextBoard.isCellAlive(Cell(1, 0)) === false
  }
}

@RunWith(classOf[JUnitRunner])
class CellTest extends FunSuite with ShouldMatchers {

  test("should list its neighbours") {
    val c = Cell(0, 0)
    val neighbours = c.neighbours

    /* A cell always has 8 neighbours */
    neighbours.length == 8
    val expectedNeighbours = List(
      Cell(-1, -1),
      Cell(-1, 0),
      Cell(-1, 1),
      Cell(0, -1),
      Cell(0, 1),
      Cell(1, -1),
      Cell(1, 0),
      Cell(1, 1)
    )
    expectedNeighbours.forall(neighbours.contains(_)) === true
  }
}