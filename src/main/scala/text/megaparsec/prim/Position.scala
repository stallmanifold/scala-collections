package text.megaparsec.prim

import scala.util.Try
import scala.util.{Failure, Success}


object InvalidPositionException {
  def apply(): InvalidPositionException = new InvalidPositionException
}

class InvalidPositionException extends Throwable


object Position {
  def apply(pos: Int): Try[Position] = {
    if (pos > 1) {
      Success(new Position(pos))
    } else {
      Failure(InvalidPositionException())
    }
  }
}

class Position(pos: Int) {
  def unPos: Int = pos
}


object SourcePosition {
  def apply(sourceName: String, sourceLine: Position, sourceColumn: Position): SourcePosition = {
    new SourcePosition(sourceName, sourceLine, sourceColumn)
  }

  def apply(sourceName: String): SourcePosition = initialPosition(sourceName)

  def initialPosition(sourceName: String): SourcePosition = {
    val sourceLine = Position(1).get
    val sourceColumn = Position(1).get

    new SourcePosition(sourceName, sourceLine, sourceColumn)
  }
}

class SourcePosition(sourceName: String, sourceLine: Position, sourceColumn: Position)