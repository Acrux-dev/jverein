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
package de.jost_net.JVerein.rmi;

import java.rmi.RemoteException;

import de.willuhn.datasource.rmi.DBObject;

/**
 * LeseFelder sind virtuelle Datenbank-Felder. Sie werden mit Hilfe eines
 * Scriptes berechnet und sind daher schreibgesch�tzt (-> nur lesbar).
 * 
 * Jedes Feld hat eine Bezeichnung (Name), �ber die auf das Feld sp�ter
 * zugegriffen werden kann und Java-Code, das den Inhalt des Feld beschreibt.
 * 
 * @author Julian
 * 
 */
public interface LeseFeld extends DBObject
{
  public String getBezeichnung() throws RemoteException;

  public void setBezeichnung(String name) throws RemoteException;

  public String getScript() throws RemoteException;

  public void setScript(String script) throws RemoteException;

}
