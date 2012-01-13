<? include ("frame.inc"); ?>
    <h1>FAQ</h1>
    <h2>Inhaltsverzeichnis</h2>
    <a href='#neuerlaptop'>Wie kann ich JVerein auf einen neuen Rechner bringen?</a><br>
    <a href='#programmordner'>Wo liegt der JVerein-Programmordner?</a><br>
    <a href='#datenordner'>Wo liegt der JVerein-Datenordner standardm��ig?</a><br>
    <a href='#datenordnerverschieben'>Wie kann ich den Datenordner an einen Nichtstandardplatz legen?</a><br>
    <a href='#internet'>Kann JVerein �ber ein Netzwerk/Internet betrieben werden?</a><br>
    <a href='#bankverbindung'>Warum kann ich eine Bankverbindung nicht speichern/importieren?</a><br>
    <br>
    <a name="neuerlaptop"></a>
    <p>Q: Ich habe mir einen neuen Laptop zugelegt. Nun m�chte ich von meinem alten Laptop alles auf den Neuen �bertragen.
          Welche Dateien bzw. Ordner muss ich mitnehmen? Muss ich das Prog. neu installieren?<br>
       A: Es muss der Programm- und der Datenordner auf den neuen Rechner �bertragen werden.</p>
    <a name="programmordner"></a>
    <p>Q: Wo finde ich den Programmordner?<br>
       A: Es gibt keinen fest definierten Platz f�r den Programmordner. Sofern die Jameica-Suite
          installiert wurde, ist der Ordner unter c:\Programme\Jameica zu finden. Unter Linux 
          wird oft unter /opt/jameica oder ~/jameica installiert.</p>
    <a name="datenordner"></a>
    <p>Q: Wo finde ich den Datenordner standardm��ig?<br>
       A:
          <table>
          <tr>
          <th>Betriebssystem</th><th>Verzeichnis</th>
          </tr>
          <tr>
          <td>Linux</td><td>/home/&lt;username&gt;/.jameica</td>
          </tr>
          <tr>
          <td>Windows 2000/XP</td><td>C:\Dokumente und Einstellungen\&lt;username&gt;\.jameica</td>
          </tr>
          <tr>
          <td>Windows Vista</td><td>C:\Users\&lt;username&gt;\.jameica oder C:\Benutzer\&lt;username&gt;\.jameica</td>
          </tr>
          <tr>
          <td>MacOS</td><td>/Users/&lt;username&gt;/.jameica oder /Users/&lt;username&gt;/Library/jameica (falls Jameica 1.7 die erste benutzte Version war, dann letzteres, sonst das erst-genannte)</td>
          </tr>
          </table>    
          </p>
    <a name="datenordner"></a>
    <p>Q: Wie kann ich den Datenordner an einen Nichtstandardplatz legen?<br>
       A:
          <p>
          Beim Aufruf von Jameica wird der Schalter <code>-f pfad</code> angegeben.</p>
          <p>Beispiel: jameica.bat -f c:/meinejameicadaten</p>
          <p>siehe auch <a href='http://jameica.berlios.de/doku.php?id=support:install#optionale_startparameter'>Jameica-Doku</a>.
          <p>Unter Windows kann mit einem rechten Mausklick auf das Jameica-Icon &gt; Eigenschaften folgendes Bild ge�ffnet
             werden:</p>
          <img src='../images/jameicasuiteeigenschaften.png' class='screenshot'>
          <p>Im Feld Ziel wird der Schalter -f VERZEICHNIS wie angegeben ver�ndert.</p>
    <a name='internet'></a>
    <p>Q: Kann JVerein �bers Netzwerk/Internet betrieben werden?<br>
       A: JVerein kann seine Daten in einer MySQL-Datenbank speichern. Siehe auch 
          <a href='http://www.jverein.de/dokumentationmysql.php'>MySQL-Support</a>.
          Beim Betrieb �ber das Internet ist darauf zu achten, dass die Daten 
          verschl�sselt �bertragen werden. Weiterhin wird darauf hingewiesen, dass Jameica,
          Hibiscus und JVerein keine Benutzerverwaltung haben. Jeder, der Zugriff auf das
          Verfahren hat, kann alles machen. Beim Umgang mit Geld sicher eine nicht
          befriedigende Angelegenheit. Es ist auch nicht nachvollziehbar, wer welche
          �nderung vorgenommen hat. Mir stellt sich allerdings immer wieder die Frage nach
          dem "Warum?". Meines Erachtens k�nnen die Daten durch eine Person gepflegt werden.
          Ich bin selber Kassenwart eines Vereins mit ca. 400 Mitgliedern und wei� somit 
          wovon ich rede. Den �brigen Vorstandsmitgliedern k�nnen PDF-Dokumente oder CSV-Dateien 
          zur Serienbriefgenerierung zur Verf�gung
          gestellt werden. Darin kann auch ohne Probleme gesucht werden.</p>
    <a name='bankverbindung'> </a>
    <p>Q: Warum kann ich eine Bankverbindung nicht speichern/importieren?<br>
       A: Die Banken verwenden Pr�fziffernmethoden zur �berpr�fung der Kontonummern.
          Siehe <a href="http://www.bundesbank.de/zahlungsverkehr/zahlungsverkehr_pruefziffernberechnung.php">Pr�fziffernberechnung bei der Deutschen Bundesbank</a>.
          JVerein verwendet zur Berechnung der Pr�fziffern die Bibliothek 
          <a href="http://hbci4java.kapott.org/">HBCI4Java</a>. Bisher ist mir kein Fehler in der 
          Pr�fziffernberechnung bekannt. Daher gehe ich davon aus, das die Meldung immer korrekt
          ausgegeben wird. Die Pr�fziffernberechnung kann unter Hibiscus | Einstellungen | Grundeinstellungen |
          Kontonummern und Bankleitzahlen mittels Pr�fziffern testen ausschalten. Damit wird die 
          Pr�fziffernberechnung generell ausgeschaltet. Das gilt sowohl f�r Hibiscus als auch f�r JVerein.
 </p> 
          
<? include ("footer.inc"); ?>

