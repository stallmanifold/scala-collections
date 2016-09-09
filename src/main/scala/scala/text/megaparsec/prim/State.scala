package scala.text.megaparsec.prim

import scala.collection.immutable.NonEmpty

object State {

}

abstract class State[S] {
  val stateInput: S
  val statePos: NonEmpty[Position]
  val stateTabWidth: Position
}