# M2_notere_soap


#WAR
Présent dans :
C:\Users\Jordane\Documents\GitHub\M2_notere_soap\wildfly-10.1.0.Final\standalone\deployments\m2_notere_soap.war

#Wildfly
Configuration de port (cf C:\Users\Jordane\Documents\GitHub\M2_notere_soap\wildfly-10.1.0.Final\standalone\configuration\standalone.xml) :
http : 8088
management-http : 9998

#Wildfly admin
http://localhost:9998/console/App.html#standalone-deployments
Un utilisateur "root" avec un password "toor" est présent.


#BDD hsqldb
Lancement à faire avec de lancer l'application SpringBoot
Via script :
C:\Users\Jordane\Documents\GitHub\M2_notere_soap\hsqldb-2.3.4\hsqldb\bin\startHsdldb.bat

#Configuration hsqldb in-memory
jdbc:hsqldb:hsql://localhost/xdb
user : SA / 

#Requêtes utiles :
SELECT * FROM "PUBLIC"."COMPTE"
SELECT * FROM "PUBLIC"."HISTORIQUEOPERATIONS"
SELECT * FROM "PUBLIC"."USER"

#Tomcat / SpringBoot
Au @PostConstruct, la bdd hsqldb est (ré)initialisé :

#Lancement et acces :
C:\Users\Jordane\Documents\GitHub\M2_notere_soap\TpIntergicielSpring\src\main\java\run\Application.java
http://localhost:8080/

#Utilisateurs et comptes :
Admin : oR / toor
Compte épargne de 300000

User : JQuincy / password
Compte courant de 500 et d'un découvert autorisé de 4000
Compte épargne de 10000

#L'historique des opérations est accessible via :
http://localhost:8080/infos?username=XXX
Exemple :
http://localhost:8080/infos?username=oR
http://localhost:8080/infos?username=JQuincy

#Un transfert peut etre effectué manuellement via :
http://localhost:8080/transfert?idCompteADebiter=X&idCompteACrediter=Y&montant=Z
Exemple :
http://localhost:8080/transfert?idCompteADebiter=2&idCompteACrediter=1&montant=5

#SOAP
Client :
C:\Users\Jordane\Documents\GitHub\M2_notere_soap\m2_notere_soap\src\jordane_quincy\github\com\BankServiceItf_BankServiceItf_Client.java

#REST
Client XML :
C:\Users\Jordane\Documents\GitHub\M2_notere_soap\TpIntergicielSpring\src\main\java\main\MainXml.java
Client Json (après avoir fait une action, par exemple via le client xml) :
Client Json :
C:\Users\Jordane\Documents\GitHub\M2_notere_soap\TpIntergicielSpring\src\main\java\main\MainJson.java

