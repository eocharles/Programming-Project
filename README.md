#  CS Programming Project Specification


# Project Description:
I am developing a simulation for a popular board game of your choice, following 
the principles of Test-Driven Development (TDD), applying object-oriented design (OOD) 
principles, and reflecting on the use of generative AI tools. The project is divided 
into four phases with a recommended amount of time to spend on each phase.  For 
implementation phases, I will emphasize object-oriented design, write failing tests, 
implement code to pass the tests, and refactoring as needed.  I will use my code
to conduct a small experiment.  Additionally, I will have the opportunity to reflect 
on my use of generative AI tools in the project.

# Objectives
- Develop a well-documented board game simulation using Test-Driven Development (TDD) and 
object-oriented design (OOD) principles.
- Create multiple player strategies, each designed to address specific game scenarios.
- Integrate player strategies into the game simulation.
- Generate a report with data and analyses comparing player strategies' performance.
- Create a reflective assessment of the use of generative AI tools during the project.

# Project Phases

## Phase 1: Board Game Implementation (2 week)

In this phase I will implement the class structure for a board game.  It should be sufficient that I can
use these classes in conjunction with player related classes to play a complete game.

**Tasks:**
- Select a popular board game. This board game choice should have sufficient structure that I have at least 1 collection 
(aggregation relationship) and one generalization (inheritance relationship) hierarchy, adhering to object-oriented 
design principles. 
- Write failing tests to ensure the core game mechanics are correctly implemented.
- Implement the board game classes for those tests.
- Refactor the code to enhance clarity and maintainability.

## Phase 2: Player Classes and Strategies (1 week)

Using the class structure from **Phase 1** I will create a set of player classes and choose 3 strategies and implement the players
making choices.  Strategies can be as complex or as simple as I'd like.

**Tasks:**
-	Develop at least three distinct player strategies for my game.
-	Apply object-oriented design principles to design cohesive player and related classes.
-	Write failing tests for each player strategy to ensure they make valid and effective moves.
-	Implement the player strategy code.
- Integrate the player strategies into the game simulation while maintaining object-oriented design principles.

## Phase 3: Simulation and Comparison (1 week)

Using the class structures from **Phase 1** and **Phase 2**, to write a simulation and complete an experiment comparing my chosen strategies.

**Tasks:**
- Identify data that will provide me with insight into what is the best strategy.  All
simulations should report win rate, but I would add data that is appropriate for my game such as: currency collection, 
resource acquisition, average moves etc. to provide insight into what is happening in my simulation.
- Write a simulation class called SimulationExperiment which runs a simulation experiment where it plays
a series of games.  This class should have a main method that will run the complete simulation experiment
that is appropriate for my game and chosen player strategies:
  - I will have a 3 or more-player game, so I  would run a minimum of 60 trials with all strategies in play.  I may 
  conduct more trials with more than 3 players combining different strategies which may reveal more about how my 
  strategies behave in different combinations.
  - Report human-readable, well-formatted, experimental data for use in analysis. 
- Collect and analyze data on strategy performance based on win rates and additional data I have identified.
- Document my findings and comparisons of the player strategies. From the data I should identify which strategy 
is best, justify that choice, and explain why one strategy does better than the others.

## Phase 4: Finalization, and Reporting (1 week) 

**Tasks:**
- All reporting would be completed in the file located at the same level as the _src_ directory named **REPORT.md**. Please
leave the headings in this file unchanged.  This file is in Git markdown, a very 
simple formatting language which anyone can read more about here: 
[Git Markdown Instructions](https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax).

- All classes should be documented as specified in the Documentation Requirements below.
- All classes should testable as specified in Testing Requirements described below.
- Prepare a report that contains the following (word counts are maximums): 
  - A summary description of the game that I chose.  This should include the name of the game, the goal of the 
  game and a brief description of the key objects in the game.  I will provide a link to the game and/or its rules online. (100 words)
  - For each of 3 strategies I implemented, I'll name the strategy, and then description of it (100 words each) 
  - A description of my procedure for running the experiment on my code. This should include information 
  regarding the setup of the experiment in terms of what it runs and how it compares the player strategies, 
  the number of trials the experiment and what data was collected. (250 words)
  - A presentation on the results of my simulation of the strategies in table(s) or appropriate graphic(s) with 
  a short summary. (250 words)
  - An interpretation of my data explaining why one strategy is better than the other supported with data 
  from my experiment. (500 words)
  - A reflection on my experiences with generative AI during this project.  Where did I use it, how did it help, 
  where did it hinder my development (500 words)?  

# Technical Requirements

## Code Requirements
- All code would be in the Java programming language using Java 17 or higher using Java programming style conventions.
- My code should demonstrate good application of the principles of modularity, coupling, cohesion, and encapsulation within my object architecture.
- Data types and data structures would be appropriately chosen.  I may use classes from the Java Collections Framework (JCF) if appropriate.  Most commonly this will be ArrayList, Queue, Stack and PriorityQueue. 
- I would have a  SimulationExperiment class which contains a runnable main program that reproduces my experiment.
- I may use exceptions to manage failure conditions, which will simplify aspects of coding and testing.

## Testing Requirements
- I would use the provided test harness which applies JUnit5 via Gradle.  My classes would go in the main subdirectory
while the tests for those classes should be in the test subdirectory.   Tests must all run by calling _gradle test_.
- I would use JUnit5 assertion methods for my tests.
- All test methods would include a comment describing what I am testing and the key test cases in a short Javadoc string.

## Documentation Requirements
- I would write in a self-documenting code style which uses block commenting appropriately.
- All code would be documented with appropriate, descriptive docstrings and block level commenting to understand what the code does.
- I would follow all conventions of Javadoc strings including a description of the method purpose, parameters and return values.
- I would generate a Javadoc reference for my codebase.  This is done in IntelliJ through the Tools menu.


