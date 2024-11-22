@ECHO OFF

SET topic=user-login

CD C:\kafka\bin\windows

START zookeeper-server-start.bat ..\..\config\zookeeper.properties
TIMEOUT /T 20
START kafka-server-start.bat ..\..\config\server.properties
TIMEOUT /T 20
START kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic %topic% --from-beginning