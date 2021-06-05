package models.responses

case class CheckEntitlementResponse(
  userId: String,
  actionType: String,
  resourceId: String,
  isEntitled: Boolean)