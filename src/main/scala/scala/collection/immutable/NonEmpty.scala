package scala.collection.immutable

import scala.collection.{GenTraversableOnce}


object NonEmpty {
  def apply[A](value: A): NonEmpty[A] = Tail(value)

}

sealed abstract class NonEmpty[+A] {
  def head: A
  def tail: List[A]

  def ::|[B >: A](x: B): NonEmpty[B] = {
    new ::|(x, this)
  }

  def :::|[B >: A](prefix: NonEmpty[B]): NonEmpty[B] = {
    prefix match {
      case ::|(head, tail) => (tail :::| this).::|(head)
      case Tail(lastValue) => this.::|(lastValue)
    }
  }

  final def map[B](f: (A) => B): NonEmpty[B] = {
    this match {
      case ::|(head, tail) => tail.map(f).::|(f(head))
      case Tail(lastValue) => Tail(f(lastValue))
    }
  }
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