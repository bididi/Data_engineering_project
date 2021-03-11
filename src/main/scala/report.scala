import scala.util.Random

val random = new Random

class report {

  val possibleRepliesName = Seq(
    "Sophia",
    "Anthony",
    "Joshua",
    "Logan",
    "Luke",
    "Tyler",
    "Isaac"
  )

  val replyName = possibleRepliesName(
    random.nextInt(possibleRepliesName.length)
  )

  val possibleRepliesWord = Seq(
    "Police",
    "Drone",
    "Hi",
    "Red",
    "Green",
    "Gang",
    "Dude"
  )

  val replyWord = possibleRepliesWord(
    random.nextInt(possibleRepliesWord.length)
  )

}
