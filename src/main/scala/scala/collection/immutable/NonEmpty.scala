package scala.collection.immutable


sealed abstract class NonEmpty[A] {
  def head: A
  def tail: List[A]
}

final case class ::|[A](value: A, private[scala] var tl: NonEmpty[A]) extends NonEmpty[A] {
  override def head: A = value
  override def tail: List[A] = tl match {
    case ::|(head, tailOfList) => head :: tailOfList.tail
    case Tail(lastValue) => List(lastValue)
  }
}

final case class Tail[A](value: A) extends NonEmpty[A] {
  override def head: A = value
  override def tail: List[A] = Nil
}