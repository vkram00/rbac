package driver

import models.requests.CreateActionTypeRequest
import models.requests.CreateUserRequest
import models.requests.AddRoleEntitlementRequest
import models.requests.CreateRoleRequest
import services.RoleService
import services.ActionTypeService
import services.UserService
import models.requests.CreateResourceRequest
import services.ResourceService

object Init {

  def initActionTypes() = {

    val createActions: List[CreateActionTypeRequest] = List(
      CreateActionTypeRequest.apply("READ", "This for granting READ permission"),
      CreateActionTypeRequest.apply("UPDATE", "This for granting UPDATE permission"),
      CreateActionTypeRequest.apply("DELETE", "This for granting DELETE permission"))

    //Initializing ActionTypes
    println("initializing action types")
    createActions.map {
      req => ActionTypeService.create(req)
    }
  }

  def initResources() = {

    val createResources: List[CreateResourceRequest] = List(
      CreateResourceRequest.apply("Application Dashboard", "This resource is related to application dashboard"),
      CreateResourceRequest.apply("User Management", "This resource is related to application's management"),
      CreateResourceRequest.apply("Data Models", "This resource is related to application's data models"),
      CreateResourceRequest.apply("Reports", "This resource is related to application's reports"),
      CreateResourceRequest.apply("Services", "This resource is related to application's services"))
      
   // Creating Dummy resources to the system
      println("creating dummy resource...")
      createResources map {
      req => ResourceService.create(req)
    }
  }

  def initUsers() = {

    // List of User Creation Requests
    val createUsers: List[CreateUserRequest] = List(
      CreateUserRequest.apply("Dummy User #1", "dummy.1@rbac.com"),
      CreateUserRequest.apply("Dummy User #2", "dummy.2@rbac.com"),
      CreateUserRequest.apply("Dummy User #3", "dummy.3@rbac.com"),
      CreateUserRequest.apply("Dummy User #4", "dummy.4@rbac.com"),
      CreateUserRequest.apply("Dummy User #5", "dummy.5@rbac.com"),
      CreateUserRequest.apply("Dummy User #6", "dummy.6@rbac.com"))

    //Creating Dummy Users
    println("creating dummy users...")
    createUsers.map {
      req => UserService.createUser(req)
    }

  }

  def initRoles() = {

    // Role 1 Entitlements
    val role1Ents: List[AddRoleEntitlementRequest] = List(
      AddRoleEntitlementRequest.apply("RESOURCE_1", "READ"),
      AddRoleEntitlementRequest.apply("RESOURCE_3", "READ"),
      AddRoleEntitlementRequest.apply("RESOURCE_5", "READ"))

    // Role 2 Entitlements
    val role2Ents: List[AddRoleEntitlementRequest] = List(
      AddRoleEntitlementRequest.apply("RESOURCE_2", "UPDATE"),
      AddRoleEntitlementRequest.apply("RESOURCE_4", "UPDATE"),
      AddRoleEntitlementRequest.apply("RESOURCE_5", "UPDATE"))

    //Role 3 Entitlements
    val role3Ents: List[AddRoleEntitlementRequest] = List(
      AddRoleEntitlementRequest.apply("RESOURCE_1", "DELETE"),
      AddRoleEntitlementRequest.apply("RESOURCE_2", "DELETE"))

    // List of Role Creation Requests
    val createRoles: List[CreateRoleRequest] = List(
      CreateRoleRequest.apply("Dummy Role #1", "This role grants READ permissions", role1Ents),
      CreateRoleRequest.apply("Dummy Role #2", "This role grants UPDATE permissions", role2Ents),
      CreateRoleRequest.apply("Dummy Role #3", "This role grants DELETE permissions", role3Ents))

    //Creating Dummy Roles
    println("creating dummy roles...")
    createRoles.map {
      req => RoleService.createRole(req)
    }

  }

  def initUserRoles() = {

    println("adding users to roles....")
    RoleService.addUserToRole("USER_1", "ROLE_2")
    RoleService.addUserToRole("USER_2", "ROLE_2")
    RoleService.addUserToRole("USER_3", "ROLE_1")
    RoleService.addUserToRole("USER_1", "ROLE_3")
    RoleService.addUserToRole("USER_3", "ROLE_2")
    RoleService.addUserToRole("USER_6", "ROLE_3")
    RoleService.addUserToRole("USER_4", "ROLE_2")
    RoleService.addUserToRole("USER_5", "ROLE_1")
    RoleService.addUserToRole("USER_5", "ROLE_2")
    RoleService.addUserToRole("USER_6", "ROLE_1")
    RoleService.addUserToRole("USER_2", "ROLE_3")

  }

}