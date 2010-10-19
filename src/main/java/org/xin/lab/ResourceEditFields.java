package org.xin.lab;

import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Field;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.TextField;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ResourceEditFields extends CustomComponent {

  private final static Logger log = LoggerFactory.getLogger(ResourceEditFields.class);

  private final FormLayout fieldLayout = new FormLayout();

  private final TextField nameField = new TextField("Name");
  private final TextField emailField = new TextField("e-mail");
  private final TextField phoneField = new TextField("Phone");

  private final AddRemoveButtons addAndRemoveButtons = new AddRemoveButtons();
  private final FieldsBinder binder = new FieldsBinder();
  private final List<Field> allFields = new ArrayList<Field>();

  private BeanItem<MyResource> item;

  public ResourceEditFields() {
    buildLayout();
    createAndAddFields();
  }

  private void createAndAddFields() {
    addNameField();
    addEmailField();
    addPhoneField();
    addHobbiesField();
    addAccordion();
    addAddFieldButton();
  }

  private void addPhoneField() {
    phoneField.setWidth(200, UNITS_PIXELS);
    fieldLayout.addComponent(phoneField);
  }

  private void addEmailField() {
    emailField.setRequired(true);
    emailField.setWidth("200px");
    fieldLayout.addComponent(emailField);
  }

  private void addNameField() {

    nameField.setWidth("300px");
    fieldLayout.addComponent(nameField);

    nameField.setInvalidCommitted(false);
    nameField.setNullRepresentation("");
    nameField.setNullSettingAllowed(false);
    nameField.setWriteThrough(false);
    fieldLayout.addComponent(new Label("created by"));
  }

  private void buildLayout() {
    setCompositionRoot(fieldLayout);
    fieldLayout.setMargin(true);
    fieldLayout.setWidth("400px");
    fieldLayout.setHeight(100, UNITS_PERCENTAGE);
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

  public void setItemToBind(BeanItem<MyResource> beanItem) {
    this.item = beanItem;
    binder.bindFields();
  }

  private class FieldsBinder {

    private Field toBeBind;

    private void bindFields() {
      bind(nameField).with(getPropertyWithIdName());
      bind(emailField).with(getPropertyWithIdEmail());
    }

    private Property getPropertyWithIdName() {
      return getProperty("name");
    }

    private Property getPropertyWithIdEmail() {
      return getProperty("email");
    }

    private Property getProperty(Object id) {
      return item.getItemProperty(id);
    }

    private FieldsBinder bind(TextField nameField) {
      this.toBeBind = nameField;
      return this;
    }

    private void with(Property itemProperty) {
      toBeBind.setPropertyDataSource(itemProperty);
    }
  }

  public List<Field> getAllFields() {
    final Iterator<Component> iterator = fieldLayout.getComponentIterator();
    while (iterator.hasNext()) {
      final Component component = iterator.next();
      if (component instanceof Field) {
        allFields.add((Field) component);
      }
    }
    return allFields;
  }

}
