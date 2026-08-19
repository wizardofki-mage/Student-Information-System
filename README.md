# Student-Information-System
This is my course project for Programming and Data Structures in Java, which stores student objects in a binary search tree and their grades in a custom ArrayList within each student object.

## Table of contents
* [General Info](#General-info)
* [Author](#Author)
* [Programming Approaches](#Programming-approaches)
* [Techologies](#Technologies)
* [Setup](#Setup)
* [Usage](#Usage)
* [Minimum hardware requirements](#Minimum-hardware-requirements)
* [Screenshots](#Screenshots)
* [Project status](#Project-status)
* [Room for improvement](#Room-for-improvement)
* [Release date](#Release-date)
* [Sources](#Sources)
* [Works Cited](#Works-Cited)
* [Acknowledgements](#Acknowledgements)
* [Contact](#Contact)
* [Disclaimer](#Disclaimer)

## General info
- Student Information System (SIS.java) is used to manage student records: add/remove students, view (by ID), edit (name/major), record grades, compute per-student averages, class averages, and find the highest-average student and the average of their grades.
- A Binary Search Tree, StudentBST, stores and manages all Student records keyed by String ID.
- Each student object that instantiates the Student class has its own ArrayList to store that student's grades.

## Author
- Jason Ash, Computer Science Major

## Programming approaches
- In StudentBST, to demonstrate knowledge of recursive methods, its insert, search, delete, and in-order traversal methods are all implemented using recursion.
- The custom ArrayList extends the AbstractList class, and both of these classes implement a List interface (since the interface specifies what methods List classes should have- an example of programming by contract).
- The custom ArrayList also uses generics, but not Comparable or iterator.
- I also followed a suggestion in the third chapter on sorted and unsorted lists in *Object-Oriented Data Structures* by N. Dale, D.T. Joyce, and C. Weems on returning a copy of the object that was gotten or removed from a list to ensure information hiding and better encapsulation. (This is only used in the places where it makes sense to do so and not if it is going to break something downstream).


## Technologies:
I wrote the source code in Notepad in Windows 11, compiled it in the Command Prompt using the javac command, and ran it using the java command.

## Setup
To compile these .java files into Java bytecode, you can use the command line like I did or your favorite IDE of choice.

## Usage
- After running the TestDinosaur.class file with the Dinosaur.class file in the same directory, a Welcome message will appear, and the first two dinosaurs that display are just a test of the first two overloaded constructors and the overridden toString() method in the Dinosaur class.
- You can then enter 1, 2, or 3 to rename, change the age, or change the species of a dinosaur, respectively. Entering 4 will display the table of the dinosaurs with their respective names, ages, and species. Entering 5 will end the program.
- If 1, 2, or 3 is entered from the main menu, then you can select 1 to change an attribute of one dinosaur, 2 to change that attribute for all the dinosaurs, or 3 to cancel the operation within each submenu, respectively.

## Minimum hardware requirements
Although I developed this on a fairly recent Windows 11 PC, this program should run comfortably on any working computer with sufficient processing power, RAM, a monitor manufactured within the past 15-20 years, and an Internet connection to download the .java source files. 

## Screenshots
![A screen capture of the TestDinosaur program being ran.](TestDinosaurSampleOutput.png)

## Project status
Since it satisfies and exceeds the requirements of the Chapter 8 Exercise 1 in this textbook, I'm releasing my solution on GitHub.

## Room for improvement
- I could polish the interface a little more and even add a GUI later when I start to learn about Java Swing components.
- I could eventually program it so that the user can add and delete dinosaurs when I learn how to do that.
- I could save the dinosaur "database" to a file and read it from a file after I learn how to do that.

## Release date
19 Aug, 2026

## Sources
- My implementation for List, AbstractList, and ArrayList closely follows those of the textbook (Liang, 2024).
- The Tree<E> interface that extends Collection closely follows the textbook (Liang, 2024).
- The getHeight() method that I went with and that works is based on the one found on stackoverflow.com

## Works Cited
- Liang, Y. Daniel. Introduction to Java Programming and Data Structures. 13th ed., Pearson Education Limited, 2024.
- Michael. “Java - Finding the Height of the Binary Tree - Stack Overflow.” Stack Overflow, 31 Dec. 2015, stackoverflow.com/questions/34539213/finding-the-height-of-the-binary-tree. Accessed: 02 Aug 2026.


## Acknowledgements
- Prof. Dr. Ibrahim AL-Agha is the project advisor.

## Contact
Jason Ash - wizardofki@gmail.com

## Disclaimer
These programs (Dinosaur.java and TestDinosaur.java) are released under the GNU Public License 3.0. This software and source code are expressly provided "AS IS." I (Jason Ash) MAKE NO WARRANTY OF ANY KIND, EXPRESS, IMPLIED, IN FACT, OR ARISING BY OPERATION OF LAW, INCLUDING, WITHOUT LIMITATION, THE IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, NON-INFRINGEMENT, AND DATA ACCURACY. I NEITHER REPRESENT NOR WARRANT THAT THE OPERATION OF THE SOFTWARE WILL BE UNINTERRUPTED OR ERROR-FREE, OR THAT ANY DEFECTS WILL BE CORRECTED. I DO NOT WARRANT OR MAKE ANY REPRESENTATIONS REGARDING THE USE OF THE SOFTWARE OR THE RESULTS THEREOF, INCLUDING BUT NOT LIMITED TO THE CORRECTNESS, ACCURACY, RELIABILITY, OR USEFULNESS OF THE SOFTWARE.
