package org.inszy.gameoflife

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.SuperSuite

/**
 * Created by IntelliJ IDEA.
 * User: Maciej Biłas
 * Date: 1/15/11
 * Time: 19:43
 */

@RunWith(classOf[JUnitRunner])
class GameOfLifeTests
  extends SuperSuite(List(
    new BoardTest(),
    new CellTest(),
    new BoardPrinterTest(),
    new BoardReaderTest()
  ))