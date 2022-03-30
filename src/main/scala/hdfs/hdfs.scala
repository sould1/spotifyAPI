package hdfs

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import java.io.PrintWriter;

object hdfs {

  def main(args : Array[String]) {
    println( "Trying to write to HDFS..." )
    val conf = new Configuration()
    val fs= FileSystem.get(conf)
    val output = fs.create(new Path("hdfs://quickstart.cloudera:8020/tmp/mySample.txt"))
    val writer = new PrintWriter(output)
    try {
      writer.write("this is a test")
      writer.write("\n")
    }
    finally {
      writer.close()
    }
    print("Done!")
  }
}



