package services

import models.requests.CreateUserRequest
import models.User
import models.requests.CheckEntitlementRequest
import models.RoleResourceEntitlement
import models.responses.CheckEntitlementResponse

object RBACService {

  def checkEntitlements(userId: String, reqs: List[CheckEntitlementRequest]): List[CheckEntitlementResponse] = {
    val userRoles = RoleService.getAllRolesOfUser(userId)
    var resEntitlemetns = List[CheckEntitlementResponse]()
    userRoles match {
      case Some(rLst) =>
        val roleEnts = rLst map {
          rId => RoleService.getRoleEntitlements(rId)
        }
        val rawEnts = roleEnts.flatten.distinct.map {
          e => CheckEntitlementRequest.apply(e.resourceId, e.action)
        }
        val userEnts = rawEnts.distinct
        resEntitlemetns = reqs map {
          req => CheckEntitlementResponse.apply(userId, req.actionType, req.resourceId, userEnts.contains(req))
        }
      case None =>
        resEntitlemetns = reqs map {
          req => CheckEntitlementResponse.apply(userId, req.actionType, req.resourceId, false)
        }
    }
    resEntitlemetns
  }

}