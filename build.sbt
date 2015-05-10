name := """play-reactive-slick-angular-material-require-seed"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

PlayKeys.playOmnidoc := false

routesGenerator := InjectedRoutesGenerator

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "com.typesafe.play" %% "anorm" % "2.4.0-RC1",
  "com.typesafe.play" %% "play-slick" % "1.0.0-2015-05-02-a1c424e-SNAPSHOT",
  "org.slf4j"           % "slf4j-nop"  % "1.6.4",
  "mysql" % "mysql-connector-java" % "5.1.34",
  // WebJars
  "org.webjars" % "webjars-play_2.11" % "2.4.0-RC1",
  "org.webjars" % "requirejs" % "2.1.17",
  "org.webjars" % "angularjs" % "1.3.15",
  "org.webjars" % "angular-material" % "0.9.0-rc3",
  "org.webjars" % "angular-ui-router" % "0.2.14"
)

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("public"),
  Resolver.sonatypeRepo("snapshots"),
  Resolver.typesafeRepo("releases"),
  Resolver.typesafeRepo("snapshots"),
  Resolver.typesafeIvyRepo("releases"),
  Resolver.typesafeIvyRepo("snapshots"),
  "Scalaz Bintray Repo" at "https://dl.bintray.com/scalaz/releases"
)
