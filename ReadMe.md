# Labor_5_1-Donations

Programmieren 5.Klasse  
Labor übung 1

Angabe:      
[Copyright HTL St.Pölten Informatik](https://www.htlstp.ac.at/abteilungen/informatik)  
![](readmefiles/Aspose.Words.cfcda2db-4015-4a51-a580-c8f6a3d9ef5c.001.png) REST Donations![]

Erzeuge eine Struktur gem¨aß folgendem ER-Diagram:

![](readmefiles/Aspose.Words.cfcda2db-4015-4a51-a580-c8f6a3d9ef5c.003.jpeg)

Das beiliegende Files data.sql erzeugt Testdaten fur¨ eine Datenbank. Regeln:

- Die ids sind autogeneriert
- firstName und lastName durfen¨ nicht leer sein
- Das date einer Donation darf nicht in der Zukunft liegen und es mussen¨ mindestens 5 Geldeinheiten gespendet werden
- Allf¨allige Fehler sindub¨ er einen zentralen Exceptionhandler zu behandeln Implementiere einen RESTful Webservice mit
  folgenden Endpoints:


- GET /api/donations?min=  
  returnt alle Personen, welche in Summe mindestens min gespendet haben
- GET /api/donations/ {id }
  returnt die Donation bzw 404
- GET /api/persons/ {id }/donations  
  returnt alle Donation der Person bzw 404, wenn die Person nicht existiert
- POST /api/persons/ {id }/donations  
  speichert eine neue Donation der Person
