package org.xin.lab;

import java.io.Serializable;

public interface MyResource extends Serializable {

  void setName(String string);

  void setEmail(String string);

  String getName();

  String getEmail();

}
