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
package de.jost_net.JVerein.server;

import java.rmi.RemoteException;

import de.jost_net.JVerein.JVereinPlugin;
import de.jost_net.JVerein.rmi.Beitragsgruppe;
import de.jost_net.JVerein.rmi.Buchungsart;
import de.willuhn.datasource.db.AbstractDBObject;
import de.willuhn.logging.Logger;
import de.willuhn.util.ApplicationException;

public class BeitragsgruppeImpl extends AbstractDBObject implements
    Beitragsgruppe
{

  private static final long serialVersionUID = 1L;

  public BeitragsgruppeImpl() throws RemoteException
  {
    super();
  }

  @Override
  protected String getTableName()
  {
    return "beitragsgruppe";
  }

  @Override
  public String getPrimaryAttribute()
  {
    return "id";
  }

  @Override
  protected void deleteCheck()
  {
    //
  }

  @Override
  protected void insertCheck() throws ApplicationException
  {
    try
    {
      if (getBezeichnung() == null || getBezeichnung().length() == 0)
      {
        throw new ApplicationException(JVereinPlugin.getI18n().tr(
            "Bitte Bezeichnung eingeben"));
      }
      if (getBetrag() < 0)
      {
        throw new ApplicationException(JVereinPlugin.getI18n().tr(
            "Betrag nicht g�ltig"));
      }
    }
    catch (RemoteException e)
    {
      Logger.error("insert check of mitglied failed", e);
      throw new ApplicationException(JVereinPlugin.getI18n().tr(
          "Mitglied kann nicht gespeichert werden. Siehe system log"));
    }
  }

  @Override
  protected void updateCheck() throws ApplicationException
  {
    insertCheck();
  }

  @Override
  protected Class<?> getForeignObject(String arg0)
  {
    if (arg0.equals("buchungsart"))
    {
      return Buchungsart.class;
    }
    return null;
  }

  public String getBezeichnung() throws RemoteException
  {
    return (String) getAttribute("bezeichnung");
  }

  public void setBezeichnung(String bezeichnung) throws RemoteException
  {
    setAttribute("bezeichnung", bezeichnung);
  }

  public double getBetrag() throws RemoteException
  {
    Double d = (Double) getAttribute("betrag");
    if (d == null)
    {
      return 0;
    }
    return d.doubleValue();
  }

  public void setBetrag(double d) throws RemoteException
  {
    setAttribute("betrag", new Double(d));
  }

  public int getBeitragsArt() throws RemoteException
  {
    Integer i = (Integer) getAttribute("beitragsart");
    if (i == null)
    {
      return 0;
    }
    return i.intValue();
  }

  public void setBeitragsArt(int art) throws RemoteException
  {
    setAttribute("beitragsart", art);
  }

  public double getArbeitseinsatzStunden() throws RemoteException
  {
    Double d = (Double) getAttribute("arbeitseinsatzstunden");
    if (d == null)
    {
      return 0;
    }
    return d.doubleValue();
  }

  public void setArbeitseinsatzStunden(double arbeitseinsatzStunden)
      throws RemoteException
  {
    setAttribute("arbeitseinsatzstunden", new Double(arbeitseinsatzStunden));
  }

  public double getArbeitseinsatzBetrag() throws RemoteException
  {
    Double d = (Double) getAttribute("arbeitseinsatzbetrag");
    if (d == null)
    {
      return 0;
    }
    return d.doubleValue();
  }

  public void setBuchungsart(Buchungsart buchungsart) throws RemoteException
  {
    setAttribute("buchungsart", buchungsart);
  }

  public Buchungsart getBuchungsart() throws RemoteException
  {
    return (Buchungsart) getAttribute("buchungsart");
  }

  public void setArbeitseinsatzBetrag(double arbeitseinsatzBetrag)
      throws RemoteException
  {
    setAttribute("arbeitseinsatzbetrag", new Double(arbeitseinsatzBetrag));
  }

  @Override
  public Object getAttribute(String fieldName) throws RemoteException
  {
    return super.getAttribute(fieldName);
  }
}
