# NoBuild

A simple Minecraft plugin that prevents non-admin players from placing blocks. Players can still break and collect items. Operators or players with the permission `nobuild.bypass` are exempt from this restriction.

This project targets Spigot **1.21.1**.

## How to Build and Install

Follow these steps to compile the plugin and deploy it on your Spigot server.

1. **Install Java and Maven**
   - Make sure Java Development Kit (JDK) 8 or later is installed. You can verify by running `java -version`.
   - Install Apache Maven and verify with `mvn -version`.
2. **Clone or Download This Repository**
   - `git clone <repository-url>` or download the ZIP archive and extract it.
   - `cd` into the `mc_nobuild` project directory.
3. **Compile the Plugin**
   - Run `mvn package` from the project root. Maven will download the Spigot API dependency and produce a JAR file.
   - When the build finishes, look in the `target/` directory for a file named similar to `nobuild-1.0-SNAPSHOT.jar`.
4. **Prepare a Spigot Server**
   - Obtain a Spigot 1.21.1 server JAR and set up a server folder.
   - Start the server once to generate the default folders if you haven't already.
5. **Install the Plugin**
   - Copy the JAR from the `target/` directory into your server's `plugins/` folder.
   - Restart or start the server. Spigot will load the NoBuild plugin during startup.
6. **Verify and Configure**
   - Run `/plugins` in the server console or in-game to confirm that "NoBuild" appears in the list.
   - Grant the `nobuild.bypass` permission to any players who should be allowed to build.

Once installed, non-operator players without the permission will be unable to place blocks, helping prevent griefing on your server.

## Makefile Commands

You can also use the provided Makefile for common development tasks:

- `make compile` – Build the plugin JAR with Maven.
- `make test` – Run any unit tests.
- `make lint` – Execute Checkstyle analysis.

