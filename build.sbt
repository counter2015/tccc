ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.1"

ThisBuild / name := "tccc"

lazy val root = (project in file("."))
  .settings(
    name := "tccc",
  )


libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.18" % Test

Global / onChangedBuildSource := ReloadOnSourceChanges

scalafmtOnCompile                      := true