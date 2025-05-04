package com.starter.backend.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
  private String resourceName;
  private String fieldName;
  private Object fieldValue;
  public ResourceNotFoundException(String resourceName,String fieldName,Object fieldValue)
  {
    super(String.format("%s with %s ['%s'] not found",resourceName,fieldName,fieldValue));
    this.resourceName=resourceName;
    this.fieldName=fieldName;
    this.fieldValue=fieldValue;
  }

}
