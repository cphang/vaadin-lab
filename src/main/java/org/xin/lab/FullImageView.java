package org.xin.lab;

import com.vaadin.terminal.ExternalResource;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import java.net.MalformedURLException;
import java.net.URL;

public class FullImageView extends CustomComponent {
  private final VerticalLayout vLayout = new VerticalLayout();

  public FullImageView() {
    init();
  }

  private void init() {
    setCompositionRoot(vLayout);
    vLayout.setSizeFull();

    URL url;
    try {
      url = new URL(
          "http://upload.wikimedia.org/wikipedia/en/0/05/Picasso_angel_fernandez_de_soto.jpg");
      final Embedded browser = new Embedded("", new ExternalResource(url));
      browser.setType(Embedded.TYPE_BROWSER);
      vLayout.addComponent(new Label("HERE"));
    } catch (final MalformedURLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}