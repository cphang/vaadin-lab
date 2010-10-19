package org.xin.lab;

import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;

public class AddRemoveButtons extends CustomComponent {

  private final HorizontalLayout hLayout = new HorizontalLayout();
  private final Button cancelBtn = new Button("+");
  private final Button okBtn = new Button("-");

  public AddRemoveButtons() {
    setCompositionRoot(hLayout);
    hLayout.addComponent(cancelBtn);
    cancelBtn.addStyleName("small");
    okBtn.addStyleName("small");
    hLayout.addComponent(okBtn);
  }
}
