name := "streams"

version := "1.0"

scalaVersion := "2.11.7"
resolvers += "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

libraryDependencies += ("com.typesafe.akka" %% "akka-stream" % "2.4.3")
