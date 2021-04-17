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
   "Isaac",
   "Isabella",
   "Mason",
   "Emma",
   "William",
   "Olivia",
   "Jayden",
   "Ava",
   "Noah",
   "Emily",
   "Michael",
   "Abigail",
   "Ethan",
   "Madison",
   "Alexander",
   "Mia",
   "Chloe",
   "Daniel",
   "Elizabeth"
  )

  val Name = possibleRepliesName(
    random.nextInt(possibleRepliesName.length)
  )
   random.between(2, 5)



  val possibleRepliesWord = Seq(
    "Police",
    "Drone",
    "Hi",
    "Red",
    "Green",
    "Gang",
    "Dude",
    "tire ",
    "perform ",
    "appreciate ",
    "tear ",
    "scrap ",
    "pair ",
    "overcharge ",
    "strap ",
    "excitement ",
    "killer"
  )

  val Word = possibleRepliesWord(
    random.nextInt(possibleRepliesWord.length)
  )

  val possibleRepliesLat = Seq(
    "48.969667",
    "48.168578",
    "48.455945",
    "48.754863",
    "48.391328",
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
    "01.754863",
    "01.021568",
    "01.648512",
    "01.791328",
    "01.866667",
    "02.569478",
    "02.235984",
    "02.021568",
    "02.648512",
    "02.791328",
    "02.648512",
    "02.791328",
    "02.754863"
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



