package org.xin.lab;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.SplitPanel;
import com.vaadin.ui.VerticalLayout;

public class AppView extends CustomComponent {

  private static final long serialVersionUID = 6213388082574608036L;
  private final VerticalLayout viewLayout = new VerticalLayout();
  private final SplitPanel splitPanel = new SplitPanel();
  private final ResourceEditView editView = new ResourceEditView();
  private final MyResource person = new PersonImpl();

  public AppView() {
    setCompositionRoot(viewLayout);
    init();
    bindData();
  }

  private void bindData() {
    person.setName("John Doe");
    person.setEmail("John.Doe@example.org");

    editView.setResource(person);
  }

  private void init() {
    setStyleName("landing-view");

    setSizeFull();
    viewLayout.setSizeFull();

    viewLayout.addComponent(splitPanel);
    splitPanel.setSizeFull();
    splitPanel.setOrientation(SplitPanel.ORIENTATION_HORIZONTAL);
    splitPanel.setSplitPosition(75, UNITS_PERCENTAGE);

    splitPanel.addComponent(new Label("left"));
    splitPanel.addComponent(editView);

  }
}