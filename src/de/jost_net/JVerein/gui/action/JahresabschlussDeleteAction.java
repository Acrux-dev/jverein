/**********************************************************************
 * $Source$
 * $Revision$
 * $Date$
 * $Author$
 *
 * Copyright (c) by Heiner Jostkleigrewe
 * This program is free software: you can redistribute it and/or modify it under the terms of the 
 * GNU General Public License as published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without 
 *  even the implied warranty of  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See 
 *  the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this program.  If not, 
 * see <http://www.gnu.org/licenses/>.
 * 
 * heiner@jverein.de
 * www.jverein.de
 **********************************************************************/
package de.jost_net.JVerein.gui.action;

import java.rmi.RemoteException;

import de.jost_net.JVerein.Einstellungen;
import de.jost_net.JVerein.JVereinPlugin;
import de.jost_net.JVerein.rmi.Anfangsbestand;
import de.jost_net.JVerein.rmi.Jahresabschluss;
import de.jost_net.JVerein.util.Datum;
import de.willuhn.datasource.rmi.DBIterator;
import de.willuhn.jameica.gui.Action;
import de.willuhn.jameica.gui.GUI;
import de.willuhn.jameica.gui.dialogs.YesNoDialog;
import de.willuhn.jameica.gui.parts.TablePart;
import de.willuhn.logging.Logger;
import de.willuhn.util.ApplicationException;

/**
 * L�schen eines Jahresabschlusses
 */
public class JahresabschlussDeleteAction implements Action
{
  public void handleAction(Object context) throws ApplicationException
  {
    if (context instanceof TablePart)
    {
      TablePart tp = (TablePart) context;
      context = tp.getSelection();
    }
    if (context == null || !(context instanceof Jahresabschluss))
    {
      throw new ApplicationException(JVereinPlugin.getI18n().tr(
          "Keinen Jahresabschluss ausgew�hlt"));
    }
    try
    {
      Jahresabschluss a = (Jahresabschluss) context;
      if (a.isNewObject())
      {
        return;
      }
      YesNoDialog d = new YesNoDialog(YesNoDialog.POSITION_CENTER);
      d.setTitle(JVereinPlugin.getI18n().tr("Jahresabschluss l�schen"));
      d.setText(JVereinPlugin.getI18n().tr(
          "Wollen Sie diesen Jahresabschluss wirklich l�schen?"));

      try
      {
        Boolean choice = (Boolean) d.open();
        if (!choice.booleanValue())
        {
          return;
        }
      }
      catch (Exception e)
      {
        Logger.error(
            JVereinPlugin.getI18n().tr(
                "Fehler beim L�schen des Jahresabschlusses"), e);
        return;
      }
      a.delete();
      DBIterator it = Einstellungen.getDBService().createList(
          Anfangsbestand.class);
      it.addFilter("datum = ?", new Object[] { Datum.addTage(a.getBis(), 1) });
      while (it.hasNext())
      {
        Anfangsbestand a1 = (Anfangsbestand) it.next();
        Anfangsbestand a2 = (Anfangsbestand) Einstellungen.getDBService()
            .createObject(Anfangsbestand.class, a1.getID());
        a2.delete();
      }
      GUI.getStatusBar().setSuccessText(
          JVereinPlugin.getI18n().tr("Jahresabschluss gel�scht."));
    }
    catch (RemoteException e)
    {
      String fehler = JVereinPlugin.getI18n().tr(
          "Fehler beim L�schen des Jahresabschlusses");
      GUI.getStatusBar().setErrorText(fehler);
      Logger.error(fehler, e);
    }
  }
}
