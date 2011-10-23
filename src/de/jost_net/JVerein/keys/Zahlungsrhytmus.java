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
package de.jost_net.JVerein.keys;

import java.util.ArrayList;

import de.jost_net.JVerein.JVereinPlugin;

/**
 * Schl�ssel Zahlungsrhytmus
 */
public class Zahlungsrhytmus
{
  public static final int JAEHRLICH = 12;

  public static final int HALBJAEHRLICH = 6;

  public static final int VIERTELJAEHRLICH = 3;

  public static final int MONATLICH = 1;

  private int zahlungsrhytmus;

  public Zahlungsrhytmus(int key)
  {
    this.zahlungsrhytmus = key;
  }

  public int getKey()
  {
    return zahlungsrhytmus;
  }

  public String getText()
  {
    return get(zahlungsrhytmus);
  }

  public static String get(int key)
  {
    switch (key)
    {
      case Zahlungsrhytmus.JAEHRLICH:
        return JVereinPlugin.getI18n().tr("j�hrlich");
      case Zahlungsrhytmus.HALBJAEHRLICH:
        return JVereinPlugin.getI18n().tr("halbj�hrlich");
      case Zahlungsrhytmus.VIERTELJAEHRLICH:
        return JVereinPlugin.getI18n().tr("viertelj�hrlich");
      case Zahlungsrhytmus.MONATLICH:
        return JVereinPlugin.getI18n().tr("monatlich");
      default:
        return null;
    }
  }

  public static ArrayList<Zahlungsrhytmus> getArray()
  {
    ArrayList<Zahlungsrhytmus> ret = new ArrayList<Zahlungsrhytmus>();
    ret.add(new Zahlungsrhytmus(JAEHRLICH));
    ret.add(new Zahlungsrhytmus(HALBJAEHRLICH));
    ret.add(new Zahlungsrhytmus(VIERTELJAEHRLICH));
    ret.add(new Zahlungsrhytmus(MONATLICH));
    return ret;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj instanceof Zahlungsrhytmus)
    {
      Zahlungsrhytmus v = (Zahlungsrhytmus) obj;
      return (getKey() == v.getKey());
    }
    return false;
  }

  @Override
  public int hashCode()
  {
    return zahlungsrhytmus;
  }

  @Override
  public String toString()
  {
    return get(zahlungsrhytmus);
  }
}
