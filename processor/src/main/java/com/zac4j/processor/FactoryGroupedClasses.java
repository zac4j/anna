package com.zac4j.processor;

import com.zac4j.factory.Factory;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Filer;
import javax.lang.model.util.Elements;

/**
 * Class for group {@link FactoryAnnotatedClass} together.
 * Created by Zaccc on 2017/8/17.
 */

public class FactoryGroupedClasses {

  private String qualifiedClassName;

  private Map<String, FactoryAnnotatedClass> itemsMap = new LinkedHashMap<>();

  public FactoryGroupedClasses(String qualifiedClassName) {
    this.qualifiedClassName = qualifiedClassName;
  }

  /**
   * Adds an annotated class to this factory.
   *
   * @throws ProcessingException if another annotated class with the same id is
   * already present.
   */
  public void add(FactoryAnnotatedClass toInsert) throws ProcessingException {

    FactoryAnnotatedClass existing = itemsMap.get(toInsert.getId());
    if (existing != null) {
      throw new ProcessingException(toInsert.getTypeElement(),
          "Conflict: The class %s is annotated with @%s with id ='%s' but %s already uses the same id",
          toInsert.getTypeElement().getQualifiedName().toString(), Factory.class.getSimpleName(),
          toInsert.getId(), existing.getTypeElement().getQualifiedName().toString());
    }

    itemsMap.put(toInsert.getId(), toInsert);
  }

  public void generateCode(Elements elementUtils, Filer filer) throws IOException {

  }
}
