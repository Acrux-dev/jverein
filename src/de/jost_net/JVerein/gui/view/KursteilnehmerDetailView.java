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
package de.jost_net.JVerein.gui.view;

import de.jost_net.JVerein.JVereinPlugin;
import de.jost_net.JVerein.gui.action.DokumentationAction;
import de.jost_net.JVerein.gui.action.KursteilnehmerDeleteAction;
import de.jost_net.JVerein.gui.action.KursteilnehmerDetailAction;
import de.jost_net.JVerein.gui.control.KursteilnehmerControl;
import de.willuhn.jameica.gui.AbstractView;
import de.willuhn.jameica.gui.Action;
import de.willuhn.jameica.gui.GUI;
import de.willuhn.jameica.gui.parts.ButtonArea;
import de.willuhn.jameica.gui.util.LabelGroup;

public class KursteilnehmerDetailView extends AbstractView
{

  @Override
  public void bind() throws Exception
  {
    GUI.getView().setTitle(JVereinPlugin.getI18n().tr("Kursteilnehmer"));

    final KursteilnehmerControl control = new KursteilnehmerControl(this);

    LabelGroup grGrund = new LabelGroup(getParent(), JVereinPlugin.getI18n()
        .tr("Daten f�r die Abbuchung"));
    grGrund.getComposite().setSize(290, 190);
    grGrund.addLabelPair(JVereinPlugin.getI18n().tr("Name"),
        control.getName(true));
    grGrund.addLabelPair(JVereinPlugin.getI18n().tr("Verwendungszweck 1"),
        control.getVZweck1());
    grGrund.addLabelPair(JVereinPlugin.getI18n().tr("Verwendungszweck 2"),
        control.getVZweck2());
    grGrund.addLabelPair(JVereinPlugin.getI18n().tr("BLZ"), control.getBlz());
    grGrund.addLabelPair(JVereinPlugin.getI18n().tr("Konto"),
        control.getKonto());
    grGrund.addLabelPair(JVereinPlugin.getI18n().tr("Betrag"),
        control.getBetrag());

    LabelGroup grStatistik = new LabelGroup(getParent(), JVereinPlugin
        .getI18n().tr("Statistik"));
    grStatistik.getComposite().setSize(290, 190);
    grStatistik.addLabelPair(JVereinPlugin.getI18n().tr("Geburtsdatum"),
        control.getGeburtsdatum());
    grStatistik.addLabelPair(JVereinPlugin.getI18n().tr("Geschlecht"),
        control.getGeschlecht());

    ButtonArea buttons = new ButtonArea();
    buttons.addButton(JVereinPlugin.getI18n().tr("Hilfe"),
        new DokumentationAction(), DokumentationUtil.KURSTEILNEHMER, false,
        "help-browser.png");
    buttons.addButton(JVereinPlugin.getI18n().tr("neu"),
        new KursteilnehmerDetailAction(), null, false, "document-new.png");
    buttons.addButton(JVereinPlugin.getI18n().tr("l�schen"),
        new KursteilnehmerDeleteAction(), control.getCurrentObject(), false,
        "user-trash.png");
    buttons.addButton(JVereinPlugin.getI18n().tr("speichern"), new Action()
    {
      public void handleAction(Object context)
      {
        control.handleStore();
      }
    }, null, true, "document-save.png");
    buttons.paint(this.getParent());
  }

  // TODO getHelp()

}
