import org.apache.kafka.clients.producer.ProducerConfig

import java.util.Properties
import scala.util.Random

 case class Report(Id: Int) extends Drone(Id){

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

  val Name1 = possibleRepliesName(
    random.nextInt(possibleRepliesName.length)
  )
   val Name2 = possibleRepliesName(
     random.nextInt(possibleRepliesName.length)
   )

   val Name3 = possibleRepliesName(
     random.nextInt(possibleRepliesName.length)
   )

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
    "appreciate",
    "tear",
    "scrap",
    "pair",
    "overcharge",
    "strap",
    "excitement",
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

  val possibleRepliespeaceScore = Seq(

    "100",
    "99",
    "98",
    "97",
    "96",
    "81",
    "82",
    "83",
    "68",
    "67",
    "74",
    "12",
    "15",
    "29",
    "47",
    "63",
    "38",
    "2",


  )

   val peaceScore1 = possibleRepliespeaceScore(
     random.nextInt(possibleRepliespeaceScore.length)
   )
   val peaceScore2 = possibleRepliespeaceScore(
     random.nextInt(possibleRepliespeaceScore.length)
   )
   val peaceScore3 = possibleRepliespeaceScore(
     random.nextInt(possibleRepliespeaceScore.length)
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

  val Long = possibleRepliesLong(
    random.nextInt(possibleRepliesLong.length)
  )

   //val slash = "/"
   val virg = ","
   val concat = (Id.toString).concat(virg)
   val concat1 = concat.concat(Lat)
   val concat2 = concat1.concat(virg)
   val concat3 = concat2.concat(Long)
   val concat4 = concat3.concat(virg)
   val concat5 = concat4.concat(Name1)
   val concat6 = concat5.concat(virg)
   val concat7 = concat6.concat(Name2)
   val concat8 = concat7.concat(virg)
   val concat9 = concat8.concat(Name3)
   val concat10 = concat9.concat(virg)
   val concat11 = concat10.concat(Word)
   val concat12 = concat11.concat(virg)
   val concat13 = concat12.concat(peaceScore1)
   val concat14 = concat13.concat(virg)
   val concat15 = concat14.concat(peaceScore2)
   val concat16 = concat15.concat(virg)
   val concat17 = concat16.concat(peaceScore3)

   if (peaceScore1.toInt < 50) {

     val concatt = Lat.concat(virg)
     val concatt2 = concatt.concat(Long)
     val concatt3 = concatt2.concat(virg)
     val concatt4 = concatt3.concat(Name1)
     super.doAlert(concatt4)

   }
   if (peaceScore2.toInt < 50) {
     val concatt = Lat.concat(virg)
     val concatt2 = concatt.concat(Long)
     val concatt3 = concatt2.concat(virg)
     val concatt4 = concatt3.concat(Name2)
     super.doAlert(concatt4)
   }
   if (peaceScore3.toInt < 50) {
     val concatt = Lat.concat(virg)
     val concatt2 = concatt.concat(Long)
     val concatt3 = concatt2.concat(virg)
     val concatt4 = concatt3.concat(Name3)
     super.doAlert(concatt4)
   }

  def getName(): (String)= {
    //val rapport = "Report drone id°"+ Id  + " Latitude et longitude " + "("+Lat +","+ Long +")"+" Drone see : "+ Name + " with Peace score "+ peaceScore + " Peacewatcher heard : "+ Word
    concat17
  }
}



