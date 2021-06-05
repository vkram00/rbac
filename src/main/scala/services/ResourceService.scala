package services

import models.requests.CreateResourceRequest
import models.Resource
import dao.ResourceDAO

object ResourceService {
  
  def create(req: CreateResourceRequest) = {
    val resource = new Resource(req.name, req.description)
    ResourceDAO.newResource(resource)
    resource.resourceId
  }
}