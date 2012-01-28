<? include ("frame.inc"); ?>
    <h1>Administration: Einstellungen</h1>
    <h3>Allgemein</h3>
	  <img src='images/Einstellungenallgemein.png' class='screenshot'>
    <p>Name und Anschrift des Vereins sowie die Bankverbindung f�r die Abbuchung k�nnen gespeichert 
    werden.sind Pflichtangaben.</p>
	  <p>Name und Bankverbindung werden f�r die Erstellung der DTAUS-Datei f�r die Abbuchung zwingend
	  ben�tigt. Die weiteren Angaben werden �berwiegend bei Spendenbescheinigungen eingesetzt.</p>

    <h3>Anzeige</h3>
    <p>Durch die Einstellungen kann das Verhalten von JVerein beeinflu�t werden.</p>
    <img src='images/Einstellungenanzeige.png' class='screenshot'>
    <p class='hervorgehoben'>Nach �nderungen der mit Stern gekennzeichneten Werte ist ein Neustart 
    von Jameica erforderlich.</p>
    <p>Folgende Einstellungen k�nnen vorgenommen werden:</p>
	  <ul>
      <li>Geburtsdatum und Eintrittsdatum Pflichtfeld</li>
      <li>Eingabefeld f�r das Sterbedatum vorhanden und auswertbar</li>
	    <li>Kommunikationsdaten beim Mitglied anzeigen: Telefonnummern und Email-Adressen werden angezeigt.</li>
	    <li>Tab Zusatzabbuchungen beim Mitglied anzeigen. Impliziert, dass die �bersicht der Zusatzabbuchungen 
	     (nicht) angezeigt wird und die Option bei der Abbuchung (in)aktiv ist.</li>
	    <li>Tab Vermerke beim Mitglied anzeigen. Beim Mitglied k�nnen 2 mal 255 Zeichen Vermerke gespeichert werden.</li>
	    <li>Tab Wiedervorlage beim Mitglied anzeigen. Impliziert, dass die �bersicht der Wiedervorlagen 
	         (nicht) angezeigt wird.</li>
    	<li>Kursteilnehmer ein-/ausblenden. Auswirkung auf die Abbuchung.</li>
    	<li>Lehrg�nge anzeigen. Gglfs. k�nnen zu einem Mitglied die durchgef�hrten Lehrg�nge mit Ergebnissen gespeichert werden.</li>
	    <li>Juristische Personen erlaubt. Die Eingabe von Firmen, Organisationen und Beh�rden als Mitglieder
		      wird erlaubt. Anstatt Name und Vorname werden Name-Zeile1 und Name-Zeile2 erfasst. Geburtsdatum
		      und Geschlecht werden nicht erfasst.</li>
		  <li>Mitgliedskonten. Zu jedem Mitglied wird gespeichert, welche Betr�ge es zahlen soll und gezahlt hat. Daraus
		      k�nnen Rechnungen und Mahnungen erzeugt werden.</li>
		  <li>Mitgliedsfoto. </li>
		  <li>Zus�tzliche Adressen: Speicherung von weiteren Adressen. Z. B. Spender, Lieferanten, Trainer...</li>
		  <li>Auslandsadressen: Beim Mitglied kann zus�tzlich der Wohnsitz-Staat gespeichert werden</li>
		  <li>Speicherung und Auswertung von Arbeitseins�tzen.</li>
		  <li>Speicherung von Dokumenten zu Mitgliedern und Buchungen.</li>
		  <li>Individuelle Beitr�ge: Grunds�tzlich zahlt das Mitglied den Beitrag, der in der Beitragsgruppe angegeben wurde.
		      Sofern diese Option aktiviert wurde, kann bei jedem Mitglied ein abweichender individueller Beitrag angegeben 
		      werden.</li>
	    <li>Externe Mitgliedsnummern verwenden. Vereine, die auf Bundes- oder Landesebene organisiert 
	           sind und eine durchg�ngige Mitgliedsnummer verwalten m�chten, k�nnen in JVerein eine externe 
	           Mitgliedsnummer speichern.</li>
	    <li>Verz�gerungszeit in Millisekunden: Bei der Eingabe des Mitgliedes gibt es f�r Name, Vorname und Stra�e 
	       Suchfelder, die die Werte anzeigen, die zur bisherigen Eingabe passen. Mit der Verz�gerungszeit kann eingestellt
	       werden, nach welcher Zeit diese Funktion anspringt.</li>	
	</ul>
	
	<h2><a name='beitraege'></a>Beitr�ge</h2>
  <img src='images/Einstellungenbeitraege.png' class='screenshot'>
	<p>Beitragsmodell, siehe auch <a href='dokumentationbeitragsmodelle.php'>Beitragsmodelle</a></</p>
	<p>Die Standardwerte f�r den Zahlungsrhytmus und den Zahlungsweg bei der Speicherung neuer Mitglieder kann eingestellt
	   werden.</p>
	
	<p>Ab Version 2.1 ist der Textschl�ssel f�r die Erstellung der DTAUS-Datei festzulegen.</p>
	
	<p><b>Lastschrift:</b> Das Mitglied gestattet dem Verein, die Beitr�ge von seinem Konto 
	abzubuchen (Einzugserm�chtigung). Der Kontoinhaber hat das Recht, �ber viele Jahre die 
	Lastschrift zu stornieren und das Geld zur�ck zu buchen. Dies ist zur Zeit die normale 
	Zahlungsweise und funktioniert immer. Bei Unsicherheit diese Auswahl treffen, bzw. mit der Bank kl�ren.</p>
  <p><b>Abbuchung:</b> Das Mitglied beauftragt seine Bank, Abbuchungen dieses Vereins ohne 
  R�ckfrage auszuf�hren. Der Kontoinhaber hat nicht mehr das Recht, die Lastschrift zu 
  stornieren und das Geld zur�ck zu buchen. Nur Unterdeckung verhindert die Abbuchung.
  In der Praxis bekommt der Verein bei der Freischaltung dieser Zahlungsart von seiner Bank 
  ein Blanko-Formular, das jedes Mitglied ausf�llt und seiner Bank �bergibt (alternativ kann 
  es auch eingesammelt und vom Verein eingereicht werden). Diese zur Zeit besondere Art der 
  Abbuchung gibt dem Verein und der Bank erh�hte Sicherheit, da Abbuchungen nicht mehr 
  zur�ckgefordert werden k�nnen.</p>

  <p>Bei der Abwicklung der Abbuchung �ber Hibiscus kann die Art nachtr�glich durch �ndern der 
  einzelnen Buchungen innerhalb der Sammellastsachrift nachtr�glich ge�ndert werden 
  (Doppelklick auf die Sammellastschrift und �ndern der Einzeldaten f�r jedes Mitglied).
  Bei falscher Wahl der Zahlungsart auf "Abbuchung" k�nnen durch die Abweisung der Lastschrift 
  R�ckbuchungsgeb�hren belastet werden. Im Zweifelsfall mit der Bank sprechen oder Lastschrift
  w�hlen.</p>
	
	<h2>Dateinamenmuster</h2>
	<img src='images/Einstellungendateinamen.png' class='screenshot'>
	<p>Bei der Ausgabe von Dateien (Abbuchung, Auswertungen...) werden die Dateinamen nach dem 
	vorgegebenen Muster aufgebaut. Es k�nnen zus�tzliche, vom Betriebssystem unterst�tzte Zeichen, 
	in das Muster aufgenommen werden. Bleibt das Muster leer, wird kein Vorschlag f�r den Dateinnamen 
	angezeigt. Spendenbescheinigungen werden jeweils f�r den einzelnen Spender ausgestellt. Daher
	sollten zu leichteren Identifizierung Name und Vorname in den Dateinamen aufgenommen werden. </p>
	<p>Folgende Variable stehen zur Verf�gung:</p>
	<ul>
	<li>a$ : Aufgabe (z. B. auswertung, abbuchung)</li>
	<li>d$ : Aktuelles Datum</li>
	<li>s$ : Sortierung. Wird nur bei Auswertungen gef�llt. Ansonsten leer.</li>
	<li>z$ : Aktuelle Zeit</li>
	<li>n$ : Name des Mitglieds</li>
	<li>v$ : Vorname des Mitglieds</li>
	</ul>

  <h2>Spendenbescheinigungen</h2>
  <img src='images/Einstellungenspendenbescheinigungen.png' class='screenshot'>
  <p>Hier k�nnen die Werte zur Erstellung von Spendenbescheinigungen eingestellt werden.</p> 
  <p>Mindestbetrag: Es werden nur Spendenbescheinigungen f�r Einzelspenden, die diesen Betrag �bersteigen
    ausgestellt.</li>
  <p>Verzeichnis: In einem Durchlauf k�nnen mehrere Spendenbescheinigungen erstellt werden. Jede Spenden
    bescheinigung wird in ein eigenes Dokument ausgegeben und in das angegebene Verzeichnis gespeichert.</li>
  <p>Buchungsart drucken: Im Normalfall wird der Verwendungszweck aus der Buchung in die Spendenbescheinigung
    �bernommen. Sofern diese Option aktiviert wurde, wird der Text aus der Buchungsart genommen.</p>
    
	<h2>Buchf�hrung</h2>
	<img src='images/Einstellungenbuchfuehrung.png' class='screenshot'>
	<p>Beginn des Gesch�ftsjahres in der Form TT.MM. </p> 

	<h2>Rechnungen</h2>
	<img src='images/Einstellungenrechnungen.jpg' class='screenshot'>
	<p>Texte f�r die einzelnen Zahlungswege f�r den Rechnungsdruck. In den Text zur Abbuchung k�nnen die 
	   Variablen ${Konto} und ${BLZ} eingemischt werden.</p>
	
	<h2><a name='tabellen'></a>Tabellen</h2>
	<p>Festlegung der Spalten, die in Tabellen angezeigt werden sollen. 
	<img src='images/Einstellungentabellen.png' class='screenshot'>
	

	<h2><a name=mail></a>Mail</h2>
	<img src='images/Einstellungenmail.png' class='screenshot'>
	<p>Alternativ zur EMail-Adresse kann auch der Name zus�tzlich im Format 
	<code>Vereinsname oder Mein Name &lt;vorstand@verein.de&gt</code>.
	Wichtig ist dabei das Format: (Name) (Spitze Klammer auf) (Email) (Spitze Klammer zu)</p>
	
	<h2><a name=statistik></a>Statistik</h2>
	<img src='images/Einstellungenstatistik.png' class='screenshot'>
	<p>F�r statistische Zwecke k�nnen Altersgruppen wie im obigen Hardcopy dargestellt angegeben 
	   werden.</p>
	<p>Zur Ausgabe einer Jubil�umsliste werden die Jubeljahre durch Komma getrennt eingetragen. 
	   Ohne Eingabe werden die Standardwerte 10,25,40,50 verwendet.</p>
	<p>Es kann eine Liste der Altersjubilare ausgegeben werden. Ohne Eingabe werden 
	   die Standardwerte 50,60,65,70,75,80,85,90,95 verwendet.</p>
	
 <? include ("footer.inc"); ?>