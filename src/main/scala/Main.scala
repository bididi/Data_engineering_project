import scala.math.random
import scala.util.Random
import java.util.TimerTask

object Main {
  def main(args: Array[String]): Unit = {


    val drone1 = new Drone(1)
    val drone2 = new Drone(2)

    val task = new TimerTask {

      def run()= {



        drone1.doReport()
        drone2.doReport()
      }
  }
    val timer = new java.util.Timer()
    timer.schedule(task, 0, 60000)
  }

}
