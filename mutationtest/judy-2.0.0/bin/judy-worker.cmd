@echo off
set LIB=..\lib

java -javaagent:%LIB%\judyagent.jar -cp "%LIB%\junit-4.8.1.jar;%LIB%\asm-all-3.2.jar;%LIB%\jopt-simple-3.2.jar;%LIB%\cajo-1.168.jar;judy.jar" pl.wroc.pwr.judy.general.JudyWorker %*
