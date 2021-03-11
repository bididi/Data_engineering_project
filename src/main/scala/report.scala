import scala.util.Random

class report() {

  val random = new Random

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

  val possibleRepliesLat = Seq(
    "48.866667",
    "12.569478",
    "20.235984",
    "06.021568",
    "24.648512",
    "35.791328",
    "40.754863"
  )

  val replyLat = possibleRepliesLat(
    random.nextInt(possibleRepliesLat.length)
  )

  val possibleRepliesLong = Seq(
    "18.866667",
    "15.569478",
    "27.235984",
    "55.021568",
    "14.648512",
    "27.791328",
    "33.754863"
  )

  val replyLong = possibleRepliesLong(
    random.nextInt(possibleRepliesLong.length)
  )




}
