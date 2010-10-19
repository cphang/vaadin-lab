package org.xin.lab;

import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;

public class ResourceToolbar extends CustomComponent {

  private final CssLayout hLayout = new CssLayout();

  public ResourceToolbar() {
    setSizeFull();
    hLayout.setHeight(100, UNITS_PERCENTAGE);
    setCompositionRoot(hLayout);
    hLayout.addStyleName("toolbar-invert");

    hLayout.addComponent(new Button("New"));
    hLayout.addComponent(new Button("Delete"));
    hLayout.addComponent(new Button("Open"));

    hLayout.setMargin(true);
    hLayout.setMargin(true, true, true, true);

  }

}
