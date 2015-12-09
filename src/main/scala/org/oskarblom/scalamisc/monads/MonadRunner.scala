package org.oskarblom.scalamisc.monads

/**
  * Created by oskar on 2015/11/17.
  */
object MonadRunner {

  def getUserName(userId: Int): Option[String] = {
    return Some("a")
  }

  def getUserNames(): List[Option[String]] = {
    return List(
      Some("a"),
      Some("d")
    )
  }

  def getUserEmail(userName: String): Option[String] = {
    return Some("a@b.c")
  }

  def getUserLoginAttempts(userEmail: String): Option[Int] = {
    return Some(3)
  }

  def runFlatMapMonad(): Int = {
    val loginAttemps = getUserName(123).flatMap(name => {
      getUserEmail(name).flatMap(email => {
        getUserLoginAttempts(email)
      })
    })
    loginAttemps match {
      case Some(e) => e
      case _  => 0
    }
  }

  def runFlatMapMonadMulti2(): Int = {
    val stuff = getUserNames().map( userName => {
      val loginAttemps = userName.flatMap(uN => {
        getUserEmail(uN).flatMap(e => {
          getUserLoginAttempts(e)
        })
      })
      (userName, loginAttemps)
    }).toMap
    println(stuff)
    1
  }

  def runFlatMapMonadMulti(): Int = {
    val userName = getUserNames().find(userName => userName.getOrElse("") == "a").flatten
    val un = getUserNames().flatten.find(userName => userName == "a")

    getUserNames().flatMap(userName => {
      getUserEmail(userName.getOrElse("")).flatMap( email => {
        getUserLoginAttempts(email)
      })
    })
    //RequestBuilder().b
    //println(fl)
    1
  }

  def runForCompMonad(): Int = {
    val a = for {
      name <- getUserName(123)
      email <- getUserEmail(name)
      attempts <- getUserLoginAttempts(email)
    } yield (attempts)
    a.getOrElse(0)
  }

  def runDbl = {
    def dbl(x: Int) = { 2 * x }
    val xs = List(1, 2, 3)
    val dbls = xs map dbl
    assert(dbls == List(2, 4 ,6))
    //println(dbls)
  }

  def cnvrt = {
    val one = Some(1)
    val oneString = one.map(_.toString)
    assert(oneString == Some("1"))
    //println(oneString)
  }

  def main(args: Array[String]) {
    //runDbl
    //cnvrt
    //println(runFlatMapMonad)
    //println(runForCompMonad)
    //println(runFlatMapMonadMulti)
    println(runFlatMapMonadMulti2)
  }
}
