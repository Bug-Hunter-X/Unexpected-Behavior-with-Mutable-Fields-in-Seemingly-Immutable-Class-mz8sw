```scala
class MyClass(val name: String) {
  private var _age: Int = 0

  def age: Int = _age
  def age_=(newAge: Int): Unit = {
    if (newAge >= 0) {
      _age = newAge
    } else {
      throw new IllegalArgumentException("Age cannot be negative")
    }
  }
}

object Main extends App {
  val person = new MyClass("John")
  person.age = 30
  println(person.age) //Prints 30

  //Uncommon error: Using a mutable field within an immutable class may lead to unexpected behavior
  val anotherPerson = new MyClass("Jane")
  anotherPerson.age = -5 // throws IllegalArgumentException, as expected

  val personList = scala.collection.mutable.ListBuffer[MyClass]()
  personList += person
  personList += anotherPerson

  for(p <- personList) {
    println(p.name + ": " + p.age)
  }
}
```