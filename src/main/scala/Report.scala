import scala.util.Random

 case class Report(Id: Int) {

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

  val Name = possibleRepliesName(
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

  val Word = possibleRepliesWord(
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

  val Lat = possibleRepliesLat(
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
  val peaceScore = random.nextInt(100)


  val Long = possibleRepliesLong(
    random.nextInt(possibleRepliesLong.length)
  )

  def getName():Unit=

    println("Report drone id°"+ Id  + " Latitude et longitude " + "("+Lat +","+ Long +")"+" Drone see : "+ Name + " with Peace score "+ peaceScore + " Peacewatcher heard : "+ Word)



}
