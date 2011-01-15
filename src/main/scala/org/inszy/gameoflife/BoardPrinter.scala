package org.inszy.gameoflife

/**
 * Created by IntelliJ IDEA.
 * User: Maciej Biłas
 * Date: 1/15/11
 * Time: 21:23
 */

class BoardPrinter(b: Board,
                   liveMark: Char = 'X',
                   deadMark: Char = '.') {

  def print(boundingBox: Rectangle = b.boundingBox) = {
    val s = new StringBuilder
    for (yIter <- (boundingBox.y1 to boundingBox.y2)) {
      for (xIter <- (boundingBox.x1 to boundingBox.x2)) {
        s.append(if (b.isCellAlive(Cell(xIter, yIter))) liveMark else deadMark)
      }
      s.append('\n')
    }
    s.toString
  }
}