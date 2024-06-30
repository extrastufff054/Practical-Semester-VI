#!/bin/bash

javac GreetingServer.java
javac GreetingClient.java

java GreetingServer 6066

# Running the client = java GreetingClient 127.0.0.1 6066