#!/bin/bash

javac -classpath `hadoop classpath` CalculateAverageMapper.java && javac -classpath `hadoop classpath` CalculateAverageReducer.java && javac -classpath `hadoop classpath`:. CalculateAverage.java
jar cvf CalculateAverage.jar *.class
hadoop fs -rm -r -f project
hadoop fs -mkdir project
hadoop fs -put state=NY project
hadoop jar CalculateAverage.jar CalculateAverage project/state=NY project/output
hadoop fs -ls project/output
hadoop fs -cat project/output/part-r-00000
hadoop fs -cat project/output/part-r-00000 > average.csv