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
package de.jost_net.JVerein.rmi;

import java.rmi.RemoteException;

import de.willuhn.datasource.rmi.DBObject;

public interface MailEmpfaenger extends DBObject
{
  /**
   * ID der zugeh�rigen Mail
   */
  public Mail getMail() throws RemoteException;

  /**
   * ID der zugeh�rigen Mail
   */
  public void setMail(Mail mail) throws RemoteException;

  /**
   * "Hart kodierte"-Mailadresse
   */
  public String getAdresse() throws RemoteException;

  /**
   * "Hart kodierte"-Mailadresse
   */

  public void setAdresse(String adresse) throws RemoteException;

  /**
   * Mitglied ist Mail-Empf�nger
   */
  public Mitglied getMitglied() throws RemoteException;

  /**
   * Mitglied ist Mail-Empf�nger
   */

  public void setMitglied(Mitglied mitglied) throws RemoteException;

  /**
   * Gibt entweder die Mailadresse des Mitgliedes oder die "nackte" Adresse
   * zur�ck
   */
  public String getMailAdresse() throws RemoteException;

}
