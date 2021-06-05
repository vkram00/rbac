package models

class Resource(val name: String, val description: String) {
  Resource.idCount()
  val resourceId: String = Resource.getResId
}

object Resource {

  private[this] var idCount = 0

  def idCount(): Unit = { idCount += 1 }

  def getResId: String = s"RESOURCE_${idCount}"

}