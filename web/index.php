<? include ("frame.inc"); ?>
	   
	<div style="float:left; width: 600px;border:0px">
	<p><a href="forum">Verbesserungsvorschl�ge und Fehlermeldungen bitte ins Forum posten</a>
    <h1>Home</h1>
    <p>
 <!--      <img src="images/JVerein_Box.jpg" alt="JVerein-Software-Box" >  -->
       <i>JVerein</i> ist eine Open-Source-Vereinsverwaltung mit einer Anbindung an die ebenfalls unter 
       Open-Source-Lizenz stehende Homebankingsoftware 
       <a href="http://www.willuhn.de/products/hibiscus/">Hibiscus</a>.
     </p>
     <p>Die Implementierung erfolgt mit Java. Der Ablauf auf vielen Plattformen ist damit gew�hrleistet. 
        Als GUI-Framework kommt <a href="http://www.willuhn.de/products/jameica/">Jameica</a>  zum Einsatz.
     </p>
     <p>F�r jedes Mitglied k�nnen folgende Daten gespeichert werden:</p>
     <ul>
        <li>Namen</li>
        <li>Adresse</li>
        <li>Zahlungsweg</li>
        <li>Bankverbindung</li>
        <li>Zahlungrhytmus</li>
        <li>Kommunikationsdaten (Tel./eMail)</li>
        <li>Daten zur Mitgliedschaft (Eintritt, Beitragsgruppe, Austritt)</li>
        <li>Eigenschaften des Mitglieds</li>
        <li>Mitgliedskonto</li>
        <li>Personenart (nat�rliche/juristische Person)</li>
        <li>Foto</li>
        <li>Wiedervorlagetermine</li>
        <li>Vermerke</li>
        <li>Zusatzzahlungen (einmalig und wiederkehrend)</li>
        <li>Individuelle Zusatzfelder</li>
        <li>Speicherung von Dokumenten zu Buchungen und Mitgliedern (ab Version 2.0)</li>
        <li>Lehrg�nge</li>
        <li>Arbeitseins�tze (ab Version 2.0)</li>
        <li>Freie Formulare (ab Version 2.0)</li>
        <li>Spendenbescheinigungen (individuell/standard)</li>
        <li>Versand von Mails</li>
        <li>�bergabe der Mitgliedsdaten an das Hibiscus-Adressbuch</li>
        <li>Adressdaten von Spendern und anderen Nichtmitgliedern (ab Version 2.0)</li>
     </ul>
	<p>F�r den Beitragseinzug k�nnen eine oder mehrere Beitragsgruppen gebildet werden. Die Abbildung eines 
	   Familientarifes mit der Bildung von Familienverb�nden ist m�glich. Es wird entweder ein fester 
	   Beitrag (pro Beitragsgruppe) in einem Intervall (z. B. Jahresbeitrag oder Monatsbeitrag) erhoben oder 
	   ein Monatsbeitrag der monatlich, viertelj�hrlich, halbj�hrlich oder j�hrlich eingezogen wird. 
	</p>
	<p>Der Beitragseinzug erfolgt in der Regel �ber das Abbuchungsverfahren. Die Abbuchungen werden im 
	   DTAUS-Format mit Hilfe meiner Bibliothek <a href="http://obantoo.berlios.de">OBanToo</a> ausgegeben 
	   und k�nnen in <a href="http://www.willuhn.de/products/hibiscus/">Hibiscus</a> importiert werden 
	   oder direkt an <a href="http://www.willuhn.de/products/hibiscus/">Hibiscus</a> als Einzel- oder 
	   Sammellastschrift �bergeben werden. Alle Abrechnungsdaten werden festgehalten. Daraus k�nnen 
	   anschlie�end Rechnungen erstellt werden.</p>
	<p>�ber das Mitgliedskonto gibt es jederzeit einen �berblick �ber den Stand der Zahlungen eines
	   Mitgliedes.</p>
  <p>Die Erstellung von Rechnungen, Mahnungen sowie Spendenbescheinigungen ist m�glich.</p>
	<p>F�r jedes Mitglied k�nnen zu beliebigen Zeitpunkten Zusatzabbuchungen eingegeben werden 
	   (Strafgelder, Eigenanteile ...), die entweder einmalig oder wiederkehrend abgerechnet werden.</p>
	<p>Die Vereinsbuchf�hrung (Einnamen/Ausgaben) kann �ber eine integrierte einfache 
	   Buchf�hrung erledigt werden.</p>
	<p>Die Mitgliederdaten k�nnen nach vielen Kriterien <a href="dokumentationauswertungmitglieder.php">
	   ausgewertet</a> werden. Die Ausgabe erfolgt im PDF-Format oder im CSV-Format. Die Erstellung 
	   einer Liste mit <a href="dokumentationauswertungjubilaeen.php">Mitgliedschafts- oder Altersjubli�en</a> ist m�glich.</p>
	<p>Der Versand von Mails ist an einzelne Mitglieder, 
	   Gruppen von Mitgliedern oder alle Mitglieder m�glich. F�r regelm��ig zu versendende Mails k�nnen Vorlagen erstellt 
	   werden. Durch Variable kann die Mail personalisiert werden.</p>
	<p>JVerein ist mit vielen Screenshots ausgiebig <a href='dokumentation.php'>dokumentiert</a>.</p>
	<p>JVerein steht unter GPL. In diesem Rahmen kann JVerein genutzt werden.</p>
	<p>Zus�tzlich gibt es eine Bitte des Autors: Wenn JVerein "produktiv" genutzt wird, bitte ich um einen 
	   Eintrag im <a href="http://www.jverein.de/forum/viewforum.php?f=3">Forum unter Vorstellung der Verein, 
	   die JVerein nutzen</a>. Diese Daten dienen der "Erfolgskontrolle".</p>
	</div>   
	<div style="float:left; width:200px;  left: 850px; ">    
	   	<h1>News</h1>
    	<ul>
    	  <li>16.10.2011: Da Berlios zum 31.12.2011 die Pforten schlie�t, ist JVerein zu <a href='http://sourceforge.net/projects/jverein/'>Sourceforge</a> umgezogen.</li>
        <li>15.07.2011: Windows-Setups der Jameica-Suite stehen in 32- und 64-Bit
    	  <li>16.10.2011: Da Berlios zum 31.12.2011 die Tore schlie�t, ist JVerein zu <a href='-Version zur Verf�gung.</li>
        <li>30.06.2011: Version 2.0.1 freigegeben</a>. Siehe <a href='changelog.php#v201'>Changelog</a>.</li>
        <li>23.06.2011: Version 2.0.0 freigegeben</a>. Siehe <a href='changelog.php#v200'>Changelog</a>.</li>
    	  <li>15.11.2010: Neue Version 1.4.0.1 des Windows-Installers freigegeben. Installation nur, wenn Syntax eingesetzt wird.</li>
    	  <li>10.11.2010: Version 1.4.0 freigegeben</a>. Siehe <a href='changelog.php#v140'>Changelog</a>.</li>
    	  <li>07.11.2010: Neuer <a href='download.php'>Downloadbereich</a></li>
    	</ul>
	</div>
   
 <? include ("footer.inc"); ?>
  

