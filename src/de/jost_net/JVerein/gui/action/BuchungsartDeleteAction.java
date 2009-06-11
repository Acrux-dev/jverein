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
 * Revision 1.1  2008/05/22 06:46:00  jost
 * Buchführung
 *
 **********************************************************************/
package de.jost_net.JVerein.gui.action;

import java.rmi.RemoteException;

import de.jost_net.JVerein.JVereinPlugin;
import de.jost_net.JVerein.rmi.Buchungsart;
import de.willuhn.jameica.gui.Action;
import de.willuhn.jameica.gui.GUI;
import de.willuhn.jameica.gui.dialogs.YesNoDialog;
import de.willuhn.logging.Logger;
import de.willuhn.util.ApplicationException;

/**
 * Loeschen einer Buchungsart.
 */
public class BuchungsartDeleteAction implements Action
{
  public void handleAction(Object context) throws ApplicationException
  {
    if (context == null || !(context instanceof Buchungsart))
    {
      throw new ApplicationException(JVereinPlugin.getI18n().tr(
          "Keine Buchungsart ausgew�hlt"));
    }
    try
    {
      Buchungsart b = (Buchungsart) context;
      if (b.isNewObject())
      {
        return;
      }
      YesNoDialog d = new YesNoDialog(YesNoDialog.POSITION_CENTER);
      d.setTitle(JVereinPlugin.getI18n().tr("Buchungsart l�schen"));
      d.setText(JVereinPlugin.getI18n().tr(
          "Wollen Sie diese Buchungsart wirklich l�schen?"));
      try
      {
        Boolean choice = (Boolean) d.open();
        if (!choice.booleanValue())
          return;
      }
      catch (Exception e)
      {
        Logger.error(JVereinPlugin.getI18n().tr(
            "Fehler beim L�schen der Buchungsart"), e);
        return;
      }

      b.delete();
      GUI.getStatusBar().setSuccessText(
          JVereinPlugin.getI18n().tr("Buchungsart gel�scht."));
    }
    catch (RemoteException e)
    {
      String fehler = JVereinPlugin.getI18n().tr(
          "Fehler beim L�schen der Buchungsart.");
      GUI.getStatusBar().setErrorText(fehler);
      Logger.error(fehler, e);
    }
  }
}
