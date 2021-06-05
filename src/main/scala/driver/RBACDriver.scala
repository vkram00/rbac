package driver

import models.requests.CreateUserRequest
import services.UserService
import models.Role
import models.requests.CreateRoleRequest
import services.RoleService
import models.RoleResourceEntitlement
import models.requests.AddRoleEntitlementRequest
import models.requests.CreateActionTypeRequest
import services.ActionTypeService
import models.requests.CheckEntitlementRequest
import services.RBACService

object RBACDriver {

  val user1EntChecks: List[CheckEntitlementRequest] = List(
    CheckEntitlementRequest.apply("RESOURCE_1", "READ"),
    CheckEntitlementRequest.apply("RESOURCE_2", "READ"),
    CheckEntitlementRequest.apply("RESOURCE_3", "DELETE"),
    CheckEntitlementRequest.apply("RESOURCE_3", "READ"),
    CheckEntitlementRequest.apply("RESOURCE_4", "UPDATE"),
    CheckEntitlementRequest.apply("RESOURCE_5", "READ"))

  val user2EntChecks: List[CheckEntitlementRequest] = List(
    CheckEntitlementRequest.apply("RESOURCE_1", "READ"),
    CheckEntitlementRequest.apply("RESOURCE_2", "READ"),
    CheckEntitlementRequest.apply("RESOURCE_3", "DELETE"),
    CheckEntitlementRequest.apply("RESOURCE_3", "READ"),
    CheckEntitlementRequest.apply("RESOURCE_4", "UPDATE"),
    CheckEntitlementRequest.apply("RESOURCE_5", "READ"))

  val user3EntChecks: List[CheckEntitlementRequest] = List(
    CheckEntitlementRequest.apply("RESOURCE_1", "READ"),
    CheckEntitlementRequest.apply("RESOURCE_2", "READ"),
    CheckEntitlementRequest.apply("RESOURCE_3", "DELETE"),
    CheckEntitlementRequest.apply("RESOURCE_3", "READ"),
    CheckEntitlementRequest.apply("RESOURCE_4", "UPDATE"),
    CheckEntitlementRequest.apply("RESOURCE_5", "READ"))

  val user4EntChecks: List[CheckEntitlementRequest] = List(
    CheckEntitlementRequest.apply("RESOURCE_1", "READ"),
    CheckEntitlementRequest.apply("RESOURCE_2", "READ"),
    CheckEntitlementRequest.apply("RESOURCE_3", "DELETE"),
    CheckEntitlementRequest.apply("RESOURCE_3", "READ"),
    CheckEntitlementRequest.apply("RESOURCE_4", "UPDATE"),
    CheckEntitlementRequest.apply("RESOURCE_5", "READ"))

  val user5EntChecks: List[CheckEntitlementRequest] = List(
    CheckEntitlementRequest.apply("RESOURCE_1", "READ"),
    CheckEntitlementRequest.apply("RESOURCE_2", "READ"),
    CheckEntitlementRequest.apply("RESOURCE_3", "DELETE"),
    CheckEntitlementRequest.apply("RESOURCE_3", "READ"),
    CheckEntitlementRequest.apply("RESOURCE_4", "UPDATE"),
    CheckEntitlementRequest.apply("RESOURCE_5", "READ"))

  val user6EntChecks: List[CheckEntitlementRequest] = List(
    CheckEntitlementRequest.apply("RESOURCE_1", "READ"),
    CheckEntitlementRequest.apply("RESOURCE_2", "READ"),
    CheckEntitlementRequest.apply("RESOURCE_3", "DELETE"),
    CheckEntitlementRequest.apply("RESOURCE_3", "READ"),
    CheckEntitlementRequest.apply("RESOURCE_4", "UPDATE"),
    CheckEntitlementRequest.apply("RESOURCE_5", "READ"))

  def main(args: Array[String]) {
    Init.initActionTypes()
    Init.initResources()
    Init.initUsers()
    Init.initRoles()
    Init.initUserRoles()

    println(RBACService.checkEntitlements("USER_1", user1EntChecks))
    println(RBACService.checkEntitlements("USER_2", user2EntChecks))
    println(RBACService.checkEntitlements("USER_3", user3EntChecks))
    println(RBACService.checkEntitlements("USER_4", user4EntChecks))
    println(RBACService.checkEntitlements("USER_5", user5EntChecks))
    println(RBACService.checkEntitlements("USER_6", user6EntChecks))
  }
}