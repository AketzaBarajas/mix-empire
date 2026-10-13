# MixEmpire

A turn-based dungeon crawler for the terminal, written in Java.

> Learning project — written in 2025 while learning object-oriented programming in Java.

## Overview

You move a character through a dungeon drawn as an 11 × 25 grid in the console. Five monsters of different levels are placed at random; stepping onto one starts a fight in which you and the monster trade blows until one of you is defeated. The game ends when your character dies.

The project practises classes, inheritance (a `Monstruo` base class with one subclass per level), collections and a simple game loop. The in-game text and the code comments are in Spanish.

## Getting started

Requires JDK 8 or later.

```bash
git clone https://github.com/AketzaBarajas/mix-empire.git
cd mix-empire
javac -encoding UTF-8 -d out src/*.java
java -cp out Main
```

Move with `W`, `A`, `S` and `D`, pressing Enter after each key.

## License

[MIT](LICENSE)
