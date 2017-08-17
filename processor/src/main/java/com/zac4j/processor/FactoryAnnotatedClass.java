package com.zac4j.processor;

import com.zac4j.factory.Factory;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.MirroredTypeException;

/**
 * Class for store annotated class data
 * Created by Zaccc on 2017/8/17.
 */

public class FactoryAnnotatedClass {

  private TypeElement annotatedClassElement;
  private String qualifiedSuperClassName;
  private String simpleTypeName;
  private String id;

  public FactoryAnnotatedClass(TypeElement classElement) {
    this.annotatedClassElement = classElement;
    // Get this class all @Factory info.
    Factory annotation = classElement.getAnnotation(Factory.class);
    id = annotation.id();

    if (Utils.isEmpty(id)) {
      // This will be caught by FactoryProcessor::process.
      throw new IllegalArgumentException(
          String.format("id() in @%s for class %s is null or empty! that's not allowed.",
              Factory.class.getSimpleName(), classElement.getQualifiedName().toString()));
    }

    // Get the full QualifiedTypeName
    try {
      Class<?> clazz = annotation.type();
      qualifiedSuperClassName = clazz.getCanonicalName();
      simpleTypeName = clazz.getSimpleName();
      // Thrown when an application attempts to access the Class
      // object corresponding to TypeMirror.
    } catch (MirroredTypeException e) {
      DeclaredType classTypeMirror = (DeclaredType) e.getTypeMirror();
      TypeElement classTypeElement = (TypeElement) classTypeMirror.asElement();
      qualifiedSuperClassName = classTypeElement.getQualifiedName().toString();
      simpleTypeName = classTypeElement.getSimpleName().toString();
    }
  }

  /**
   * Get the id as specified in {@link Factory#id()}
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Get the full qualified name of the type specified in {@link Factory#type()}
   *
   * @return qualified name
   */
  public String getQualifiedFactoryGroupName() {
    return qualifiedSuperClassName;
  }

  /**
   * Get the simple name of the type specified in {@link Factory#type()}
   *
   * @return simple name
   */
  public String getSimpleFactoryGroupName() {
    return simpleTypeName;
  }

  /**
   * The original element that was annotated with @Factory
   */
  public TypeElement getTypeElement() {
    return annotatedClassElement;
  }
}
