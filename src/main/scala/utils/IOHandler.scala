package utils

trait IOReader[T] {
  def read(url: String): String
}

trait IOApiReader[T] extends IOReader[T]{
  override def read(url: String): String = ???
}

abstract class AbstractApiReader[T] extends IOApiReader[T]