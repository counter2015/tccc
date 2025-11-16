ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.7.4"

ThisBuild / name := "tccc"

lazy val root = (project in file("."))
  .settings(
    name := "tccc"
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.19" % Test

Global / onChangedBuildSource := ReloadOnSourceChanges

scalafmtOnCompile := true
scalafixOnCompile := false
semanticdbEnabled := true

scalacOptions ++= Seq(
  "-feature", // Emit warning and location for usages of features that should be imported explicitly.
  "-deprecation", // Emit warning and location for usages of deprecated APIs.
  "-encoding",
  "utf-8", // Specify character encoding used by source files.
  "-explaintypes", // Explain type errors in more detail.
  "-Wunused:all"
)
