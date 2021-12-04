
version := "0.1"

scalaVersion := "2.13.4"

lazy val root = (project in file("."))
  .settings(
    name := "UT-ITAssignment1711"
  )


libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "3.2.10" % Test,
  "org.mockito" %% "mockito-scala" % "1.16.46" % Test)
