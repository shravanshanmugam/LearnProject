## Create Custom JRE

#### Compile the source code
```sh
$ javac -d out --module-path ../learn.java.modules/out src/main/java/module-info.java src/main/java/com/shravan/importing/ImportMain.java
```

#### Identify required dependencies/modules
```sh
$ jdeps --module-path out:../learn.java.modules/out -s --module learn.importing.modules
```

#### Create custom JRE with these modules
```sh
$ jlink --module-path out --module-path $JAVA_HOME/mods:out:../learn.java.modules/out --add-modules java.base,learn.java.modules,learn.importing.modules --output defaultuserapp
```

#### Execute program using custom JRE
```sh
$ ./defaultuserapp/bin/java --module learn.importing.modules/com.shravan.importing.ImportMain
```

#### Check size of custom JRE
```sh
$ du -sh defaultuserapp/
```
