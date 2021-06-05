package models

class Role(val name: String, val description: String) {
  Role.idCount()
  val roleId: String = Role.getRoleId
  
  override def toString: String = s"$roleId  $name  $description"
}

object Role {

  private[this] var idCount = 0

  def idCount(): Unit = { idCount += 1 }

  def getRoleId: String = s"ROLE_${idCount}"

}