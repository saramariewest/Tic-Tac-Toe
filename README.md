# Tic Tac Toe

## Overview

Simple Java Swing Tic Tac Toe game with a scoreboard and player turn highlighting.

## Features

- 3x3 board with clickable buttons
- X and O player turns
- Win detection and draw handling
- Scoreboard tracking player wins
- Reset button to restart game and reset scores

## Requirements

- Java 17+ (or compatible JDK)
- No external libraries needed

## Running

From the project root:

```bash
javac src/*.java
java -cp src Main
```

## Project structure

- Main.java — application entry point
- TicTacToeGame.java — window setup and main UI
- Board.java — game board and button handling
- GameLogic.java — move validation, win and draw detection
- Scoreboard.java — score display and player highlight
- Square.java — board cell state wrapper
- Player.java — player enum values
