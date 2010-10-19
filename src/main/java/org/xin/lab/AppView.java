package org.xin.lab;

import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.SplitPanel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class AppView extends CustomComponent {

  private static final long serialVersionUID = 6213388082574608036L;
  private final VerticalLayout viewLayout = new VerticalLayout();
  private final SplitPanel splitPanel = new SplitPanel();
  private final ResourceEditView editView;
  private final MyResource person = new PersonImpl();
  private BeanItem<MyResource> beanItem;
  private Label nameLabel;

  public AppView(Window mainWindow) {
    createResource();

    setCompositionRoot(viewLayout);
    editView = new ResourceEditView(mainWindow);
    init();

    bindData();
  }

  private void createResource() {
    person.setName("John Doe");
    person.setEmail("John.Doe@example.org");
  }

  private void bindData() {
    beanItem = new BeanItem<MyResource>(person);

    nameLabel.setPropertyDataSource(beanItem.getItemProperty("name"));

    editView.setItemToBind(beanItem);

  }

  private void init() {
    setStyleName("landing-view");

    setSizeFull();
    viewLayout.setSizeFull();

    viewLayout.addComponent(splitPanel);
    splitPanel.setSizeFull();
    splitPanel.setOrientation(SplitPanel.ORIENTATION_HORIZONTAL);
    splitPanel.setSplitPosition(75, UNITS_PERCENTAGE);

    nameLabel = new Label();

    splitPanel.addComponent(nameLabel);
    splitPanel.addComponent(editView);

  }
}