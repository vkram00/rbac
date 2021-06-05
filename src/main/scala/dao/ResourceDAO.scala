package dao

import models.Resource
import scala.collection.mutable.HashMap

object ResourceDAO {
  
  val resources = HashMap[String, Resource] ()
  
  def newResource(res: Resource): Unit = {
    resources += (res.resourceId -> res)
  }
  
  def getResource(resId: String) = {
    resources.get(resId) match {
      case Some(res) => res
      case None => throw new NoSuchElementException(s"$resId not found")
    }
  }
  
  def getAll: List[Resource] = {
    resources.values.toList
  }
}