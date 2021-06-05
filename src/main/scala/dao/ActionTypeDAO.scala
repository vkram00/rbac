package dao

import models.ActionType
import scala.collection.mutable.HashMap

object ActionTypeDAO {
  
  val actions = HashMap[String, ActionType] ()
  
  def newActionType(aType: ActionType): Unit = {
    actions += (aType.actionType -> aType)
  }
  
  def getTypes: List[String] = {
    actions.keySet.toList
  }
  
  def getAll: List[ActionType] = {
    actions.values.toList
  }
}