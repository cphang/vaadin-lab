/*
 * Copyright 2009 IT Mill Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.xin.lab;

import com.vaadin.Application;
import com.vaadin.incubator.cufonlabel.CufonLabel;
import com.vaadin.incubator.cufonlabel.CufonLink;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class MyVaadinApplication extends Application {

  private final Window mainWindow = new Window("Hello World MainWindow");

  @Override
  public void init() {
    setMainWindow(mainWindow);
    mainWindow.addComponent(new Button("Click Foo"));
    final Label label = new CufonLabel("Hello Vaadin user",
        "HelveticaRoundedBold");
    mainWindow.addComponent(label);

    final Link l = new CufonLink("Testing a link", "HelveticaRoundedBold",
        new ExternalResource("http://vaadin.com"));
    mainWindow.addComponent(l);
  }

}