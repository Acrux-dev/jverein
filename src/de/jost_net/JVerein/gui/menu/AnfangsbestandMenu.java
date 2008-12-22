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
 * Revision 1.1  2008/05/22 06:50:30  jost
 * Buchführung
 *
 **********************************************************************/
package de.jost_net.JVerein.gui.menu;

import de.jost_net.JVerein.gui.action.AnfangsbestandDeleteAction;
import de.willuhn.jameica.gui.parts.CheckedContextMenuItem;
import de.willuhn.jameica.gui.parts.ContextMenu;

/**
 * Kontext-Menu zu den Anfangsbest�nden.
 */
public class AnfangsbestandMenu extends ContextMenu
{

  /**
   * Erzeugt ein Kontext-Menu fuer die Liste der Zusatzbetr�ge.
   */
  public AnfangsbestandMenu()
  {
    addItem(new CheckedContextMenuItem("L�schen...",
        new AnfangsbestandDeleteAction(),"user-trash.png"));
  }
}
