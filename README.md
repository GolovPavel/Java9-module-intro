# Simple modular Java 9 project

Simple example how to create java 9 module, compile, pack and run it.

## Project structure

`./src` - directory for the module source code;

`./mods` - directory for the module compiled code;

`./lib` - directory for the module jar file. 

## Compile project

In the root project directory type the next command:

```
javac -d mods --module-version 1.0 
	--module-source-path src/ 
	src/com.jdojo.intro/module-info.java
	src/com.jdojo.intro/com/jdojo/intro/Welcome.java 
``` 

`-d` flag specifies the compiled files output directory;
`--module-source-path` flag specifies the root directory for modules;
`--module-version` flag specifies the module version;
last 2 arguments specifies the path to module-info file and class that should be compiled.

## Pack compiled module into jar file

To pack compiled classes into jar file type the next command:

```
jar --create 
	--file lib/com.jdojo.intro-1.0.jar 
	--main-class com.jdojo.intro.Welcome 
	--module-version 1.0 
	-C mods/com.jdojo.intro/ .
```

`--file` flag specifies the name of the jar file;

`-C` flag specifies the root catalog for jar command;

`.` specifies that all files from `-C` catalog should be included in jar file.

To check information about created jar module file type:

```
java --module-path lib -d com.jdojo.intro
```

## Execute created jar

To execute created jar file type:

```
java --module-path lib --module com.jdojo.intro
```

## Execute compiled code without jar packing

To execute compiled code from `./mods` directory without jar packing type:

```
java --module-path mods --module com.jdojo.intro/com.jdojo.intro.Welcome
```
