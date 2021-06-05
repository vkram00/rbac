package services

import models.requests.CreateUserRequest
import models.User
import dao.UserDAO

object UserService {
  
  def createUser(req: CreateUserRequest) = {
    val user = new User(req.name, req.email)
    UserDAO.newUser(user.userId, user)
    user
  }
  
  def getUserDetails(userId: String) = {
    UserDAO.getUserDetails(userId)
  }
  
  def deleteUser(userId: String) = {
    UserDAO.deleteUser(userId) match {
      case true => println(s"$userId deleted successfully")
      case false => throw new NoSuchElementException(s"$userId not found")
    }
  }
  
  
}