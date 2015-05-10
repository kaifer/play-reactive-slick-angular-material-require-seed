package controllers

import dao.CatDAO
import dao.DogDAO
import javax.inject.Inject
import models.Cat
import play.api.data.Form
import play.api.data.Forms.mapping
import play.api.data.Forms.text
import play.api.db.slick.DatabaseConfigProvider
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.mvc.Action
import play.api.mvc.Controller
import models.Dog
import play.db.NamedDatabase
import slick.profile.RelationalProfile

class Application @Inject() (catDao: CatDAO, dogDao: DogDAO, defaultDbConfigProvider: DatabaseConfigProvider, @NamedDatabase("slick_test2") test2DbConfigProvider: DatabaseConfigProvider) extends Controller {
  val defaultDbConfig = defaultDbConfigProvider.get[RelationalProfile]
  val testDbConfig = test2DbConfigProvider.get[RelationalProfile]

  defaultDbConfig.db.run(catDao.getCreateSchema)
  testDbConfig.db.run(dogDao.getCreateSchema)

  def index = Action.async {
    catDao.all().zip(dogDao.all()).map {case (cats, dogs) => Ok(views.html.index(cats, dogs)) }
  }

  val catForm = Form(
    mapping(
      "name" -> text(),
      "color" -> text()
    )(Cat.apply)(Cat.unapply)
  )

  val dogForm = Form(
    mapping(
      "name" -> text(),
      "color" -> text()
    )(Dog.apply)(Dog.unapply)
  )

  def insertCat = Action.async { implicit request =>
    val cat: Cat = catForm.bindFromRequest.get
    catDao.insert(cat).map(_ => Redirect(routes.Application.index))
  }

  def insertDog = Action.async { implicit request =>
    val dog: Dog = dogForm.bindFromRequest.get
    dogDao.insert(dog).map(_ => Redirect(routes.Application.index))
  }
}


/*
slick {
  dbs {
    default {
      driver = "slick.driver.MySQLDriver$"
      db {
        driver = "com.mysql.jdbc.Driver"
        url = "jdbc:mysql://localhost:3306/slick_test"
        user = "root"
        password = "1234"
      }
    }
  }
}
slick {
  dbs {
    slick_test2 {
      driver = "slick.driver.MySQLDriver$"
      db {
        driver = "com.mysql.jdbc.Driver"
        url = "jdbc:mysql://localhost:3306/slick_test2"
        user = "root"
        password = "1234"
      }
    }
  }
}



 */


/*
slick {
  dbs {
    default {
      driver = "slick.driver.H2Driver$"
      db {
        driver = "org.h2.Driver"
        url = "jdbc:h2:mem:play"
        user = "sa"
        password = ""
      }
    }
  }
}
slick {
  dbs {
    slick_test2 {
      driver = "slick.driver.H2Driver$"
      db {
        driver = "org.h2.Driver"
        url = "jdbc:h2:mem:play2"
        user = "sa"
        password = ""
      }
    }
  }
}
 */