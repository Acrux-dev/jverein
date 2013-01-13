/**********************************************************************
 * $Source$
 * $Revision$
 * $Date$
 * $Author$
 *
 * Copyright (c) by Ralf Neumaier
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
package de.jost_net.JVerein.util;

import java.math.BigInteger;
import java.util.HashMap;

import de.jost_net.JVerein.JVereinPlugin;
import de.jost_net.JVerein.SEPA.Countries.AT;
import de.jost_net.JVerein.SEPA.Countries.CH;
import de.jost_net.JVerein.SEPA.Countries.DE;
import de.jost_net.JVerein.SEPA.Countries.ISEPACountry;
import de.willuhn.logging.Logger;

/**
 * 
 * @author rn und Heiner Jostkleigrewe
 * 
 */
public class IbanBicCalc
{
  private static final String[] ALPHABET = new String[] { "A", "B", "C", "D",
      "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
      "S", "T", "U", "V", "W", "X", "Y", "Z" };

  private static HashMap<String, ISEPACountry> countries = new HashMap<String, ISEPACountry>();

  static
  {
    ISEPACountry de = new DE();
    countries.put(de.getCountry(), de);
    ISEPACountry at = new AT();
    countries.put(at.getCountry(), at);
    ISEPACountry ch = new CH();
    countries.put(ch.getCountry(), ch);
  }

  /**
   * 
   * Vor der Erstellung der pers�nlichen internationalen Bankkontonummer f�r
   * jeden Kontoinhaber wird von der Bank die Pr�fziffer elektronisch berechnet.
   * Dazu werden in Deutschland die achtstellige Bankleitzahl, die zehnstellige
   * Kontonummer und die zweistellige, alphanumerische L�nderkennung ben�tigt.
   * Kontonummern mit weniger als zehn Stellen werden mit f�hrenden Nullen
   * aufgef�llt.
   * 
   * Die Berechnung erfolgt in mehreren Schritten. Zuerst wird die L�nderkennung
   * um zwei Nullen erg�nzt. Danach wird aus Kontonummer und Bankleitzahl die
   * BBAN kreiert. Also beispielsweise Bankleitzahl 70090100 und Kontonummer
   * 1234567890 ergeben die BBAN 700901001234567890.
   * 
   * Anschlie�end werden die beiden Alpha-Zeichen der L�nderkennung sowie
   * weitere eventuell in der Kontonummer enthaltene Buchstaben in rein
   * numerische Ausdr�cke umgewandelt. Die Grundlage f�r die Zahlen, die aus den
   * Buchstaben gebildet werden sollen, bildet ihre Position der jeweiligen
   * Alpha-Zeichen im lateinischen Alphabet. Zu diesem Zahlenwert wird 9
   * addiert. Die Summe ergibt die Zahl, die den jeweiligen Buchstaben ersetzen
   * soll. Dementsprechend steht f�r A (Position 1+9) die Zahl 10, f�r D
   * (Position 4+9) die 13 und f�r E (Position 5+9) die 14. Der L�nderkennung DE
   * entspricht also die Ziffernfolge 1314.
   * 
   * Im n�chsten Schritt wird diese Ziffernfolge, erg�nzt um die beiden Nullen,
   * an die BBAN geh�ngt. Hieraus ergibt sich 700901001234567890131400. Diese
   * bei deutschen Konten immer 24-stellige Zahl wird anschlie�end Modulo 97
   * genommen. Das hei�t, es wird der Rest berechnet, der sich bei der Teilung
   * der 24-stelligen Zahl durch 97 ergibt. Das ist f�r dieses Beispiel 90.
   * Dieses Ergebnis wird von der nach ISO-Standard festgelegten Zahl 98
   * subtrahiert. Ist das Resultat, wie in diesem Beispiel, kleiner als Zehn, so
   * wird der Zahl eine Null vorangestellt, sodass sich wieder ein zweistelliger
   * Wert ergibt. Somit ist die errechnete Pr�fziffer 08. Aus der L�nderkennung,
   * der zweistelligen Pr�fsumme und der BBAN wird nun die IBAN generiert. Die
   * ermittelte IBAN lautet in unserem Beispiel: DE08700901001234567890.
   * 
   * D = 4.stelle im Alphabet + 9 = 13 E = 5.stelle im Alphabet + 9 = 14
   * 
   * -> DE = 1314
   * 
   * L�nderkennung um 2 Nullen erg�nzen
   * 
   * -> 131400
   * 
   * 1. Konstante zur Berechnung; Modulo 97
   * 
   * 700901001234567890131400 % 97
   * 
   * -> 90
   * 
   * 2. Konstante zur Berechnung: 98 - 90 = 8 -> erg�nzt um f�hrende 0 -> 08
   * 
   * DE08700901001234567890131400
   * 
   */
  public static String createIban(String kontoNr, String blz, String landKuerzel)
      throws IBANException
  {
    if (kontoNr == null || kontoNr.trim().length() == 0 || blz == null
        || blz.trim().length() == 0)
    {
      return "";
    }

    ISEPACountry country = getSEPACountry(landKuerzel);
    String laenderKennung = getLandKennung(landKuerzel);

    if (blz.length() != country.getBankIdentifierLength())
    {
      throw new IBANException("Bankleitzahl hat falsche L�nge f�r "
          + country.getBezeichnung());
    }

    if (kontoNr.length() > country.getAccountLength())
    {
      throw new IBANException("Kontonummer zu lang f�r "
          + country.getBezeichnung());
    }
    StringBuilder accountString = new StringBuilder();
    for (int i = 0; i < country.getAccountLength() - kontoNr.length(); i++)
    {
      accountString.append("0");
    }
    accountString.append(kontoNr);

    return landKuerzel
        + getPruefziffer(blz, accountString.toString(), laenderKennung) + blz
        + accountString.toString();
  }

