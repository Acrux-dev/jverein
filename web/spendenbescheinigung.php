<? include ("frame.inc"); ?>
    <h1>Spendenbescheinigung</h1>
    <p>Mit JVerein k�nnen Spendenbescheinigungen ausgestellt und gespeichert werden. Vorbereitend ist sind 
    	ein oder mehrere <a href="administration_formulare.php">Formulare</a> einzurichten.</p>
    <p>�bersicht �ber die Spendenbescheinigungen:</p>
    <img src='images/Spendenbescheinigungen.jpg' class='screenshot'>
 	<p>Durch einen Klick auf neu �ffnet sich das Spendenbescheinigungs-Bearbeitungsfenster (siehe unten).
		Mit einem Doppelklick auf eine Spendenbescheinigung �ffnet sich das Bearbeitungsfenster (siehe unten). 
		Mit einem Rechtsklick �ffnet sich ein Kontextmen�. Damit k�nnen Spendenbescheinigungen gel�scht 
		werden. Durch einen Klick wird die Spendenbescheinigung im PDF-Format ausgegeben.</p>
	<p>Tipp! In der Mitgliedersuche kann man mit einem Klick auf die rechte Maustaste ein Kontextmen� �ffnen.
	   	Darin den Men�punkt 'Spendenbescheinigung' ausw�hlen. Dann wird das Spendenbescheinigungsformular
	   	mit den Daten des Mitglieds gef�llt.</p>
    <img src='images/Spendenbescheinigung.jpg' class='screenshot'>
   <p>Ab Version 1.5</p>
   <p>Ab Version 1.5 gibt es folgende zus�tzliche Features:</p>
   <ul>
			<li>Spendenbescheinigung f�r Sachspenden</li>
			<li>Automatische Generierung von Spendenbescheinigungen �ber das Mitgliedskonto</li>
	 </ul>
	 <p>Voraussetzungen f�r die automatische Generierung</p>
	 <ul>
	  <li>Administration|Allgemein Daten zum Verein und zu den Spendenbescheinigungen werden gespeichert.</li>
	 	<li>Administration|Ansicht Mitgliedskonto angehakt</li>
	 	<li>Administration|Buchungsarten mindestens eine Buchungsart hat ein H�kchen im Feld "Spende"</li>
	 	<li>Buchung wurde dem Mitgliedskonto und einer Buchungsart mit dem Merkmal Spende zugeordnet.</li> 
    <img src='images/Spendenbescheinigung.png' class='screenshot'>
	<p>Beispiel f�r eine Spendenbescheinigung:</p>
    <img src='images/Formularausgefuellt.jpg' class='screenshot'>
    
    <h2><a name="v21"></a>Spendenbescheinigungen ab Version 2.1</h2>
    <p>Spendenbescheinigungen k�nnen in Form von Einzelbest�tigungen oder 
    Sammelbest�tigungen erzeugt werden. Es sind zwei Formular-Arten 
    (Spendenbescheinigung und Sammelbest�tigung) hierf�r vorgesehen.</p>

    <h3>Einzelbest�tigungen</h3>
    <p>Einzelbest�tigungen k�nnen auf drei Arten erzeugt werden:</p>
    <ul>
        <li>manuell durch Eingabe aller Daten</li>
        <li>aus einem Mitglied / Mitgliedskonto (rechts Klick auf Buchung) 
            heraus f�r eine einzelne Buchung. In diesem Fall werden die 
            Mitgliedsdaten komplett in die Spendenbescheinigung �bernommen, 
            die Buchung bestimmt den Betrag und das Spendendatum.</li>
        <li>Automatische Generierung (siehe unten)</li>
    </ul>

    <h3>Sammelbest�tigungen</h3>
    <p>Sammelbest�tigungen k�nnen auf zwei Arten erzeugt werden:</p>
    <ul>
        <li>aus einem Mitglied / Mitgliedskonto (rechts Klick auf Mitgliedsname) 
            heraus f�r alle Buchungen im Mitgliedskonto. Es werden nur die Buchungen 
            erfasst, die noch auf keiner Spendenbescheinigung oder Sammelbest�tigung 
            ausgewiesen wurden. In diesem Fall werden die Mitgliedsdaten komplett in 
            die Spendenbescheinigung �bernommen, die erste Buchung bestimmt das 
            Spendendatum, der Betrag ist die Summe der Betr�ge aller Buchungen.</li>
        <li>Automatische Generierung (siehe unten)</li>
    </ul>
    <h3>Automatische Generierung von Spendenbescheinigungen</h3>
    <p>In der �bersicht �ber Spendenbescheinigungen k�nnen �ber den Button 
       "neu (automatisch)" Spendenbescheinigungen generiert werden. Hier kommen die 
       Einstellungen zum Tragen. Es werden nur f�r die Mitglieder oder Spender 
       Spendenbescheinigungen erzeugt, die eine vollst�ndige Adresse (Stra�e und 
       PLZ und Ort) eingetragen haben. Au�erdem werden nur die Mitglieder oder 
       Spender erfasst, deren Spendenbetrag >= dem Mindestbetrag in den Einstellungen 
       ist.</p>
    <p>In der �bersicht werden zun�chst alle Namen und Buchungen angezeigt, die 
       schlie�lich als Spendenbescheinigung angelegt werden. Der Typ der 
       Spendenbescheinigungen (Einzel / Sammel) macht sich an der Anzahl Buchungen 
       fest, die erfasst wurden.</p>
    <p>�ber den Button "erstellen" werden Spendenbescheinigungen erzeugt.</p>

    <h3>Spendenbescheinigungen (Liste)</h3>
    <p>In der Liste k�nnen ein oder mehrere Eintr�ge markiert werden. �ber ein 
       Kontextmenu (rechter Mausklick) stehen verschiedene Aktionen zur Verf�gung:</p>
    <ul>
       <li>Drucken (standard)</li>
       <li>Drucken (individuell)</li>
       <li>Duplizieren (nur wenn genau ein Eintrag gew�hlt ist)</li>
       <li>L�schen</li>
    </ul>
    <p>Sind mehrere Eintr�ge markiert, wird die Aktion auf alle markierten Eintr�ge 
       angewendet. Das Drucken beschr�nkt sich darauf, die Dokumente in dem in den 
       Einstellungen angegebenen Verzeichnis zu speichern.</p>
    <p>�ber die Buttons in der Buttonleiste stehen die Erzeugung einer neuen bzw. die 
       automatische Generierung (siehe oben) von Spendenbescheinigungen zur Verf�gung.</p>
    <p>Alle Einstellungen (siehe unten) werden sowohl bei dem Standard-Dokument als 
       auch dem individuellen Dokumenten ber�cksichtigt.</p>

    <h3>Spendenbescheinigung (Einzeldarstellung)</h3>
    <p>In der Einzeldarstellung wird der Ausdruck �ber Buttons ebenfalls angeboten. 
       Im Unterschied zum Druck aus der Liste heraus wird zun�chst der Datei-Dialog 
       mit der Voreinstellung des Spendenbescheinigungsverzeichnisses aus den 
       Einstellungen und dem erzeugten Namen angeboten. Hier kann das Verzeichnis 
       und der Name noch einmal korrigiert werden.</p>
    <p>Der Ausdruck �ber die Buttons funktioniert nur, wenn die Spendenbescheinigung 
       bereits einmal gespeichert wurde. Die Aktionen "neu" und "drucken" direkt 
       hintereinander werden mit einer Fehlermeldung abgewiesen.</p>


  <h2>Weitere Anpassungen</h2>
  <h3>Formulare</h3>
  <p>Vorlagen von Formularen k�nnen nun auch mehrere Seiten umfassen. Formularfelder 
     k�nnen auch auf anderen Seiten als der ersten platziert werden (siehe auch 
     Formularfelder)</p>

  <h3>Formularfelder</h3>
  <p>Formularfelder k�nnen nun auch auf anderen Seiten als nur der ersten Seite 
     platziert werden. Hierzu gibt es die Spalte "Seite", mit der die Seitennummer 
     angegeben wird.</p>
  <p>F�r Spendenbescheinigungen stehen nun erg�nzend folgende zus�tzlichen Felder zur 
     Verf�gung:</p>
  <ul>
     <li>Spendenzeitraum Datum der ersten und letzten Buchung auf der 
         Sammelbest�tigung</li>
     <li>Buchungsliste<br>
         Alle Buchungen als Liste formatiert:
         <pre>
      Datum Betrag  Verzicht  Zuwendungsart
      </pre>
      F�r eine korrekte Formatierung sollte eine Schriftart mit fester Zeichenbereite 
      gew�hlt werden!</li>
  </ul>
  <h3>Einstellungen</h3>
  <p>Die Einstellungen wurden um ein paar Felder erweitert und einige Felder wurden 
     verl�ngert:</p>
  <ul>
     <li>Lang-Name<br>
         Langer Name des Vereins, bis 100 Zeichen</li>
     <li>Beg�nstigterZweck<br>
         Erweitert auf 100 Zeichen<li>
     <li>Stra�e<br>
         Erweitert auf 50 Zeichen</li>
     <li>Ort<br>
         Erweitert auf 50 Zeichen</li>
     <li>Dateinamenmuster Spende<br>
         F�r die Generierung von Dokumenten mit Mitglieds-Bezug. Zun�chst nur f�r 
         Spendenbescheinigungen genutzt, k�nte aber auch f�r Kontoauszug des 
         Mitgliedskontos oder den Personalbogen genutzt werden.</li>
     <li>Mindestbetrag f�r Spendenbescheinigungen<br>
         Allgemeine Einstellung ab welchem Betrag eine Spendenbescheinigung erstellt 
         werden soll. Diese Einstellung kommt bei der automatischen Generierung von 
         Spendebescheinigungen zum Tragen. Bei der Erzeugung einer 
         Spendenbescheinigung aus einem Mitglkiedskonto heraus, wird diese 
         Einstellung nicht beachtet.</li>
     <li>Verzeichnis f�r Spendenbescheinigungen<br>
         Um ein fl�ssiges Erzeugen von mehreren Dokumenten zu erm�glichen, kann hier 
         das Verzeichnis f�r die PDF-Dateien festgelegt werden. Wenn aus der Liste der 
         Spendenbescheinigungen heraus die Dokumente generiert werden, werden sie in 
         diese Verzeichnis geschrieben. Das Verzeichnis wird auch vorbelegt, wenn 
         eine Dokumentenerstellung aus der Detailansicht Spendenbescheinigung erfolgt.
         Hier wird jedoch der Dateidialog angeboten.</li>
     <li>Drucke Buchungsart<br>
         Ist das H�kchen gesetzt, wird in der Buchungsliste nicht der Zweck aus der 
         Buchung, sondern die der Buchung zugewiesene Buchungsart verwendet. Bei 
         sprechenden Namen eine einheitlichere Darstellung.</li>
     </ul>
    

<? include ("footer.inc"); ?>

