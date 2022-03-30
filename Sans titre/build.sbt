name := "Scala"

version := "0.1"

scalaVersion := "2.12.13"

libraryDependencies += "com.lihaoyi" %% "upickle" % "0.9.5"
libraryDependencies += "com.lihaoyi" %% "os-lib" % "0.7.3"
libraryDependencies += "com.typesafe.play" %% "play-json" % "2.9.2"
libraryDependencies +=  "org.scalaj" %% "scalaj-http" % "2.4.2"
libraryDependencies += "ai.x" %% "play-json-extensions" % "0.42.0"
//libraryDependencies += "org.json4s" %% "json4s-native" % "3.4.0"
//libraryDependencies += "org.json4s" %% "json4s-jackson" % "3.4.0"

// https://mvnrepository.com/artifact/org.apache.hadoop/hadoop-hdfs
libraryDependencies += "org.apache.hadoop" % "hadoop-hdfs" % "2.4.0" % Test