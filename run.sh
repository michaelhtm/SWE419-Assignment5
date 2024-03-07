#!/bin/zsh

# Check if any Java files exist in the current directory

# Compile the Java files
javac -cp .:junit-4.13.1.jar *.java

# Check the exit status of the compilation command
if [ $? -eq 0 ]; then
    # Compilation successful, execute the tests
    java -cp .:junit-4.13.1.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore AllTests
else
    # Compilation failed, print an error message
    echo "Compilation failed. Aborting test execution."
fi