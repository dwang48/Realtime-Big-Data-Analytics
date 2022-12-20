#!/bin/bash

javac -classpath `hadoop classpath` FindMinMapper.java && javac -classpath `hadoop classpath` FindMinReducer.java && javac -classpath `hadoop classpath`:. FindMin.java
jar cvf FindMin.jar *.class
hadoop fs -rm -r -f project
hadoop fs -mkdir project
hadoop fs -put state=NY project
hadoop jar FindMin.jar FindMin project/state=NY project/output
hadoop fs -ls project/output
hadoop fs -cat project/output/part-r-00000
hadoop fs -cat project/output/part-r-00000 > min.csv