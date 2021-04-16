import org.apache.kafka.clients.producer.ProducerConfig

import java.util.Properties
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

   val slash = "/"
   val concat = (Id.toString).concat(slash)
   val concat1 = concat.concat(Lat)
   val concat2 = concat1.concat(slash)
   val concat3 = concat2.concat(Long)
   val concat4 = concat3.concat(slash)
   val concat5 = concat4.concat(Name)
   val concat6 = concat5.concat(slash)
   val concat7 = concat6.concat(Word)

  def getName(): (String)= {
    //val rapport = "Report drone id°"+ Id  + " Latitude et longitude " + "("+Lat +","+ Long +")"+" Drone see : "+ Name + " with Peace score "+ peaceScore + " Peacewatcher heard : "+ Word
    concat7
  }
}



