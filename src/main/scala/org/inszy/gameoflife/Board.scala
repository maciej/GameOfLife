package org.inszy.gameoflife

/**
 * Created by IntelliJ IDEA.
 * User: Maciej Biłas
 * Date: 1/15/11
 * Time: 19:13
 */

object Board {
  def apply(cells: Cell*) = new Board(cells.toSet)
}

class Board private[Board](private[gameoflife] val cells: Set[Cell]) {

  def isCellAlive(c: Cell) = cells.contains(c)

  private def candidateCells = cells.flatMap(_.neighbours)

  def next = new Board(candidateCells.filter(c => {
    val boardCell = c.on(this)
    val liveNeighbours = boardCell.liveNeighbourCount
    (boardCell.isAlive && liveNeighbours == 2) || liveNeighbours == 3
  }))

  def boundingBox = {
    import math.{min, max}
    // xMin, yMin, xMax, yMax
    cells.foldLeft(Rectangle(Int.MinValue, Int.MinValue, Int.MaxValue, Int.MaxValue))((acc, cell) => {
      Rectangle(min(acc.x1, cell.x), min(acc.y1, cell.y), max(acc.x2, cell.x), max(acc.y2, cell.y))
    })
  }

}

case class Cell(x: Int, y: Int) {
  def neighbours = {
    for (i <- (x - 1 to x + 1);
         j <- (y - 1 to y + 1) if (i != 0 && j != 0)) yield Cell(x, y)
  }

  def on(b: Board) = new BoardCell(this, b)
}

class BoardCell(val cell: Cell, val board: Board) extends Cell(cell.x, cell.y) {
  def isAlive = board.isCellAlive(this)

  def liveNeighbourCount = neighbours.count(_.on(board).isAlive)
}