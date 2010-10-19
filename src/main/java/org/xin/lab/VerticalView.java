package org.xin.lab;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;

public abstract class VerticalView extends CustomComponent {

  private final VerticalLayout viewLayout = new VerticalLayout();

  public VerticalView() {
    setCompositionRoot(viewLayout);
    setSizeFull();
    viewLayout.setSizeFull();
  }
}