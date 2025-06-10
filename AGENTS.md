# Repository Overview

This project contains a small Spigot plugin named **NoBuild**. The following sections describe every file and directory in detail.

## Root Level Files

- **README.md** – Provides a brief description of what the plugin does and includes build instructions. After updating, it will also contain a detailed step-by-step guide for compiling and installing the plugin on a server.
- **pom.xml** – Maven configuration file. It declares the `com.example:nobuild` artifact, uses Java 1.8 for compilation, and pulls in the Spigot API as a provided dependency from the Spigot snapshots repository. The `maven-compiler-plugin` ensures source and target compatibility with Java 1.8.
- **src/** – Top-level source directory containing all Java classes and resources used by the plugin.

## Source Code

### src/main/java/com/example/nobuild/NoBuild.java

This is the main plugin class extending `JavaPlugin` and implementing `Listener`.
Key behaviors:

- **onEnable()** – Called when the plugin is loaded. It registers the class as an event listener with the server's plugin manager so that block placement events can be intercepted.
- **canBuild(Player player)** – Helper method returning `true` if the player is either an operator or has the permission `nobuild.bypass`.
- **onBlockPlace(BlockPlaceEvent event)** – The event handler runs at `EventPriority.HIGH`. If the placing player fails `canBuild`, the event is cancelled and the user receives a red warning message: "You are not allowed to build." This effectively prevents regular players from placing blocks while allowing operators and permissioned users to build normally.

### src/main/resources/plugin.yml

Defines plugin metadata for the Spigot platform:

- `name: NoBuild` – Display name of the plugin.
- `main: com.example.nobuild.NoBuild` – Entry point class.
- `version: 1.0` – Plugin version number.
- `api-version: 1.21` – Indicates compatibility with the Spigot 1.21 API.
- `permissions.nobuild.bypass` – Permission that allows players to ignore the build restriction. By default this permission is granted to server operators (`default: op`).

The file must reside in the JAR so Spigot can load the plugin properly.

## Directory Layout

```
.
├── README.md
├── AGENTS.md
├── pom.xml
└── src
    └── main
        ├── java
        │   └── com
        │       └── example
        │           └── nobuild
        │               └── NoBuild.java
        └── resources
            └── plugin.yml
```

After running `mvn package`, Maven creates a `target/` directory containing the compiled JAR. Install that JAR into your Spigot server's `plugins` folder to use the plugin.
