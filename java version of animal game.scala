import java.util.Scanner
import java.util.Random

val input = new Scanner(System.in)
val random = new Random()

var name = ""
var hunger = 50
var happiness = 50
var energy = 50
var alive = true

println("=== Animal Raising Game ===")
print("Name your animal: ")
name = input.nextLine()

println(s"Welcome! Your animal's name is $name.")

while (alive) {
  println("\n--------------------")
  println(s"$name's Status")
  println(s"Hunger: $hunger")
  println(s"Happiness: $happiness")
  println(s"Energy: $energy")
  println("--------------------")

  println("Choose an action:")
  println("1. Feed")
  println("2. Play")
  println("3. Sleep")
  println("4. Quit")

  print("Enter number: ")
  val choice = input.nextLine()

  if (choice == "1") {
    hunger -= 20
    happiness += 5
    energy -= 5
    println(s"You fed $name!")
  } else if (choice == "2") {
    happiness += 20
    hunger += 10
    energy -= 15
    println(s"You played with $name!")
  } else if (choice == "3") {
    energy += 25
    hunger += 10
    happiness -= 5
    println(s"$name slept well!")
  } else if (choice == "4") {
    println("Game ended. Bye!")
    alive = false
  } else {
    println("Invalid choice.")
  }

  // Java Random library
  val event = random.nextInt(3)

  if (event == 0 && alive) {
    hunger += 5
    println(s"$name got a little hungry.")
  } else if (event == 1 && alive) {
    happiness -= 5
    println(s"$name got a little bored.")
  }

  if (hunger < 0) hunger = 0
  if (hunger > 100) hunger = 100
  if (happiness < 0) happiness = 0
  if (happiness > 100) happiness = 100
  if (energy < 0) energy = 0
  if (energy > 100) energy = 100

  if (hunger >= 100) {
    println(s"$name got too hungry. Game over!")
    alive = false
  } else if (happiness <= 0) {
    println(s"$name became too sad. Game over!")
    alive = false
  } else if (energy <= 0) {
    println(s"$name got too tired. Game over!")
    alive = false
  }
}

input.close()