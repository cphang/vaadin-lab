package org.xin.lab;

import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;

public class AddSaveAndCancelButtons extends CustomComponent {
  final HorizontalLayout footers = new HorizontalLayout();

  final Button cancelBtn = new Button("Cancel");
  final Button saveBtn = new Button("Save");

  public AddSaveAndCancelButtons() {
    setCompositionRoot(footers);
    footers.addComponent(cancelBtn);
    footers.addComponent(saveBtn);

  }

  public void setOkButtonListener(OkButtonListener okButtonListener) {
    saveBtn.addListener(okButtonListener);
  }
}