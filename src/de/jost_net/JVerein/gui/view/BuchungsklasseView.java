/**********************************************************************
 * $Source$
 * $Revision$
 * $Date$
 * $Author$
 *
 * Copyright (c) by Heiner Jostkleigrewe
 * All rights reserved
 * heiner@jverein.de
 * www.jverein.de
 * $Log$
 **********************************************************************/
package de.jost_net.JVerein.gui.view;

import de.jost_net.JVerein.JVereinPlugin;
import de.jost_net.JVerein.gui.control.BuchungsklasseControl;
import de.willuhn.jameica.gui.AbstractView;
import de.willuhn.jameica.gui.Action;
import de.willuhn.jameica.gui.GUI;
import de.willuhn.jameica.gui.internal.buttons.Back;
import de.willuhn.jameica.gui.util.ButtonArea;
import de.willuhn.jameica.gui.util.LabelGroup;
import de.willuhn.util.ApplicationException;

public class BuchungsklasseView extends AbstractView
{
  public void bind() throws Exception
  {
    GUI.getView().setTitle(JVereinPlugin.getI18n().tr("Buchungsklasse"));

    final BuchungsklasseControl control = new BuchungsklasseControl(this);

    LabelGroup group = new LabelGroup(getParent(), JVereinPlugin.getI18n().tr(
        "Buchungsklasse"));
    group.addLabelPair(JVereinPlugin.getI18n().tr("Nummer"), control
        .getNummer(true));
    group.addLabelPair(JVereinPlugin.getI18n().tr("Bezeichnung"), control
        .getBezeichnung());

    ButtonArea buttons = new ButtonArea(getParent(), 2);

    buttons.addButton(new Back(false));
    buttons.addButton(JVereinPlugin.getI18n().tr("speichern"), new Action()
    {
      public void handleAction(Object context) throws ApplicationException
      {
        control.handleStore();
      }
    }, null, true, "document-save.png");
  }

  public void unbind() throws ApplicationException
  {
  }
}
