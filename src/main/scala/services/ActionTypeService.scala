package services

import models.requests.CreateActionTypeRequest
import dao.ActionTypeDAO
import models.ActionType

object ActionTypeService {
  
  def create(req: CreateActionTypeRequest) = {
    val aType = new ActionType(req.actionType, req.description)
    ActionTypeDAO.newActionType(aType)
  }
}