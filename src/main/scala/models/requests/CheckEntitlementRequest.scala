package models.requests

case class CheckEntitlementRequest(
    resourceId: String,
    actionType: String
)