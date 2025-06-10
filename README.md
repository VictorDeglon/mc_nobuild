# NoBuild

A simple Minecraft plugin to prevent non-admin players from placing blocks. Players can still break and collect items. Operators or players with the permission `nobuild.bypass` are exempt from this restriction.

This project targets Spigot **1.21.1**.

## Building

Use Maven to compile the plugin:

```bash
mvn package
```

The resulting JAR will be located in `target/` and can be installed in your server's `plugins` folder.
