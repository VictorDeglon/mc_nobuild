# NoBuild

NoBuild is a tiny **Spigot** plugin that stops regular players from placing
blocks.  Operators (OPs) or anyone with the permission node `nobuild.bypass`
can still build freely.  The plugin targets **Spigot 1.21.1** and is meant as a
simple learning project.

Below you will find a verbose walkthrough explaining how to compile the plugin
and install it on either a local Windows machine or an Ubuntu server such as an
Orange Pi 5.  Each section includes links to helpful resources so you can read
more about the tools being used.

---

## 1. Prerequisites

* **Java Development Kit (JDK)** – Any modern version (8 or later) will work.
  [Adoptium](https://adoptium.net/) explains how to download and install OpenJDK
  on all platforms.
* **Apache Maven** – Used to compile the plugin. Installation instructions are
  available on the [official website](https://maven.apache.org/install.html).
* **Git** – Required if you want to clone this repository. See the
  [Git Book](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git) for
  installation details.

---

## 2. Building on Windows

If you develop on Windows, you can either use **WSL** (Windows Subsystem for
Linux) or install the tools natively. The commands below work in PowerShell or
Command Prompt once Java and Maven are installed.

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd mc_nobuild
   ```
2. **Compile the plugin**
   ```bash
   mvn package
   ```
   Maven downloads the Spigot API and writes the compiled JAR to the `target/`
   directory. The file is typically named `nobuild-1.0-SNAPSHOT.jar`.
3. **Where to find the JAR**
   The exact path will be:
   ```
   mc_nobuild\target\nobuild-1.0-SNAPSHOT.jar
   ```
   (The version number may differ if you update the `pom.xml`.)

For background reading on Java development on Windows see this
[Microsoft guide](https://learn.microsoft.com/windows/dev-environment/java-jdk).

---

## 3. Building on Ubuntu / Orange Pi 5

On a headless Ubuntu server (including small boards like the Orange Pi 5) the
steps are nearly the same. Use your terminal and run:

```bash
sudo apt update
sudo apt install openjdk-17-jdk maven git
git clone <repository-url>
cd mc_nobuild
mvn package
```

Again, the finished JAR appears in the `target/` directory. You can read more
about package management on Ubuntu in the
[official docs](https://help.ubuntu.com/lts/serverguide/apt.html).

---

## 4. Installing the Plugin on a Spigot Server

1. **Prepare your server** – Follow the
   [Spigot BuildTools guide](https://www.spigotmc.org/wiki/buildtools/) to obtain
   a compatible server JAR and run it once so the `plugins/` folder exists.
2. **Copy the plugin** – Move `nobuild-1.0-SNAPSHOT.jar` into the server's
   `plugins/` directory.
3. **Start or restart the server** – Spigot should print a message indicating
   that `NoBuild` loaded successfully.
4. **Verify** – Use the `/plugins` command in game or in the console. You can
   then grant the `nobuild.bypass` permission to players who should be allowed
   to build.

After installation, any player without that permission will receive a red
warning message when attempting to place blocks.  This helps keep your lobby
area tidy and free from accidental griefing.

---

## 5. Development Helpers

For convenience the repository includes a simple `Makefile` with a few targets:

```
make compile  # runs 'mvn package'
make test     # placeholder for any future unit tests
make lint     # runs Checkstyle analysis
```

Each command simply invokes Maven behind the scenes. Feel free to extend the
Makefile with your own tasks as you learn more.

