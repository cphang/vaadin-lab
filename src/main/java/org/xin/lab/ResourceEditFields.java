package org.xin.lab;

import com.vaadin.ui.Accordion;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.TextField;

import java.util.Date;

public class ResourceEditFields extends CustomComponent {

  private final FormLayout fieldLayout = new FormLayout();

  private final TextField nameField = new TextField("Name");
  private final TextField emailField = new TextField("e-mail");

  private final AddRemoveButtons addAndRemoveButtons = new AddRemoveButtons();

  public ResourceEditFields() {
    setCompositionRoot(fieldLayout);
    fieldLayout.setMargin(true);
    fieldLayout.setWidth("400px");
    fieldLayout.setHeight(100, UNITS_PERCENTAGE);

    nameField.setWidth("300px");
    fieldLayout.addComponent(nameField);
    fieldLayout.addComponent(new Label("created by"));

    emailField.setRequired(true);
    emailField.setWidth("300px");
    fieldLayout.addComponent(emailField);

    final TextField c = new TextField("Phone");
    c.setWidth(300, UNITS_PIXELS);
    fieldLayout.addComponent(c);

    addHobbiesField();
    addAccordion();
    addAddFieldButton();
  }

  private void addAddFieldButton() {
    final ComboBox addBtn = new ComboBox("Add");
    addBtn.setWidth(100, UNITS_PIXELS);
    addBtn.addItem("Relationship");
    addBtn.addItem("Country");
    addBtn.addItem("City");
    addBtn.addItem("City");
    fieldLayout.addComponent(addBtn);
  }

  private void addAccordion() {
    final Accordion accordion = new Accordion();
    accordion.setCaption("Accordion");
    accordion.setWidth(300, UNITS_PIXELS);
    for (int counter = 0; counter < 2; counter++) {
      accordion.addTab(new Label(new Date().toString()), new Date().toString(),
          null);
    }
    fieldLayout.addComponent(accordion);
    fieldLayout.addComponent(addAndRemoveButtons);
  }

  private void addHobbiesField() {
    final ListSelect listSelect = new ListSelect("Hobbies");
    listSelect.setWidth(300, UNITS_PIXELS);
    listSelect.setRows(3);
    fieldLayout.addComponent(listSelect);
    fieldLayout.addComponent(new AddRemoveButtons());
  }

  public void setResource(MyResource person) {
    nameField.setValue(person.getName());
    emailField.setValue(person.getEmail());
  }
}
