import org.apache.spark.sql.SparkSession


object DataAnalist {
  def main(args: Array[String]): Unit = {


    val sparkSession: SparkSession = SparkSession.builder.master("local").appName("Scala Spark").getOrCreate()
    sparkSession.sparkContext.setLogLevel("ERROR")

    val df = sparkSession.read
      .format("csv")
      .option("header", "true")
      .load("src/main/data1.csv")

    df.createOrReplaceTempView("data")
    df.show()

    //println("Question 1 : Peacescore moyen par drone ")
    val drone = sparkSession.sql("SELECT Id, ((AVG(Peacescore1)+AVG(Peacescore2)+AVG(Peacescore3))/3) AS Score_moyen from data GROUP BY Id order by Score_moyen DESC ").show()

    //println("Question 2 : Le mot qui est le plus entendue")
    val repetitif = sparkSession.sql("select Word, count (Word) as Number_Word from data group by Word order by Number_Word desc").show(1)


    //println("Question 3 : La personne avec le plus souvent un peacescore en dessous de 50")
    val peace = sparkSession.sql("select name , count(name) as Number_bad from (SELECT Name1 AS name, Peacescore1 from data where Peacescore1 <50 UNION ALL SELECT Name2 AS name, Peacescore2  from data where Peacescore2 <50 UNION ALL SELECT Name3 AS name, Peacescore3 from data where Peacescore3 <50) GROUP BY name order by Number_bad desc").show(1)

    //println("Question 4 : La position Lat et Long avec le score le peascore le plus élevé")
    val geo = sparkSession.sql("SELECT Long, Lat, AVG(Peacescore1)+AVG(Peacescore2)+AVG(Peacescore3) AS score from data GROUP BY Long, Lat order by score DESC ").show(1)
  }

}
