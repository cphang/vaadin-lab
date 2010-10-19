package org.xin.lab;

import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Field;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import java.util.Collection;

public class ResourceEditView extends CustomComponent {

  private final Panel panel = new Panel();
  private final VerticalLayout viewLayout = new VerticalLayout();

  private final ResourceToolbar resouceToolbar = new ResourceToolbar();
  private final ResourceEditFields fields = new ResourceEditFields();
  private final AddSaveAndCancelButtons footers = new AddSaveAndCancelButtons();
  private Collection<Field> allFields;
  private final Window mainWindow;

  public ResourceEditView(Window mainWindow) {
    this.mainWindow = mainWindow;
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
    allFields = fields.getAllFields();
    footers.setOkButtonListener(new OkButtonListener(allFields, mainWindow));

    viewLayout.addComponent(footers);
    viewLayout.setComponentAlignment(footers, Alignment.BOTTOM_RIGHT);
  }

  public void setItemToBind(BeanItem<MyResource> beanItem) {
    fields.setItemToBind(beanItem);
  }

}