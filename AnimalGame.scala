import scala.io.StdIn.readLine
import scala.util.Random

@main def animalGame(): Unit = {

  var name = ""
  var hunger = 50
  var happiness = 50
  var energy = 50
  var alive = true

  println("=== Animal Raising Game ===")
  print("Name your animal: ")
  name = readLine()

  println(s"Welcome! Your animal's name is $name.")

  while (alive) {

    println("\n--------------------")
    println(s"$name's Status")
    println(s"Hunger: $hunger")
    println(s"Happiness: $happiness")
    println(s"Energy: $energy")

    println("\n1. Feed")
    println("2. Play")
    println("3. Sleep")
    println("4. Quit")

    print("Choose: ")
    val choice = readLine()

    if (choice == "1") {
      hunger -= 20
      happiness += 5
      energy -= 5
      println(s"You fed $name.")
    }
    else if (choice == "2") {
      happiness += 20
      hunger += 10
      energy -= 15
      println(s"You played with $name.")
    }
    else if (choice == "3") {
      energy += 25
      hunger += 10
      happiness -= 5
      println(s"$name slept.")
    }
    else if (choice == "4") {
      println("Goodbye!")
      alive = false
    }

    hunger = math.max(0, math.min(100, hunger))
    happiness = math.max(0, math.min(100, happiness))
    energy = math.max(0, math.min(100, energy))

    if (hunger >= 100) {
      println(s"$name is starving! Game Over!")
      alive = false
    }

    if (happiness <= 0) {
      println(s"$name is too sad! Game Over!")
      alive = false
    }

    if (energy <= 0) {
      println(s"$name is exhausted! Game Over!")
      alive = false
    }
  }
}