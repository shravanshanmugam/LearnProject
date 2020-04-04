## Create Custom JRE

#### Compile the source code
```sh
$ javac -d out --module-path out src/main/java/module-info.java src/main/java/com/shravan/learn/model/User.java src/main/java/com/shravan/learn/service/DefaultUserService.java src/main/java/com/shravan/learn/service/impl/UserService.java src/main/java/com/shravan/learn/store/*.java src/main/java/com/shravan/learn/Main.java
```

#### Identify required dependencies/modules
```sh
$ jdeps --module-path out -s --module learn.java.modules
```

#### Create custom JRE with these modules
```sh
$ jlink --module-path out --module-path $JAVA_HOME/mods:out --add-modules java.base,learn.java.modules --output userapp
```

#### Execute program using custom JRE
```sh
$ ./userapp/bin/java --module learn.java.modules/com.shravan.learn.Main
```

#### Check size of custom JRE
```sh
$ du -sh userapp/
```
