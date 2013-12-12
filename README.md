bhash
=====

Dedicated ASCII simple hashing experiment with Java and JUnit 


Mutation testing experiments (when Score is higher - code is better !)
--------------------------

<pre>
~/workspace/java/bhash/mutationtest/judy-2.0.0/bin$ sh judy.sh --workspace /home/test/workspace/java/bhash/ --classes target/classes --test-classes target/test-classes --killed --threads 4
Judy, Fri Dec 13 00:24:11 CET 2013
Parsing input... Done.
Initial analysis... Done.
Computing mutation result...
Classes count: 3
[  0,0%] T net.bieli.bhash.BHashException    0    0/0       0   0
[ 50,0%] N net.bieli.bhash.BHashTools        1   10/16     17   1
[100,0%] N net.bieli.bhash.BHash             1   42/71     72   5


Classes:                     : 3
Score                    [%] : 59,77
  killed mutants             : 52
  all mutants                : 87
Duration                 [s] : 6,96
  initial tests duration [s] : 0,43
  tests duration         [s] : 5,83
  generation duration    [s] : 2,28
  initial tests runs         : 3
  tests runs                 : 87

Saving result... Done.


</pre>
