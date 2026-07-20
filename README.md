# TowerOfHanoi

🗼 Tower of Hanoi Solver

An animated, GUI-based solver for the classic Tower of Hanoi puzzle — built with a custom linked stack and the Observer pattern to visually animate each move as the recursive algorithm solves the puzzle in real time.

🎓 Built for CS 2114: Software Design & Data Structures at Virginia Tech

🚀 What It Does

The program sets up three poles and a configurable number of disks, then lets you watch the classic recursive algorithm solve the puzzle move-by-move:

🧱 Disks are randomly colored and stacked largest-to-smallest on the left pole
▶️ Clicking Solve kicks off the recursive algorithm on a background thread
🎥 Every move is animated with a short delay so you can actually watch the strategy unfold
🚫 Illegal moves (placing a larger disk on a smaller one) are prevented at the data-structure level
🏗️ Architecture
File	Purpose
ProjectRunner.java	🎬 Entry point — creates the solver and launches the window
HanoiSolver.java	🧠 Recursive solving algorithm; notifies observers of each move
PuzzleWindow.java	🖥️ GUI — renders poles/disks and animates moves as they happen
Tower.java	🗼 A pole in the puzzle — enforces the "no larger disk on smaller disk" rule
LinkedStack.java	🔗 Custom generic stack implementation (backs each Tower)
Disk.java	🎨 A single disk — randomly colored, comparable by width
Position.java	📍 Enum representing the LEFT / MIDDLE / RIGHT poles
⚙️ How to Run
bash
javac towerofhanoi/*.java
java towerofhanoi.ProjectRunner

A window will open with 6 disks stacked on the left pole. Click Solve to watch it play out.

Want more or fewer disks? Change the disks value in ProjectRunner.main().

🧠 Key Design Points
Observer pattern — HanoiSolver extends Observable and notifies PuzzleWindow after every move, fully decoupling the solving logic from the rendering logic
Custom LinkedStack — no built-in Java Stack; disks are pushed/popped via a hand-rolled linked-node stack
Self-enforcing invariant — Tower.push() throws if you try to stack a larger disk on a smaller one, so illegal states are impossible by construction
Threaded animation — solving runs on a background thread so the GUI stays responsive while disks animate
👩‍💻 Author

Built by Linda — Virginia Tech, CS 2114
