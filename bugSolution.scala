```scala
class MyClass(val name: String, var age: Int) {
  require(age >= 0, "Age cannot be negative") 
}

object Main extends App {
  val person = new MyClass("John", 30)
  println(person.name + ": " + person.age) //Prints John: 30

  val anotherPerson = new MyClass("Jane", 25)
  //The following line would throw an exception during object creation, now handled in constructor
  //anotherPerson.age = -5
  println(anotherPerson.name + ": " + anotherPerson.age)

  //The following is safe
  val personList = scala.collection.immutable.List(person, anotherPerson)
  for(p <- personList) {
    println(p.name + ": " + p.age)
  }
}
```