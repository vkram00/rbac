package dao

import scala.collection.mutable.HashMap

object UserRoleDAO {
  
  val userRoles = new HashMap[String, List[String]]
  val roleUsers = new HashMap[String, List[String]]
  
  def addUserToRole(userId: String, roleId: String) = {
    val rLst = userRoles.get(userId) match{
      case Some(lst) => 
        (roleId:: lst).distinct
      case None =>
        List(roleId)
    }
    userRoles += (userId -> rLst)
    
    val uLst = roleUsers.get(roleId) match{
      case Some(lst) => 
        (userId:: lst).distinct
      case None =>
        List(userId)
    }
    roleUsers += (roleId -> uLst)
  }
  
  def getUserRoles(userId: String): Option[List[String]] = {
    userRoles.get(userId)
  }
  
  def getRoleUsers(roleId: String): Option[List[String]] = {
    roleUsers.get(roleId)
  }
  
  
}