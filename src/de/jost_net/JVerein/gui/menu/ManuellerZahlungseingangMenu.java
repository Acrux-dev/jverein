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
package de.jost_net.JVerein.gui.menu;

import de.jost_net.JVerein.gui.action.ManuellerZahlungseingangDatumL�schenAction;
import de.jost_net.JVerein.gui.action.ManuellerZahlungseingangDatumSetzenAction;
import de.jost_net.JVerein.gui.action.ManuellerZahlungseingangDeleteAction;
import de.willuhn.jameica.gui.parts.CheckedContextMenuItem;
import de.willuhn.jameica.gui.parts.ContextMenu;
import de.willuhn.jameica.gui.parts.TablePart;

/**
 * Kontext-Menu zu den ManuellenZahlungseing�ngen.
 */
public class ManuellerZahlungseingangMenu extends ContextMenu
{

  /**
   * Erzeugt ein Kontext-Menu fuer die Liste der ManuellenZahlungseing�nge.
   */
  public ManuellerZahlungseingangMenu(TablePart table)
  {
    addItem(new CheckedContextMenuItem("Zahlungseingangsdatum setzen ...",
        new ManuellerZahlungseingangDatumSetzenAction(table)));
    addItem(new CheckedContextMenuItem("Zahlungseingangsdatum l�schen ...",
        new ManuellerZahlungseingangDatumL�schenAction(table)));
    addItem(new CheckedContextMenuItem("L�schen...",
        new ManuellerZahlungseingangDeleteAction(table)));
  }
}
