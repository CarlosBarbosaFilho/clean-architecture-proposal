package br.com.cbgomes.exception

import java.util.UUID

class ResourceAlreadyExistsException(resourceName: String, id: UUID) :
    RuntimeException("Resource $resourceName already exists with id $id")
