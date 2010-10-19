package org.xin.lab;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;

public class ViewSwitcher extends CustomComponent {

  private final VerticalLayout vLayout = new VerticalLayout();
  final Button prevBtn = new Button("<");
  final Button nextBtn = new Button(">");
  private final ViewManager viewManager;

  public ViewSwitcher(ViewManager viewManager) {
    this.viewManager = viewManager;
    setCompositionRoot(vLayout);
    init();
  }

  private void init() {
    vLayout.addComponent(prevBtn);
    vLayout.addComponent(nextBtn);

    prevBtn.addListener(new ClickListener() {

      @Override
      public void buttonClick(ClickEvent event) {
        viewManager.showFullImageView();
      }
    });

    nextBtn.addListener(new ClickListener() {

      @Override
      public void buttonClick(ClickEvent event) {
        viewManager.showAddOnView();
      }
    });
  }
}
