# Language Detector
Webservices bieten unterschiedliche Funktionalitäten an, die von Clients genutzt werden können. Eine einfache Variante hierfür sind RESTful Webservices. Schreibe ein einfaches RESTful-Webservice inkl. GUI-Client, welches anhand eines eingegebenen Textes erkennt, um welche Sprache es sich handelt!

## Anforderungen:
### Webservice
- [x] Das Webservice kann als Skript gestartet werden und horcht anschließend auf eingehende Requests
- [x] Die Ressource des Webservices ist unter einer URL erreichbar, welche den zu überprüfenden Text als GET-Parameter übernimmt
- [x] Das Webservice retourniert ein JSON-Objekt nach folgendem Aufbau:
```json
{
"reliable": true,
"language": "GERMAN",
"short": "de",
"prob": 96}
```
### Client
- [x] Der Client ist eine grafische Oberfläche in JavaFX
- [x] Der Client erlaubt die Eingabe eines (mehrzeiligen) Texts
- [x] Der Client gibt das Resultat des Webservices in einem (mehrzeiligen) Textfeld aus, wobei die Resultate fett markiert werden (vgl. Abbildung)
- [x] Der Client bietet drei Buttons an
- [x] verify: Schickt den Text an das Webservice und zeigt das Ergebnis im Textfeld an
- [x] reset: Setzt beide Textfelder zurück
- [x] close: Schließt die Anwendung
- [x] Die Größe des Clients kann sinnvoll skaliert werden

Viel Erfolg!

## Abgabe: 
persönliches Abgabegespräch, der dokumentierte Java-Code ist vor dem Gespräch als .jar-Files (inkl. Sourcen) auf Moodle abzugeben (oder ein GitHub-Link auf ein Repository mit den Sourcen und .jar-Files)

