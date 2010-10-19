package org.xin.lab;

import com.vaadin.incubator.cufonlabel.CufonLabel;
import com.vaadin.incubator.cufonlabel.CufonLink;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.Panel;

import org.vaadin.browsercookies.BrowserCookies;

public class AddOnView extends CustomComponent {

  private int counter = 0;
  private final Panel panel = new Panel();

  public AddOnView() {
    setCompositionRoot(panel);
    panel.addComponent(new Button("Click Foo"));
    final Label label = new CufonLabel("Hello Vaadin user",
        "HelveticaRoundedBold");
    panel.addComponent(label);

    final Link l = new CufonLink("Testing a link", "HelveticaRoundedBold",
        new ExternalResource("http://vaadin.com"));
    panel.addComponent(l);

    final Label cookieTxt = new Label("[cookies not read]", Label.CONTENT_RAW);
    panel.addComponent(cookieTxt);

    // BrowserCookies widget (by default reads the cookie values)
    final BrowserCookies cookies = new BrowserCookies();
    panel.addComponent(cookies);

    // Listen when cookies are available and read them
    cookies.addListener(new BrowserCookies.UpdateListener() {

      public void cookiesUpdated(BrowserCookies bc) {
        String txt = "";
        for (final String name : bc.getCookieNames()) {
          txt += name + " = '" + bc.getCookie(name) + "'<br />";
        }
        cookieTxt.setValue(txt);
      }
    });

    final Label c = new Label(Integer.toString(counter));
    panel.addComponent(c);

    final Button button = new Button("OK");
    panel.addComponent(button);

    button.addListener(new ClickListener() {
      //
      @Override
      public void buttonClick(ClickEvent event) {
        System.out.println("foo");
        while (true) {
          counter++;
          c.setCaption(Integer.toString(counter));
        }
      }
    });
  }

}
