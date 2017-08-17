package com.zac4j.processor;

import javax.lang.model.element.Element;

/**
 * Exception for annotation processing
 * Created by Zaccc on 2017/8/17.
 */

public class ProcessingException extends Exception {

  private Element element;

  public ProcessingException(Element element, String msg, Object... args) {
    super(String.format(msg, args));
    this.element = element;
  }

  public Element getElement() {
    return element;
  }
}
