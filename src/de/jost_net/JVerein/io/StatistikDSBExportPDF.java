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

package de.jost_net.JVerein.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;

import de.jost_net.JVerein.Einstellungen;
import de.jost_net.JVerein.JVereinPlugin;
import de.jost_net.JVerein.gui.view.StatistikDSBView;
import de.jost_net.JVerein.rmi.Mitglied;
import de.jost_net.JVerein.util.JVDateFormatTTMMJJJJ;

public class StatistikDSBExportPDF extends StatistikDSBExport
{

  private FileOutputStream fos;

  private Reporter reporter;

  private int anz;

  @Override
  public String getName()
  {
    return JVereinPlugin.getI18n().tr("Statistik DSB PDF-Export");
  }

  @Override
  public IOFormat[] getIOFormats(Class<?> objectType)
  {
    if (objectType != StatistikDSBView.class)
    {
      return null;
    }
    IOFormat f = new IOFormat()
    {

      @Override
      public String getName()
      {
        return StatistikDSBExportPDF.this.getName();
      }

      /**
       * @see de.willuhn.jameica.hbci.io.IOFormat#getFileExtensions()
       */
      @Override
      public String[] getFileExtensions()
      {
        return new String[] { "*.pdf"};
      }
    };
    return new IOFormat[] { f};
  }

  @Override
  public String getDateiname()
  {
    return JVereinPlugin.getI18n().tr("statistikdsb");
  }

  @Override
  protected void open() throws DocumentException, FileNotFoundException
  {
    fos = new FileOutputStream(file);
    reporter = new Reporter(fos, JVereinPlugin.getI18n().tr(
        "Statistik DSB, Stichtag: {0}",
        new JVDateFormatTTMMJJJJ().format(stichtag) + ""), "", 3);
    reporter.addHeaderColumn(JVereinPlugin.getI18n().tr("Jahrgang"),
        Element.ALIGN_CENTER, 50, BaseColor.LIGHT_GRAY);
    reporter.addHeaderColumn(JVereinPlugin.getI18n().tr("Gesamt"),
        Element.ALIGN_CENTER, 50, BaseColor.LIGHT_GRAY);
    reporter.addHeaderColumn(JVereinPlugin.getI18n().tr("m�nnlich"),
        Element.ALIGN_CENTER, 50, BaseColor.LIGHT_GRAY);
    reporter.addHeaderColumn(JVereinPlugin.getI18n().tr("weiblich"),
        Element.ALIGN_CENTER, 50, BaseColor.LIGHT_GRAY);
    reporter.createHeader(50, Element.ALIGN_LEFT);
    int summegesamt = 0;
    int summemaennlich = 0;
    int summeweiblich = 0;
    for (String key : statistik.keySet())
    {
      reporter.addColumn(key, Element.ALIGN_CENTER);
      StatistikDSBJahrgang dsbj = statistik.get(key);
      reporter.addColumn(
          Einstellungen.INTFORMAT.format(dsbj.getAnzahlgesamt()),
          Element.ALIGN_RIGHT);
      reporter.addColumn(
          Einstellungen.INTFORMAT.format(dsbj.getAnzahlmaennlich()),
          Element.ALIGN_RIGHT);
      reporter.addColumn(
          Einstellungen.INTFORMAT.format(dsbj.getAnzahlweiblich()),
          Element.ALIGN_RIGHT);
      summegesamt += dsbj.getAnzahlgesamt();
      summemaennlich += dsbj.getAnzahlmaennlich();
      summeweiblich += dsbj.getAnzahlweiblich();
    }
    reporter.addColumn("Summe", Element.ALIGN_CENTER);
    reporter.addColumn(Einstellungen.INTFORMAT.format(summegesamt),
        Element.ALIGN_RIGHT);
    reporter.addColumn(Einstellungen.INTFORMAT.format(summemaennlich),
        Element.ALIGN_RIGHT);
    reporter.addColumn(Einstellungen.INTFORMAT.format(summeweiblich),
        Element.ALIGN_RIGHT);
    reporter.closeTable();

  }

  @Override
  protected void close() throws IOException, DocumentException
  {
    reporter.close();
    fos.close();
  }
}