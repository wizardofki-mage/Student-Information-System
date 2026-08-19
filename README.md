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
- The StudentBST's getHeight() method that I went with and that works is based on the one found on stackoverflow.com
- I added guards to check for null in the left and right nodes and to end recursion with the base case that both left and right equal null. The original poster "Michael" had just one method, and I split it into two to have a helper recursive method and to fit the interface of my implementation.
- I also came up with the return statement: return left > right ? 1 + left : 1 + right;.
- The nested if/else structure in the private int countLeaves(Treenode<E> root) helper method is based on the nested if/else statements from this source: https://www.youtube.com/watch?v=7ZWH0ZbUIcs Some of that method I figured out on my own such as if (root.left == null && root.right == null) return 1;
- I figured out the code for public boolean isFullBinaryTree() and its helper method entirely on my own after writing some pseudo code on a sheet of scratch paper.
- I figured out the code for public boolean isFullBinaryTree() and its helper method entirely on my own after writing some pseudo code on a sheet of scratch paper.
- All of the code is in SIS.java with multiple internal classes because this was one of the requirements of the assignment submission.



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
- After adding the second student, upon adding subsequent students, the program says the student ID is already there. However, the student is still successfully added to the BST and displays when the option to display all students is selected from the menu and when the student is searched for by ID number.
- After adding about three students' grades, the program says the student with the highest average is the last student to have grades entered.

## Release date
19 Aug, 2026

## Sources
- I figured out the code for public boolean isFullBinaryTree() and its helper method entirely on my own after writing some pseudo code on a sheet of scratch paper.
- I wrote the recursive BST insert(E e) method and its recursive helper method on my own after drawing a picture, writing a little pseudocode, and letting my subconscious work on it while I slept.
- I wrote the recursive find method in StudentBST on my own based on my insert method.
- I wrote the recursive delete() method in the StudentBST class on my own.
- My implementation for List, AbstractList, and ArrayList closely follows those of the textbook (Liang, 2024).
- The Tree<E> interface that extends Collection closely follows the textbook (Liang, 2024).
- The StudentBST's getHeight() method that I went with and that works is based on the one found on stackoverflow.com
- The nested if/else structure in the private int countLeaves(Treenode<E> root) helper method is based on the nested if/else statements from this source: https://www.youtube.com/watch?v=7ZWH0ZbUIcs
- The compareTo() method in the Student class is based on the syntax of compareTo() in section 21.6 of my textbook (Liang, 2024).


## Works Cited
- Liang, Y. Daniel. Introduction to Java Programming and Data Structures. 13th ed., Pearson Education Limited, 2024.
- Michael. “Java - Finding the Height of the Binary Tree - Stack Overflow.” Stack Overflow, 31 Dec. 2015, stackoverflow.com/questions/34539213/finding-the-height-of-the-binary-tree. Accessed: 02 Aug 2026.


## Acknowledgements
- Prof. Dr. Ibrahim AL-Agha is the project advisor.

## Contact
Jason Ash - wizardofki@gmail.com

## Disclaimer
These programs (Dinosaur.java and TestDinosaur.java) are released under the GNU Public License 3.0. This software and source code are expressly provided "AS IS." I (Jason Ash) MAKE NO WARRANTY OF ANY KIND, EXPRESS, IMPLIED, IN FACT, OR ARISING BY OPERATION OF LAW, INCLUDING, WITHOUT LIMITATION, THE IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, NON-INFRINGEMENT, AND DATA ACCURACY. I NEITHER REPRESENT NOR WARRANT THAT THE OPERATION OF THE SOFTWARE WILL BE UNINTERRUPTED OR ERROR-FREE, OR THAT ANY DEFECTS WILL BE CORRECTED. I DO NOT WARRANT OR MAKE ANY REPRESENTATIONS REGARDING THE USE OF THE SOFTWARE OR THE RESULTS THEREOF, INCLUDING BUT NOT LIMITED TO THE CORRECTNESS, ACCURACY, RELIABILITY, OR USEFULNESS OF THE SOFTWARE.
