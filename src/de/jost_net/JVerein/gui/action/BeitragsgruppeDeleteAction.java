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
package de.jost_net.JVerein.gui.action;

import java.rmi.RemoteException;

import de.jost_net.JVerein.rmi.Beitragsgruppe;
import de.willuhn.jameica.gui.Action;
import de.willuhn.jameica.gui.GUI;
import de.willuhn.jameica.gui.dialogs.YesNoDialog;
import de.willuhn.logging.Logger;
import de.willuhn.util.ApplicationException;

/**
 * Loeschen einer Beitragsgruppe
 */
public class BeitragsgruppeDeleteAction implements Action
{
  public void handleAction(Object context) throws ApplicationException
  {
    if (context == null || !(context instanceof Beitragsgruppe))
    {
      throw new ApplicationException("Keine Beitragsgruppe ausgew�hlt");
    }
    try
    {
      Beitragsgruppe bg = (Beitragsgruppe) context;
      if (bg.isNewObject())
      {
        return;
      }
      YesNoDialog d = new YesNoDialog(YesNoDialog.POSITION_CENTER);
      d.setTitle("Beitragsgruppe l�schen");
      d.setText("Wollen Sie diese Beitragsgruppe wirklich l�schen?");

      try
      {
        Boolean choice = (Boolean) d.open();
        if (!choice.booleanValue())
          return;
      }
      catch (Exception e)
      {
        Logger.error("Fehler beim L�schen der Beitragsgruppe", e);
        return;
      }
      bg.delete();
      GUI.getStatusBar().setSuccessText("Beitragsgruppe gel�scht.");
    }
    catch (RemoteException e)
    {
      String fehler = "Fehler beim L�schen der Beitragsgruppe";
      GUI.getStatusBar().setErrorText(fehler);
      Logger.error(fehler, e);
    }
  }
}
