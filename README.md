## Description

This Java project simulates the motion of celestial bodies under the influence of mutual gravitational forces using Newtonian physics. It models a simplified universe and visualizes planetary motion in 2D space.

**Features**

- Object-oriented simulation of celestial bodies
- Calculates pairwise gravitational forces
- Updates positions and velocities over time
- Animated display using a custom `StdDraw` utility
- Includes unit tests for all key physical computations

**File Overview**

- `NBody.java`: Main class that reads input, runs the simulation loop, and draws the animation.
- `CelestialBody.java`: Represents a single body with mass, position, velocity, and force methods.
- `StdDraw.java`: Utility for rendering graphical elements.
- `Test*.java`: A suite of JUnit test files for verifying gravitational
