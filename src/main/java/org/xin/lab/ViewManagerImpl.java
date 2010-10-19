package org.xin.lab;

import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.Window;

public class ViewManagerImpl implements ViewManager {

  private final Window mainWindow;

  private final ComponentContainer addOnView = new AddOnView();
  private final ComponentContainer viewChanger = new ViewSwitcher(this);
  private final ComponentContainer fullImageView = new FullImageView();
  private final ComponentContainer resouceEditView;

  public ViewManagerImpl(Window mainWindow) {
    this.mainWindow = mainWindow;
    resouceEditView = new AppView(mainWindow);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.xin.lab.ViewManager#showViewChanger()
   */
  @Override
  public void showViewChanger() {
    mainWindow.setContent(viewChanger);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.xin.lab.ViewManager#showAddOnView()
   */
  @Override
  public void showAddOnView() {
    mainWindow.setContent(addOnView);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.xin.lab.ViewManager#showFullImageView()
   */
  @Override
  public void showFullImageView() {
    mainWindow.setContent(fullImageView);
  }

  @Override
  public void showResourceEditView() {
    mainWindow.setContent(resouceEditView);
  }
}
