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
 * Revision 1.1  2010-11-17 04:50:13  jost
 * Erster Code zum Thema Arbeitseinsatz
 *
 **********************************************************************/
package de.jost_net.JVerein.gui.menu;

import de.jost_net.JVerein.JVereinPlugin;
import de.jost_net.JVerein.gui.action.ArbeitseinsatzDeleteAction;
import de.willuhn.jameica.gui.parts.CheckedContextMenuItem;
import de.willuhn.jameica.gui.parts.ContextMenu;

/**
 * Kontext-Menu zu den Arbeitseins�tzen.
 */
public class ArbeitseinsatzMenu extends ContextMenu
{

  /**
   * Erzeugt ein Kontext-Menu fuer die Arbeitseins�tze.
   */
  public ArbeitseinsatzMenu()
  {
    addItem(new CheckedContextMenuItem(
        JVereinPlugin.getI18n().tr("l�schen..."),
        new ArbeitseinsatzDeleteAction(), "user-trash.png"));
  }
}
