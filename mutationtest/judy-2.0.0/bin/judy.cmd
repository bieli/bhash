@echo off
set LIB=..\lib

java -javaagent:%LIB%\judyagent.jar -XX:MaxPermSize=256m -Xmx768m -XX:ReservedCodeCacheSize=128m -cp "%LIB%\cajo-1.168.jar;%LIB%\junit-4.8.1.jar;%LIB%\asm-all-3.2.jar;%LIB%\jopt-simple-3.2.jar;judy.jar" pl.wroc.pwr.judy.general.Judy %*
