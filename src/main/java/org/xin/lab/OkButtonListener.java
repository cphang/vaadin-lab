package org.xin.lab;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Field;
import com.vaadin.ui.Window;

import java.util.Collection;

public class OkButtonListener implements ClickListener {

  private final Collection<Field> allFields;
  private final Window mainWindow;

  /**
   * @param allFields
   */
  public OkButtonListener(Collection<Field> allFields, Window mainWindow) {
    this.allFields = allFields;
    this.mainWindow = mainWindow;
  }

  @Override
  public void buttonClick(ClickEvent event) {

    if (areAllFieldsValid()) {
      // saveToReposity();
      if (isSuccessfull()) {
        commitAllFields();
        showSuccessMessage();
      } else {
        showErrorMessage();
      }
    } else {
      throw new UnsupportedOperationException("not-yet-implemented.");
    }
  }

  private void showErrorMessage() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("not-yet-implemented.");

  }

  private boolean isSuccessfull() {
    return true;
  }

  private void saveToReposity() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("not-yet-implemented.");

  }

  private void commitAllFields() {
    for (final Field field : allFields) {
      field.commit();
    }
  }

  private void showSuccessMessage() {
    mainWindow.showNotification("all valid");
  }

  private boolean areAllFieldsValid() {
    for (final Field field : allFields) {
      if (!field.isValid())
        return false;
    }
    return true;
  }
}
