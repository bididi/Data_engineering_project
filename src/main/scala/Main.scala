import scala.math.random
import scala.util.Random

object Main {
  def main(args: Array[String]): Unit = {
    val random = new Random
    val report = Report(random.nextInt(100))
    report.getName()
    val report1 = Report(random.nextInt(100))
    report1.getName()
  }
}
