package org.xin.lab;

import com.vaadin.Application;
import com.vaadin.ui.Window;

public class MyVaadinApplication extends Application {

  private static final long serialVersionUID = 2730851013621364623L;

  private final Window mainWindow = new Window("Hello World MainWindow");

  private final ViewManager viewManager = new ViewManagerImpl(mainWindow);

  @Override
  public void init() {
    setTheme("escidoc");
    setMainWindow(mainWindow);
    showResourceEditView();
    // showLandingView();
  }

  private void showResourceEditView() {
    viewManager.showResourceEditView();
  }

  private void showLandingView() {
    viewManager.showViewChanger();
  }
}