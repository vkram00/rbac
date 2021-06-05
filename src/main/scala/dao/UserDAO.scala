package dao

import scala.collection.mutable.HashMap
import models.User

object UserDAO {
  
  val userMap: HashMap[String, User] = new HashMap()
  
  def newUser(uId: String, user: User): Unit = {
    userMap += (uId -> user)
  }
  
  def getUserDetails(uId: String): User = {
    userMap.get(uId) match {
      case Some(user) => user
      case None => throw new NoSuchElementException(s"$uId not found")
    }
  }
  
  def deleteUser(uId: String): Boolean = {
    userMap.remove(uId) match {
      case Some(user) => true
      case None => false
    }
  }
  
}