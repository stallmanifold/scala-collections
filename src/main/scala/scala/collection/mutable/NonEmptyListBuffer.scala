package scala
package collection
package mutable


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

class NonEmptyListBuffer[A](private var head: A) {
  private var tail: ListBuffer[A] = ListBuffer()

  def ++=(xs: TraversableOnce[A]): NonEmptyListBuffer[A] = {
    this.tail ++= xs

    this
  }

  def ++=:(xs: TraversableOnce[A]): NonEmptyListBuffer[A] = {
    val iterator: Iterator[A] = xs.toIterator
    if (iterator.hasNext) {
      this.head +=:  this.tail
      this.head =    iterator.next
      iterator  ++=: this.tail
    }

    this
  }
}
