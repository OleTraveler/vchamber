name := "vchamber"

version := "0.1"

scalaVersion := "2.13.3"

libraryDependencies ++= Seq(
  "org.scalatestplus" %% "scalatestplus-scalacheck" % "3.1.0.0-RC2" % Test,
  "org.scalatest" %% "scalatest-mustmatchers" % "3.2.0" % Test,
  "org.scalatest" %% "scalatest" % "3.2.0" % Test
)


mainClass in (Compile, run) := Some("chamber.Main")