  private static ISEPACountry getSEPACountry(String landkuerzel)
      throws IBANException
  {
    if (landkuerzel == null || landkuerzel.length() != 2)
    {
      throw new IBANException("Fehler ! L�nderk�rzel fehlt");
    }
    ISEPACountry country = countries.get(landkuerzel);
    if (country == null)
    {
      throw new IBANException("Ung�ltiges Land: " + landkuerzel);
    }
    return country;
  }

  private static String getPruefziffer(String blz, String konto,
      String laenderkennung) throws IBANException
  {
    BigInteger bi = null;
    try
    {
      bi = new BigInteger(blz + konto + laenderkennung);
    }
    catch (NumberFormatException e)
    {
      String error = JVereinPlugin.getI18n().tr(
          "Ung�ltige Bankverbindung: {0} {1} {2}", blz, konto, laenderkennung);
      Logger.error(error);
      throw new IBANException(error);
    }
    BigInteger modulo = bi.mod(BigInteger.valueOf(97));
    String pruefZiffer = String.valueOf(98 - modulo.longValue());

    if (pruefZiffer.length() < 2)
    {
      pruefZiffer = "0" + pruefZiffer;
    }
    return pruefZiffer;
  }

  private static final String getLandKennung(String landKuerzel)
  {
    int[] landKnzAsNumber = new int[2];

    for (int i = 0; i < 2; i++)
    {
      for (int j = 0; j < ALPHABET.length; j++)
      {
        if (ALPHABET[j].toUpperCase().equals(
            String.valueOf(landKuerzel.charAt(i)).toUpperCase()))
        {
          landKnzAsNumber[i] = j + 10;
          break;
        }
      }
    }

    return String.valueOf(landKnzAsNumber[0])
        + String.valueOf(landKnzAsNumber[1]) + "00";
  }

  public static boolean isValidIBAN(String iban) throws IBANException
  {
    if (iban == null)
    {
      throw new IBANException("IBAN ist leer");
    }
    if (iban.length() < 4)
    {
      throw new IBANException(
          "Ung�ltige IBAN. Landeskennung und/oder Pr�fziffer fehlen");
    }
    String landkuerzel = iban.substring(0, 2);
    ISEPACountry country = getSEPACountry(landkuerzel);
    // String pruefziffer = iban.substring(3, 4);
    int laebankid = country.getBankIdentifierLength();
    int laeaccount = country.getAccountLength();
    int laeiban = 4 + laebankid + laeaccount;
    if (iban.length() != laeiban)
    {
      throw new IBANException("Ung�ltige IBAN. Vorgeschrieben sind " + laeiban
          + " f�r " + country.getBezeichnung());
    }
    return true;
  }
}