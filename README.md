# Autonomous Treasure Hunter (Java)

## Overview
The objective is to design an autonomous agent that collects all treasures on a randomly generated grid map in the shortest possible path while avoiding both static and dynamic obstacles.

The system is implemented in Java using Object-Oriented Programming principles and grid-based pathfinding techniques.

## Core Features

### Random Map Generation
- User-defined grid size (up to 1000x1000)
- Random obstacle placement
- Guaranteed reachable treasures
- Seasonal themes (Winter / Summer)

### Obstacles

#### Static Obstacles
- Trees (2x2 – 5x5)
- Rocks (2x2 – 3x3)
- Walls (10x1)
- Mountains (15x15)

#### Dynamic Obstacles
- Birds (vertical movement within 5 cells)
- Bees (horizontal movement within 3 cells)
- Occupy 2x2 area

### Treasure Types
- Gold
- Silver
- Emerald
- Copper

Priority order:
Gold > Silver > Emerald > Copper

### Autonomous Agent
- Moves only up, down, left, right
- 3x3 vision range
- Computes shortest path dynamically
- Displays total number of steps
- Visualizes final path in green

## Algorithmic Approach

The system implements a shortest path algorithm to:

- Avoid brute-force exploration
- Efficiently navigate dynamic obstacles
- Collect all treasures with minimal steps

## OOP Concepts Used

- Encapsulation
- Inheritance
- Polymorphism
- Abstraction
- Custom grid modeling

## Technologies

- Java
- Grid-based pathfinding
- Algorithm design
