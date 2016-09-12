package scala
package collection
package generic


trait Appendable[-A] extends AnyRef {
  def +=(elem: A): Appendable[A]

  def ++=(xs: TraversableOnce[A]): Appendable[A] = {
    xs foreach (x => this += x)

    this
  }

  def +=(elem1: A, elem2: A, elems: A*): Appendable[A] = this += elem1 += elem2 ++= elems
}
