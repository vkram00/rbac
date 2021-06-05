package models.requests

case class CreateActionTypeRequest(
  actionType: String,
  description: String)