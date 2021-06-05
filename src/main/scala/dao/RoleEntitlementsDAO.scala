package dao

import scala.collection.mutable.HashMap
import models.Role
import models.RoleResourceEntitlement
import models.RoleResourceEntitlement

object RoleEntitlementsDAO {

  val roleDetails = new HashMap[String, Role]()
  val roleEntitlements = new HashMap[String, List[RoleResourceEntitlement]]

  def newRole(role: Role, entitlements: List[RoleResourceEntitlement]) = {
    roleDetails += (role.roleId -> role)
    roleEntitlements += (role.roleId -> entitlements)
  }

  def getRoleDetails(roleId: String) = {

  }

  def getRoleEntitlements(roleId: String): List[RoleResourceEntitlement] = {
    roleEntitlements.get(roleId) match {
      case Some(ents) => ents
      case None => List[RoleResourceEntitlement]()
    }
  }
  
  
}