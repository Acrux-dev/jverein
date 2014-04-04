/**********************************************************************
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

package de.jost_net.JVerein.gui.dialogs;

import java.rmi.RemoteException;

import org.eclipse.swt.widgets.Composite;

import de.jost_net.JVerein.Einstellungen;
import de.jost_net.JVerein.util.JVDateFormatTTMMJJJJ;
import de.willuhn.datasource.rmi.DBIterator;
import de.willuhn.jameica.gui.Action;
import de.willuhn.jameica.gui.dialogs.AbstractDialog;
import de.willuhn.jameica.gui.formatter.CurrencyFormatter;
import de.willuhn.jameica.gui.formatter.DateFormatter;
import de.willuhn.jameica.gui.parts.ButtonArea;
import de.willuhn.jameica.gui.parts.TablePart;
import de.willuhn.jameica.hbci.rmi.SepaSammelUeberweisung;
import de.willuhn.jameica.system.OperationCanceledException;
import de.willuhn.util.ApplicationException;

/**
 * Ein Dialog, ueber den man eine Sammel�berweisung zur �bernahme zur
 * Splitbuchung
 * */
public class SammelueberweisungAuswahlDialog extends
    AbstractDialog<SepaSammelUeberweisung>
{

  private SepaSammelUeberweisung selected = null;

  private TablePart sammelueberweisung;

  public SammelueberweisungAuswahlDialog(int position)
  {
    super(position);

    setTitle("Sammel�berweisung ausw�hlen");
    setSize(650, 350);
  }

  @Override
  protected void paint(Composite parent) throws Exception
  {
    this.getSammelueberweisungen().paint(parent);
    ButtonArea b = new ButtonArea();
    b.addButton("abbrechen", new Action()
    {

      @Override
      public void handleAction(Object context)
      {
        throw new OperationCanceledException();
      }
    });
    b.paint(parent);
  }

  @Override
  protected SepaSammelUeberweisung getData() throws Exception
  {
    return this.selected;
  }

  private TablePart getSammelueberweisungen() throws RemoteException
  {
    if (this.sammelueberweisung != null)
    {
      return this.sammelueberweisung;
    }
    DBIterator sue = Einstellungen.getHibiscusDBService().createList(
        SepaSammelUeberweisung.class);
    this.sammelueberweisung = new TablePart(sue, new Action()
    {
      @Override
      public void handleAction(Object context) throws ApplicationException
      {
        selected = (SepaSammelUeberweisung) context;
        close();
      }
    });
    this.sammelueberweisung.addColumn("Termin", "termin", new DateFormatter(
        new JVDateFormatTTMMJJJJ()));
    this.sammelueberweisung.addColumn("Bezeichnung", "bezeichnung");
    this.sammelueberweisung.addColumn("Summe", "summe", new CurrencyFormatter(
        "", Einstellungen.DECIMALFORMAT));
    return this.sammelueberweisung;
  }
}
