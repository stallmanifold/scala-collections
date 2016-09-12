package scala
package collection
package mutable

/*
object NonEmptyListBuffer {
  def apply[A](head: A): NonEmptyListBuffer[A] = {
    new NonEmptyListBuffer(head)
  }

  def apply[A](head: A, tail: A*): NonEmptyListBuffer[A] = {
    var nonEmptyListBuffer = new NonEmptyListBuffer(head)
    nonEmptyListBuffer ++= tail

    nonEmptyListBuffer
  }
}

class NonEmptyListBuffer[A <: AnyRef](override private var head: A) extends Cloneable[A] {
  private var tail: ListBuffer[A] = ListBuffer()
  private var len: Int = 1

  override def ++=(xs: TraversableOnce[A]): NonEmptyListBuffer[A] = {
    this.tail ++= xs

    this
  }

  override def ++=:(xs: TraversableOnce[A]): NonEmptyListBuffer[A] = {
    val iterator: Iterator[A] = xs.toIterator
    if (iterator.hasNext) {
      this.head +=:  this.tail
      this.head =    iterator.next
      iterator  ++=: this.tail
    }

    this
  }

  def +=(x: A): NonEmptyListBuffer[A] = {
    this.tail += x

    this
  }

  def +=:(x: A): NonEmptyListBuffer[A] = {
    this.head +=: this.tail
    this.head = x

    this
  }

  def apply(n: Int): A = {
    n match {
      case 0 => this.head
      case _ => this.tail.apply(n-1)
    }
  }

  def update(n: Int, newElem: A): Unit = {
    n match {
      case 0 => this.head = newElem
      case _ => this.tail.update(n-1, newElem)
    }
  }

  def length: Int = this.len

  override def clone(): NonEmptyListBuffer[A] = {
    val newHead = this.head.clone()
    val newTail = this.tail.clone()

    new NonEmptyListBuffer(newHead, newTail)
  }
}
*/