package org.xin.lab;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class ResourceEditView extends CustomComponent {

  private final Panel panel = new Panel();
  private final VerticalLayout viewLayout = new VerticalLayout();

  private final ResourceToolbar resouceToolbar = new ResourceToolbar();
  private final ResourceEditFields fields = new ResourceEditFields();
  private final HorizontalLayout footers = new HorizontalLayout();

  public ResourceEditView() {
    setCompositionRoot(panel);
    panel.setContent(viewLayout);
    viewLayout.setWidth(412, UNITS_PIXELS);
    viewLayout.setHeight(100, UNITS_PERCENTAGE);
    init();
  }

  private void init() {
    addResourceToolbar();
    addFields();
    addSaveAndCancelButtons();
  }

  private void addResourceToolbar() {
    viewLayout.addComponent(resouceToolbar);
  }

  private void addFields() {
    viewLayout.addComponent(fields);
  }

  private void addSaveAndCancelButtons() {
    final Button cancelBtn = new Button("Cancel");
    final Button saveBtn = new Button("Save");

    footers.addComponent(cancelBtn);
    footers.addComponent(saveBtn);

    viewLayout.addComponent(footers);
    viewLayout.setComponentAlignment(footers, Alignment.BOTTOM_RIGHT);
  }

  public void setResource(MyResource person) {
    fields.setResource(person);
  }

}