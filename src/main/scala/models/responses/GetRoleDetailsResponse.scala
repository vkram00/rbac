package models.responses

case class GetRoleEntitlementsResponse(
  roleId: String,
  actionType: String,
  resourceId: String)

case class GetRoleDetailsResponse(
  roleId: String,
  name: String,
  description: String,
  entitlements: List[GetRoleEntitlementsResponse])

