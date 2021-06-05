package models.requests

case class AddRoleEntitlementRequest(
  resourceId: String,
  actionType: String)

case class CreateRoleRequest(
  name: String,
  description: String,
  entitlements: List[AddRoleEntitlementRequest])

