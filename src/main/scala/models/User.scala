package models

import java.sql.Timestamp

class User(val name: String, val email: String) {
  User.idCount()
  val userId: String = User.getUserId
  val createdAt: Timestamp = new Timestamp(System.currentTimeMillis())
  var lastLogin: Timestamp = Timestamp.valueOf("1001-01-01 00:00:00")
  
  override def toString: String =
    s"$userId  $name   $email  $createdAt   $lastLogin"

}

object User {

  private[this] var idCount = 0

  def idCount(): Unit = { idCount += 1 }

  def getUserId: String = s"USER_${idCount}"
}