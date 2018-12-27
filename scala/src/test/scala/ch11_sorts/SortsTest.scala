package ch11_sorts

import org.scalatest.{FlatSpec, Matchers}

import scala.util.Random

class SortsTest extends FlatSpec with Matchers {

  behavior of "SortsTest"

  it should "bubbleSort int arrays" in {
    var array = Array(4, 5, 6, 3, 2, 1)
    array = Sorts.bubbleSort(array)
    array.mkString("") should equal("123456")

    array = Array(4)
    array = Sorts.bubbleSort(array)
    array.mkString("") should equal("4")
  }

  it should "insertSort int arrays" in {
    var array = Array(4, 5, 6, 1, 3, 2)
    array = Sorts.insertSort(array)
    array.mkString("") should equal("123456")

    array = Array(4)
    array = Sorts.insertSort(array)
    array.mkString("") should equal("4")
  }

  it should "selectionSort int arrays" in {
    var array = Array(4, 5, 6, 1, 3, 2)
    array = Sorts.insertSort(array)
    array.mkString("") should equal("123456")

    array = Array(4)
    array = Sorts.insertSort(array)
    array.mkString("") should equal("4")
  }


  it should "compare the sort algo" in {
    val length = 50000
    val array = new Array[Int](length)
    val rnd = new Random()
    for (i <- Range(0, length)) {
      array(i) = rnd.nextInt()
    }

    timed("bubbleSort", Sorts.bubbleSort(array.clone()))
    timed("insertSort", Sorts.bubbleSort(array.clone()))
    timed("selectionSort", Sorts.bubbleSort(array.clone()))
  }

  def reportElapsed(name: String, time: Long): Unit = println(name + " takes in " + time + "ms")

  def timed[T](name: String, f: => T): T = {
    val start = System.currentTimeMillis()
    try f finally reportElapsed(name, System.currentTimeMillis - start)
  }
}
