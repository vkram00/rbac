package services

import dao.UserRoleDAO
import dao.RoleEntitlementsDAO
import models.requests.CreateRoleRequest
import models.Role
import models.RoleResourceEntitlement

object RoleService {

  def getAllRolesOfUser(userId: String): Option[List[String]] = {
    UserRoleDAO.getUserRoles(userId)
  }

  def getRoleEntitlements(roleId: String) = {
    RoleEntitlementsDAO.getRoleEntitlements(roleId)
  }

  def createRole(req: CreateRoleRequest): String = {
    val role = new Role(req.name, req.description)
    val entitlements = req.entitlements map {
      ent => new RoleResourceEntitlement(role.roleId, ent.resourceId, ent.actionType)
    }
    RoleEntitlementsDAO.newRole(role, entitlements)
    role.roleId
  }
  
  def addUserToRole(userId: String, roleId: String) = {
    UserRoleDAO.addUserToRole(userId, roleId)
  }
}