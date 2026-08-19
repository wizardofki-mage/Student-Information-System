/*
Author: Jason Ash
Professor: Dr. AL-Agha
Course: CSCI 2350, Programming and Data Structures, Summer E-Learn2
Date: 2026 Aug 03 to 2026 Aug 06
File: SIS.java
Description: Final Project: Student Information System (SIS) is used to manage student records: add/remove students, view (by ID), edit (name/major), record grades, compute per-student and class averages, and find the hightest average student and the average of their grades. A Binary Search Tree, StudentBST, stores and manages all Student records keyed by String ID and implements recursive insert, search, delete, and in-order traversal for listing. Each student object that instantates the Student class has its own ArrayList to store that student's grades. The choice of these Abstract Data Structures can be justified in that the BST is best for storing students and an ArrayList is best for storing grades within each student, and these are the strict Data Structure Requirements for this Final Project Assignment. Grades can be added for each student, grades can be listed for the student, student average grade can be caluclated and viewed, the class average grade can be calculated and viewed, and the hightest-average student. The ArrayList used is a custom one from Lab 5's implementation that extends AbstractList class and both of them implement a List interface.

Sources: My implementation for List, AbstractList, and ArrayList closely follow what is in our textbook since they use generics but not comparable or iterator. I also followed a suggestion in the third chapter on sorted and unsorted lists in Object-Oriented Data Structures by N. Dale, D.T. Joyce, and C. Weems on returning a copy of the object that was gotten or removed from a list to ensure information hidding and better encapsulation. (This is only used in the places where it makes sense to do so and not if it is going to break something downstream).

The unaltered template Tree<E> interface extending Collection (and therefore giving it access to Collection<E>'s methods) were provided on Moodle for Lab 6.

The StudentBST class is based on the BST.java template that was, in turn, based on the textbook's/Resource book's implementation from Moodle for Lab 6. The getHeight() method that I went with and that works is based on https://stackoverflow.com/questions/34539213/finding-the-height-of-the-binary-tree
I added guards to check for null in the left and right nodes and to end recursion with the base case that both left and right equal null. The original poster "Michael" had just one method, and I split it in two to have a helper recursive method and to fit the interface of our implementation. I also came up with the return statement: return left > right ? 1 + left : 1 + right;.

The nested if/else structure in the private int countLeaves(Treenode<E> root) helper method is based on the nested if/else statements from this source: https://www.youtube.com/watch?v=7ZWH0ZbUIcs Some of that method I figured out on my own such as if (root.left == null && root.right == null) return 1;

I figured out the code for public boolean isFullBinaryTree() and its helper method entirely on my own after writing some pseudo code on a sheet of scratch paper.

I used the Suggested Single File Structure Template on the Final Project Description page as a starting point for the Student class. All the rest of the code in that class is my own except for the syntax of the compareTo() method which is based on the syntax of compareTo() in section 21.6 of our textbook.

I wrote the recursive insert method and its recursive helper method on my own after drawing a picture, writing a little pseduocode, and letting my subconscious work on it while I slept. I wrote the recrusive find method in StudentBST on my own based on my insert method. I wrote the recursive delete method in the StudentBST on my own. Once the element is found to delete, the logic is similar to the iterative method provided in the template for BST in Lab 6.

I had to look up what java.util.function.Consumer was for my version of the recursive inorder() with the search key words "what is java util function consumer" on
https://www.google.com/search?q=what+is+java+util+function+consumer&rlz=1C1CHBF_enUS924US924&oq=what+is+java.util.function.Consumer&gs_lcrp=EgZjaHJvbWUqCAgBEAAYFhgeMgYIABBFGDkyCAgBEAAYFhgeMgoIAhAAGAoYFhgeMgcIAxAAGO8FMgoIBBAAGKIEGIkFMgcIBRAAGO8FMgcIBhAAGO8F0gEJNzc1MzlqMGo3qAIAsAIA&sourceid=chrome&source=chrome.ob&ie=UTF-8

I searched Google for "how would you use Consumer in java to print the elements in order in a binary search tree that are student objects that have the toString method?" and followed up with the prompt: "The traversal needs to use recursion. I just need code for the traversal method that prints students, please." The following code is based on what it gave me, but I use a private helper methods and I check to see if right or left are null before recusively calling the helper method on them. I also went with generic <E> instead of <Student>. I also changed the code to fit our implementation of BST.
https://www.google.com/search?q=how+would+you+use+Consumer+in+java+to+print+the+elements+in+order+in+a+binary+search+tree+that+are+student+objects+that+have+the+toString+method%3F&rlz=1C1CHBF_enUS924US924&gs_lcrp=EgZjaHJvbWUyBggAEEUYOdIBCjU1NDMwajBqMTWoAgiwAgHxBaOprLfqSLxa8QWjqay36ki8Wg&sourceid=chrome&ie=UTF-8&udm=50&fbs=ABfTbFVyMZGZf1hfvX9uKjN_-G8cqu7ocb7U6ah0xpkIrGMK4AD-5zQwT5IfpPJ6og2sC2IXdmIqakpXvaGorGwhS-OJs8VccvlD1MGF13c4vQEZ6BOD3Pux5R5lRiN8ciO8Slgl0BUnHh_G26N4HW8fBW4mkNU_voP8HrIeXqVfCc2UPr_YSNPgncxR2WyFnMp5o-T5_iziM1OYX83ka-_PDKYbfe8RNQ&aep=10&ntc=1&mstk=AUtExfD6AbhBbmZUfmrAzZyD8Dr0rjUUmC4WXHZaMVERHqTlZpyli5vWWX_yilihu2gRPjsnyBtL-ey574zQv88_3Hz9miQgF7l2EFqWxB2kMWVMTGkdA3FXdI1iJqn7LOVSilBy2qNkxuqrsQFjloDIBUwP_LjZtOk5e9qaquLJ4VLixVWl8nrz0UE0QtBUClISyv6qZHx6Xyq_UNXzTiyRwOvQnJm0BXZlrMWqxCBGPW_mSSioSasB4T6SdWdtiz7wq6Pa1FMgzUHujgRRQy8epu2d4aKCEzMk9Yyq44uYrpXghvFfUQWtTrKJ61qhK4kCWXFoxpN0DgYu375Gs7ZxUvf-61du1wjMOA&aioh=3&csuir=1&cs=1&atvm=2&mtid=BpNzavndO_jIkPIPuMG28A8

I searched Google for how to compare a double to Double.NaN for studentAverageUI() in the SIS class, and it's AI search summary suggested using Double.isNaN(value). Key words: "how to check if a double equals Double.NaN in java"
	https://www.google.com/search?q=how+to+check+if+a+double+equals+Double.NaN+in+java&rlz=1C1CHBF_enUS924US924&oq=how+to+check+if+a+double+equals+Double.NaN+in+java&gs_lcrp=EgZjaHJvbWUyBggAEEUYOTIHCAEQIRigATIHCAIQIRigATIHCAMQIRigATIHCAQQIRigATIHCAUQIRigATIHCAYQIRiPAtIBCTEyNzg0ajBqN6gCALACAA&sourceid=chrome&source=chrome.ob&ie=UTF-8

*/

import java.util.Collection;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.function.Consumer;
import java.util.Iterator;

// Below are the List interface, AbstractList class, and ArrayList class originally used in my PriorityQueue submission in Lab5. (I figured why reinvent the wheel).
interface List<E>
{
	// Append an element to the end of the list
	void add(E e);

	// Insert elements at a specified index
	void add(int index, E e);

	// Remove all elements from the list
	void clear();

	// Check if element exists
	boolean contains(E e);

	// Retrieve element at specified index
	E get(int index);

	// Get index of specified element
	int indexOf(E e);
	
	// Check if list is empty
	boolean isEmpty();

	// Get last occurrence of element
	int lastIndexOf(E e);

	// Remove element
	boolean remove(E e);

	// Remove element at index
	E remove(int index);

	// Replace element
	Object set(int index, E e);

	// Get number of elements
	int size();
} // end List<E> interface

abstract class AbstractList<E> implements List<E>
{
	// Stores the number of elements
	protected int size = 0;

	@Override
	public boolean isEmpty()
	{
		return size == 0;
	}

	@Override
	public int size()
	{
		return size;
	}

	@Override
	public boolean remove(E e)
	{
		if (indexOf(e) >= 0)
		{
			remove(indexOf(e));
			return true;
		}
		else
		{
			return false;
		}
	}

	// Append an element to the end of the list
	public abstract void add(E e);

	// Insert elements at a specified index
	public abstract void add(int index, E e);

	// Remove all elements from the list
	public abstract void clear();

	// Check if element exists
	public abstract boolean contains(E e);

	// Retrieve element at specified index
	public abstract E get(int index);

	// Get index of specified element
	public abstract int indexOf(E e);
	
	// Get last occurrence of element
	public abstract int lastIndexOf(E e);

	// Remove element at index
	public abstract E remove(int index);

	// Replace element
	public abstract Object set(int index, E e);
} // end AbstractList<E> abstract class

class ArrayList<E> extends AbstractList<E> implements List<E>
{
	public static final int INITIAL_CAPACITY = 16;

	private E[] data = (E[])(new Object[INITIAL_CAPACITY]);

	// Number of elements in the list
	// private int current = 0;

	// Create an empty list with no-arg constructor
	public ArrayList()
	{
	}

	// Create a list from an array of objects
	public ArrayList(E[] e)
	{
		E item;
		for (int i = 0; i < e.length; i++)
		{
			item = e[i];
			// Warning: don't use super(objects)!
			add(item);
		}
	}

	// Add a new element at the specified index
	@Override
	public void add(int index, E e)
	{
		if (index < 0 || index > size)
		{
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}

		ensureCapacity();

		// Move the elements to the right after the specified index
		for (int i = size - 1; i >= index; i--)
		{
			data[i + 1] = data[i];
		}

		// Insert new element at data[index]
		E item = e;
		data[index] = item;

		// Increase size by 1
		size++;
	}

	@Override
	public void add(E e)
	{
		ensureCapacity();
		E item = e;
		data[size] = item;
		size++;
	}

	// A helper method that creates a new larger array by doubling the current size + 1
	private void ensureCapacity()
	{
		if(size >= data.length)
		{
			E[] newData = (E[])(new Object[size * 2 + 1]);
			copy(data, newData);
			data = newData;
		}
	}

	private void copy(E[] myData, E[] resizedData)
	{	
		// Avoid ArrayIndexOutOfBounds error
		int maxIndex = 0;
		maxIndex = (myData.length <= resizedData.length) ? myData.length : resizedData.length;

		for(int i = 0; i < maxIndex; i++)
		{
			resizedData[i] = data[i]; 
		} // end for loop
	} // end copy()

	// Clear the list. Dangerous: use only if intended
	@Override
	public void clear()
	{
		data = (E[])(new Object[INITIAL_CAPACITY]);
		size = 0;
	}

	// Return true if this list contains the element
	@Override
	public boolean contains(E e)
	{
		for(int i = 0; i < size; i++)
		{
			if (e.equals(data[i]))
			{
				return true;
			}
		}
		return false;
	}

	// Return the element at the specified index
	@Override
	public E get(int index)
	{
		checkIndex(index);
		return data[index];
	}

	// Helper method that throws an IndexOutOfBoundsException if the index is out-of-bounds
	private void checkIndex(int index)
	{
		if (index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
	}

	// Return the index of the first matching element in this list. Return -1 if there is no match.
	@Override
	public int indexOf(E e)
	{
		for (int i = 0; i < size; i++)
		{
			if (e.equals(data[i]))
			{
				return i;
			}
		}

		return -1;
	}

	// Return the index of the last matching element in this list. Return -1 if there is no match
	@Override
	public int lastIndexOf(E e)
	{
		for(int i = size - 1; i >=0; i--)
		{
			if(e.equals(data[i]))
			{
				return i;
			}
		}

		return -1;
	}

	// Remove the element at the specified position in this list. Shift any subsequent elements to the left. Return the element that was removed from the list.
	@Override
	public E remove(int index)
	{
		checkIndex(index);
		E e = data[index];
		
		// Shift data to the left
		for(int j = index; j < size - 1; j++)
		{
			data[j] = data[j + 1];
		}

		// This element is now null
		data[size - 1] = null;

		// Decrement size
		size--;
		// current--;
		
		return e;
	}

	// Replace the element at the specified position in this list with the specified element
	@Override
	public Object set(int index, E e)
	{
		checkIndex(index);
		ensureCapacity();
		E old = data[index];
		data[index] = e;
		return old;
	}

	@Override
	public String toString()
	{
		StringBuilder result = new StringBuilder("[");

		for (int i = 0; i < size; i++)
		{
			result.append(String.valueOf(data[i]));
			if (i < size - 1)
			{
				result.append(", ");
			}
		}
		return result.toString() + "]";
	}

	// Trims the capacity to current size
	public void trimToSize()
	{
		if(size != data.length)
		{
			E[] newData = (E[])(new Object[size]);
			copy(data, newData);
			data = newData;
		}
	}
} // end ArrayList<E> class

interface Tree<E> extends Collection<E>
{
	// Return true if the element is in the tree.
	public boolean search(E e);

	// Insert element e into the binary tree. Return true if the element is inserted successfully.
	public boolean insert(E e);

	// Delete the specified element from the tree. Return true if the element is deleted successfully.
	public boolean delete(E e);
  
	//Get the number of elements in the tree.
	public int getSize();
  
	// Inorder traversal from the root.
	public abstract void inorder();

	// Postorder traversal from the root.
	public abstract void postorder();

	// Preorder traversal from the root.
	public abstract void preorder();

	// Return true if the tree is empty.  
	@Override
	public default boolean isEmpty()
	{
    		return this.size() == 0;
	}

	@Override
	public default boolean contains(Object e)
	{
		return search((E)e);
	}
  
	@Override
	public default boolean add(E e)
	{
		return insert(e);
	}
  
	@Override
	public default boolean remove(Object e)
	{
		return delete((E)e);
	}
  
	@Override
	public default int size()
	{
		return getSize();
	}
  
	@Override
	public default boolean containsAll(Collection<?> c)
	{
		// Left as an exercise
		return false;
	}

	@Override
	public default boolean addAll(Collection<? extends E> c)
	{
	// Left as an exercise
	return false;
	}

	@Override
	public default boolean removeAll(Collection<?> c)
	{
		// Left as an exercise
		return false;
	}

	@Override
	public default boolean retainAll(Collection<?> c)
	{
		// Left as an exercise
		return false;
	}

	@Override
	public default Object[] toArray()
	{
		// Left as an exercise
		return null;
	}

	@Override
	public default <T> T[] toArray(T[] array)
	{
		// Left as an exercise
		return null;
	}
} // end Tree<E> interface

class StudentBST<E> implements Tree<E>
{
	private TreeNode<E> root;
	protected int size = 0;
	protected java.util.Comparator<E> c; 

	// Create a default BST with a natural order comparator.
	public StudentBST()
	{
		this.c = (e1, e2) -> ((Comparable<E>)e1).compareTo(e2);
	}

	// Create a BST with a specified comparator.
	public StudentBST(java.util.Comparator<E> c)
	{
		this.c = c;
	}

	// Create a binary tree from an array of objects.
	public StudentBST(E[] objects)
	{
		this.c = (e1, e2) -> ((Comparable<E>)e1).compareTo(e2);
		for (int i = 0; i < objects.length; i++)
		insert(objects[i]);
	}

	// Returns true if the element is in the tree.
	@Override
	public boolean search(E e)
	{
		// Start from the root
		TreeNode<E> current = root; 

		while (current != null)
		{
			if (c.compare(e, current.element) < 0)
			{
        			current = current.left;
			}
			else if (c.compare(e, current.element) > 0)
			{
				current = current.right;
			}
			// element matches current.element
			else
			{
				// Element is found.
        			return true; 
   			}
		}
		return false;
	}

	// This find method was based on my insert method since insert is a "failed" search per the Zoom checking with Dr. AL-Agha on Aug. 05, 2026.
	// I already realized that the two methods were similar because you have to find where something needs to be inserted before adding it to the tree.
	public E find(E e)
	{
		// If the tree is empty return null because nothing is in the tree
		if (root == null)
		{
			return null;
		}
		else
		{
			// Create a TreeNode<E> called current, point it to root, and call the private recursive helper method.
			TreeNode<E> current = root;
			return find(current, e);
		}
	}

	// Overall, this recursive helper method keeps calling itself on the left or right of current until it finds the id that matches the student (returning a copy of the student object) or fails to (returning null).
	private E find(TreeNode<E> current, E e)
	{
		if (current == null)
		{
			return null;
		}
		if(c.compare(e, current.element) == 0)
		{
			// Decided against returning a copy of the object in this case contrary to the suggestion of Dale, Joyce and Weems because doing so could break things downstream.
			// This is one base case where the student was found.
			// E copyOfE = (E)new Object();
			// copyOfE = (E)current.element;
			return (E)current.element;
		}
		// If current.left does not equal null (isn't non-existent) and the e element that you are trying to find is less than what is inside the current element, recursively call this method on current.left.
		// In other words, if the element you are trying to find is less than the current element, you can only go left.
		else if (current.left != null && c.compare(e, current.element) < 0)
		{
			return find(current.left, e);
		}
		// If current.right does not equal null (isn't non-existent) and the e element that you are trying to find is greater than what is inside the current element, recursively call this method on current.right.
		// In other words, if the element you are trying to find is greater than the current element, you can only go right.
		else if (current.right != null && c.compare(e, current.element) > 0)
		{
			return find(current.right, e);
		}
		else
		{
			// If none of the above apply, then return null because the student was not found.
			return null;
		}		
	}

	// I wrote the insert method and its recursive helper method on my own after drawing a picture, writing a little pseduocode, and letting my subconscious work on it while I slept.
	@Override
	public boolean insert(E e)
	{
		// If the tree is empty, create a node and have the root reference it.
		if (root == null)
		{
			root = createNewNode(e);
			return true;
		}
		else
		{
			// Create a TreeNode<E> called current, point it to root, and call the private recursive helper method.
			TreeNode<E> current = root;
			return insert(current, e);
		}
	}

	// Overall, this recursive helper method keeps calling itself on the left or right of current until it find the place to insert the node with the new element or returns false in the case of a duplicate.
	private boolean insert(TreeNode<E> current, E e)
	{
		// If current.left does not equal null (isn't non-existent) and the e element that you are trying to insert is less than what is inside the current element, recursively call this method on current.left.
		// In other words, if the element you are trying to insert is less than the current element, you can only go left.
		if (current.left != null && (c.compare(e, current.element) < 0))
		{
			insert(current.left, e);
		}
		// If current.right does not equal null (isn't non-existent) and the e element that you are trying to insert is greater than what is inside the current element, recursively call this method on current.right.
		// In other words, if the element you are trying to insert is greater than the current element, you can only go right.
		else if (current.right != null && (c.compare(e, current.element) > 0))
		{
			insert(current.right, e);
		}
		else if (current.left == null && (c.compare(e, current.element) < 0))
		{
			// If current.left is null, and the e element that you are trying to insert is less than what is inside the current element, then create and new node with e as its element, and have current.left point to it.
			// Current is the parent node in this case.
			current.left = createNewNode(e);
			// element inserted successfully, so increase size and return true to let the caller know that it was inserted successfully.
			size++;
			return true;
		}
		else if (current.right == null && (c.compare(e, current.element) > 0))
		{
			// If current.right is null, and the e element that you are trying to insert is greater than what is inside the current element, then create and new node with e as its element, and have current.right point to it.
			// Current is the parent node in this case.
			current.right = createNewNode(e);
			// element inserted successfully, so increase size and return true to let the caller know that it was inserted successfully.
			size++;
			return true;
		}
		// If all of the above are false, then the element is a duplicate, so don't insert a node, and return false.
		// I couldn't put this in an else statement because the compiler couldn't find the return statement.
		return false;
	}

	protected TreeNode<E> createNewNode(E e)
	{
		return new TreeNode<>(e);
	}

	/*
	I searched Google for "how would you use Consumer in java to print the elements in order in a binary search tree that are student objects that have the toString method?" and followed up with the prompt: "The traversal 		needs to use recursion. I just need code for the traversal method that prints students, please." The following code is based on what it gave me, but I use a private helper methods and I check to see if right or left are 		null before recusively calling the helper method on them. I also went with generic <E> instead of <Student>. I also changed the code to fit our implementation of BST.
	https://www.google.com/search?q=how+would+you+use+Consumer+in+java+to+print+the+elements+in+order+in+a+binary+search+tree+that+are+student+objects+that+have+the+toString+method%3F&rlz=1C1CHBF_enUS924US924&gs_lcrp=EgZjaHJvbWUyBggAEEUYOdIBCjU1NDMwajBqMTWoAgiwAgHxBaOprLfqSLxa8QWjqay36ki8Wg&sourceid=chrome&ie=UTF-8&udm=50&fbs=ABfTbFVyMZGZf1hfvX9uKjN_-G8cqu7ocb7U6ah0xpkIrGMK4AD-5zQwT5IfpPJ6og2sC2IXdmIqakpXvaGorGwhS-OJs8VccvlD1MGF13c4vQEZ6BOD3Pux5R5lRiN8ciO8Slgl0BUnHh_G26N4HW8fBW4mkNU_voP8HrIeXqVfCc2UPr_YSNPgncxR2WyFnMp5o-T5_iziM1OYX83ka-_PDKYbfe8RNQ&aep=10&ntc=1&mstk=AUtExfD6AbhBbmZUfmrAzZyD8Dr0rjUUmC4WXHZaMVERHqTlZpyli5vWWX_yilihu2gRPjsnyBtL-ey574zQv88_3Hz9miQgF7l2EFqWxB2kMWVMTGkdA3FXdI1iJqn7LOVSilBy2qNkxuqrsQFjloDIBUwP_LjZtOk5e9qaquLJ4VLixVWl8nrz0UE0QtBUClISyv6qZHx6Xyq_UNXzTiyRwOvQnJm0BXZlrMWqxCBGPW_mSSioSasB4T6SdWdtiz7wq6Pa1FMgzUHujgRRQy8epu2d4aKCEzMk9Yyq44uYrpXghvFfUQWtTrKJ61qhK4kCWXFoxpN0DgYu375Gs7ZxUvf-61du1wjMOA&aioh=3&csuir=1&cs=1&atvm=2&mtid=BpNzavndO_jIkPIPuMG28A8

	Google's AI said that passing System.out::println as the argument for Consumer<Student> action automatically invokes the toString() method of the Student object.
	*/

	public void inorder()
	{
		if (root == null)
		{
			return;
		}
		else
		{
			inorder(root, System.out::println);
		}
		
	}
	private void inorder(TreeNode<E> root, Consumer<E> action)
	{
		if(root.left != null)
		{
			inorder(root.left, action);
		}
		action.accept(root.element);
		if(root.right != null)
		{
			inorder(root.right, action);
		}
	}

	// An earlier, incomplete, non-functional attempt.
	/*public void inorder()
	{
        	Consumer<TreeNode> printNode = str -> System.out.println(root.element);
		root.forEach(printNode); 
		forEach
	} */ 

	// Postorder traversal from the root
	@Override 
	public void postorder()
	{
		postorder(root);
	}

	// Postorder traversal from a subtree
	protected void postorder(TreeNode<E> root)
	{
		if (root == null) return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.element + " ");
	}

	// Preorder traversal from the root.
	@Override
	public void preorder()
	{
		preorder(root);
	}

	// Preorder traversal from a subtree
	protected void preorder(TreeNode<E> root)
	{
		if (root == null) return;
		System.out.print(root.element + " ");
		preorder(root.left);
		preorder(root.right);
	}

	// This inner class is static, because it does not access any instance members defined in its outer class.
	static class TreeNode<E>
	{
		protected E element;
		protected TreeNode<E> left;
		protected TreeNode<E> right;

		public TreeNode(E e)
		{
			element = e;
		}
	}

	// Get the number of nodes in the tree.
	@Override
	public int getSize()
	{
		return size;
	}

	// Returns the root of the tree.
	public TreeNode<E> getRoot()
	{
		return root;
	}

	// Returns a path from the root leading to the specified element.
	public java.util.ArrayList<TreeNode<E>> path(E e)
	{
		java.util.ArrayList<TreeNode<E>> list = new java.util.ArrayList<>();
		// Start from the root
		TreeNode<E> current = root; 

		while (current != null)
		{
			// Add the node to the list
			list.add(current); 
			if (c.compare(e, current.element) < 0)
			{
				current = current.left;
			}
			else if (c.compare(e, current.element) > 0)
			{
				current = current.right;
			}
			else
			{
				break;
			}
		}

		return list; // Return an array list of nodes
	}

	// Delete an element from the binary search tree. Return true if the element was deleted successfully, or false if the element is not in the tree.
	@Override
	public boolean delete(E e)
	{
		TreeNode<E> current = root;

		// If the tree is empty, return false.
		if(current == null)
		{
			return false;
		}
		// Otherwise, kick off recursion by calling the private helper delete method from root.
		return delete(null, current, e);
	}

	/* The private helper method that does the actual heavy lifting.
	I can't seem to get away from the method needing to know the parent to reattach the tree correctly and handle cases 1 and 2.
	Also, the logic once found is similar to the iterative method.
	*/
	private boolean delete(TreeNode<E> parent, TreeNode<E> current, E e)
	{
		// One base case, element not found because current = null. In this case, return false.
		if (current == null)
		{
			return false;
		}
		else if(c.compare(e, current.element) < 0)
		{
			parent = current;
			return delete(parent, current.left, e);
		}
		else if(c.compare(e, current.element) > 0)
		{
			parent = current;
			return delete(parent, current.right, e);
		}
		// Another base case, element found.
		else if (c.compare(e, current.element) == 0)
		{
			// Case 1: root/current has no left child:
			if (current.left == null)
			{
				// Handle if the root is the only node in the tree. In this case, parent = null.
				if (parent == null)
				{
					root = current.right;
				}
				else
				{
					if (c.compare(e, parent.element) < 0)
					{
						parent.left = current.right;
					}
					else
					{
						parent.right = current.right;
					}
				}
			}
			else
			{
				// Case 2: The current node has a left child. In this case, locate the rightmost node in the left subtree of the current node and also its parent.
				TreeNode<E> parentOfRightMost = current;
				TreeNode<E> rightMost = current.left;
				parentOfRightMost = locateRightMostAndItsParent(parentOfRightMost, rightMost);
				
				// Replace the element in current by the element in rightmost.
				rightMost = parentOfRightMost.right;
				current.element = rightMost.element;

				// Now, eliminate rightmost node.
				if (parentOfRightMost.right == rightMost)
				{
        				parentOfRightMost.right = rightMost.left;
				}
				else
				{
					// Special case: parentOfRightMost == current
       					parentOfRightMost.left = rightMost.left;     
				}
			}
			// If case 1 or 2 exectued successfully, reduce the size of the tree by 1.
			size--;
		
			// Since the element deleted successfully, return true;
			return true;
		}
		else
		{
			// Since the compiler cannot find a return statement without the following return statement, return false should the program flow ever reach this else clause.
			return false;
		}
	}

	// A private helper method that returns the parent of rightMost because returning rightMost would lose its parent.
	private TreeNode<E> locateRightMostAndItsParent(TreeNode<E> parentOfRightMost, TreeNode<E> rightMost)
	{
		if(rightMost.right != null)
		{
			// Keep going to the right, recursively
			locateRightMostAndItsParent(rightMost, rightMost.right);
		}
		return parentOfRightMost;
	}

	// Obtain an iterator. Use inorder.
	@Override
	public java.util.Iterator<E> iterator()
	{
		return new InorderIterator();
	}

	// Inner class InorderIterator
	private class InorderIterator implements java.util.Iterator<E>
	{
		// Store the elements in a list
		private java.util.ArrayList<E> list = new java.util.ArrayList<>();

		// Point to the current element in list.
		private int current = 0; 

		public InorderIterator()
		{
			// Traverse binary tree and store elements in list
			inorder();
		}

		// Inorder traversal from the root
		private void inorder()
		{
			inorder(root);
		}

		// Inorder traversal from a subtree
		private void inorder(TreeNode<E> root)
		{
			if (root == null) return;
			inorder(root.left);
			list.add(root.element);
			inorder(root.right);
		}

		// More elements for traversing?
		@Override 
		public boolean hasNext()
		{
			if (current < list.size())
			{
				return true;
			}
			return false;
		}

		// Get the current element and move to the next.
		@Override 
		public E next()
		{
			return list.get(current++);
		}

		// Remove the element returned by the last next()
		@Override
		public void remove()
		{
			// next() has not been called yet
			if (current == 0)
			{
        			throw new IllegalStateException();
			}
			delete(list.get(--current)); 

			// Clear the list
			list.clear();
			
			// Rebuild the list
			inorder(); 
		}
	}

	// Remove all elements from the tree.
	@Override 
	public void clear()
	{
		root = null;
		size = 0;
	}

	/* The getHeight() attempt that I went with:
	Based on https://stackoverflow.com/questions/34539213/finding-the-height-of-the-binary-tree
	I added guards to check for null in the left and right nodes and to end recursion with the base case that both left and right equal null.
	The original poster "Michael" had just one method, and I split it in two to have a helper recursive method and to fit the interface of our implementation.
	A tree with just the root has a height of 0, and the output is the number of verticies from the root in the longest branch.
	Returns the height of the tree. */
 	public int getHeight()
	{
		TreeNode<E> current = root;

    		// If the root = null, the tree is empty, and by convention, per our textbook, and empty tree has a height of -1
		if (current == null)
		{
			return -1;
		}
		// Otherwise, kick off recursion by calling the private helper method
		return getHeight(current);		
	}

	// It makes more sense to call the node passed to the private helper method root instead of current
	private int getHeight(TreeNode<E> root)
	{
		int left = 0;
		int right = 0;
		// Base case for recursion or if the root is the only node in the tree or if you reach a leaf
		if (root.left == null && root.right == null)
		{
			return 0;
		}
		// Check that root.left and root.right do not equal null before recursively calling this method.
		if (root.left != null)
		{
			left = getHeight(root.left);
		}
		if (root.right != null)
		{
			right = getHeight(root.right);
		}
		// return the greater of the left subtree or right subtree, and add one each time to recursion to keep track of the height.
		return left > right ? 1 + left : 1 + right;
	}

	// Counts the number of leaf nodes in the tree.
	// Once I understood how to get the height, I used that as a starting point for countLeaves, but I still needed a little help with the logic wrote.
	public int countLeaves()
	{
		TreeNode<E> current = root;
		// An empty tree has 0 leaves
		if(root == null)
		{
			return 0;
		}

    		// Kick off recursion by calling the private helper method
		return countLeaves(current);		
	}

	// The nested if/else statements worked best from this source: https://www.youtube.com/watch?v=7ZWH0ZbUIcs
	// Therefore, the code below is based on the structure in that video.
	private int countLeaves(TreeNode<E> root)
	{
		if(root != null)
		{
			// if root is the only node or you have reached a leaf, then return 1. I figured this part out on my own. This is one base case to stop recursion.
			if (root.left == null && root.right == null)
			{
				return 1;
			}
			else
			{
				// You still need to check that root.left and root.right are not equal null before recursively calling this method
				// Something I tried earlier that I decided not to go with: return (root.left != null ? countLeaves(root.left) : 0) + (root.right != null ? countLeaves(root.left) : 0);
				return countLeaves(root.left) + countLeaves(root.right);
			}
		}
		else
		{
			// At first, I thought that I needed to check that root.left and root.right were not null before recursively calling this method, but the if/else structure here takes care of that.
			// In other words, if this method is passed a null node, then zero is returned, which is another base case.
			return 0;
		}
	}

	// Checks if the tree is a full binary tree
	public boolean isFullBinaryTree()
	{
		TreeNode<E> current = root;

		// If a binary search tree is empty, return false.
		if (root == null)
		{
			return false;
		}
		// If the root is the only node in the tree, technically it is full, and no need to enter the recursive helper method.
		else if (root.right == null && root.left == null)
		{
			return true;
		}
		else
		{
			return isFullBinaryTree(current);
		}
	
	}

	// A private helper method to find out if the tree is full by using recursion
	private boolean isFullBinaryTree(TreeNode<E> root)
	{
		// Everything but leaves or a lone root has a right or left child
		// A leaf has been identified, return true
		if (root.right == null && root.left == null)
		{
			return true;
		}
		// Otherwise, if one of the children are missing, then the binary tree is not full
		else if((root.left != null && root.right == null) || (root.left == null && root.right != null))
		{
			return false;
		}
		// otherwise recursively call this method, but returns from both subtrees must be true.
		else
		{
			return (isFullBinaryTree(root.left) && isFullBinaryTree(root.right));
		}
	}
} // end StudentBST<E> class

// I used the Suggested Single File Structure Template on the Final Project Description page as a starting point for the Student class.
class Student implements Comparable<Student>
{
	String id;
	String name;
	String major;

	// Uses my custom ArrayList and not the java.util version, sorry for any confusion since their names are the same.
	ArrayList<Double> grades = new ArrayList<>();

	// Constructor for instantiating Student objects
	Student(String id, String name, String major)
	{
		this.id = id;
		this.name = name;
		this.major = major;
	}

	// Add a grade (0 to 100 inclusive)
	// I changed it to boolean return type in case an invalid grade is passed to it.
	boolean addGrade(double g)
	{
		
		// If the grade is in a valid range: 0 to 100 inclusive then add it to the grades ArrayList.
		if(g >=0 && g <= 100)
		{
			// Convert the primitive formal parameter to a Double object since ArrayList will be expecting an object to be passed to its add method.
			// Let Java autobox the primitive into its wrapper type.
			Double grade = g; 
			grades.add(grade);
			return true;
		}
		else
		{
			// else, if the grade is not between 0 and 100 inclusive, return false because the add failed.
			return false;
		} // end if/else statement
	} // end boolean addGrade()

	// Return the averge grade or Double.NaN (not a number) if no grades are yet stored for the student
	double average()
	{
		// A variable to hold the total of all the grades in the ArrayList.
		double total = 0.0;
		
		// A variable to hold the average grade = total / grades.size()
		double average = 0.0;
		if(grades.size == 0)
		{
			return Double.NaN;
		}
		else
		{
			for (int i = 0; i < grades.size(); i++)
			{
				// Demonstrates autounboxing
				total += grades.get(i);
			}
			average = (total / (double)grades.size());
			return average;
		} 
	} // end double average()
	
	@Override
	public String toString()
	{
		return ("ID: " + id + ", Name: " + name + ", Major: " + major);  
	}

	@Override
 	public int compareTo(Student other)
	{
		// Based on the syntax of compareTo in section 21.6 of our textbook.
        	return this.id.compareTo(other.id);
	}

	void editStudent(String newName, String newMajor)
	{
		this.name = newName;
		this.major = newMajor;
	}

	ArrayList<Double> getGrades()
	{
		ArrayList<Double> gradesCopy = new ArrayList<>();
		gradesCopy = grades;
		return gradesCopy;
	}
} // end Student class

class StudentManager
{
	// Create a BST to store students.
	private final StudentBST<Student> bst = new StudentBST<>();
	
	// Adds a student to the bst unless the student is a duplicate
	boolean addStudent(String id, String name, String major)
	{
		return bst.insert(new Student(id, name, major));
	}

	// deleteStudent() Deletes a student from the bst tree
	// I figured out how to interface with the student manager and how to have that, in turn, interface with the BST to delete a student on my own.
	// Here, the string that is passed in from the SIS class is used to create a new anonymous object to pass to the BST for comparison and deletion.
	// All the compareTo in Student cares about is if the IDs match, so it successfully deletes any student in the tree that matches the id (even a factious, anonymous one).

	boolean deleteStudent(String id)
	{
		return bst.delete(new Student(id, "",""));
	}

	void listAllStudents()
	{
		bst.inorder();
	}

	Student getStudent(String id)
	{
		Student student = (Student)bst.find(new Student(id, "", ""));
		return student;
	}

	boolean addGrade(String id, double grade)
	{
		boolean result = false;
		Student student = (Student)bst.find(new Student(id, "", ""));
		if(student == null)
		{
			return false;
		}
		else
		{
			return student.addGrade(grade);
		}
	}

	String getGrades(String id)
	{
		Student student = (Student)bst.find(new Student(id, "", ""));
		if (student == null)
		{
			return null;
		}
		else
		{
			ArrayList<Double> copyOfGrades = student.getGrades();
			return copyOfGrades.toString();
		}
	}

	double getStudentAverage(String id)
	{
		Student student = (Student)bst.find(new Student(id, "", ""));
		if (student == null)
		{
			return Double.NaN;
		}
		else
		{
			return student.average();
		}
	}

	Student getHighestAverageStudent()
	{
		Iterator inorderiterator = bst.iterator();
		Student maxStudent = null;
		double max = 0;
		while(inorderiterator.hasNext())
		{
			Student student = (Student)inorderiterator.next();
			if(student.average() > max)
			{
				maxStudent = student;
			}
		}

		return maxStudent;
	}

	double getClassAverage()
	{
		Iterator inorderiterator = bst.iterator();
		double total = 0.0;
		int numberOfStudents = 0;
		while(inorderiterator.hasNext())
		{
			Student student = (Student)inorderiterator.next();
			if (!Double.isNaN(student.average()))
			{
				total += student.average();
				numberOfStudents++;
			}
		}
		return total / numberOfStudents;
	}
	
	boolean editStudent(String id, String newName, String newMajor)
	{
		Student student = (Student)bst.find(new Student(id, "", ""));
		if(student == null)
		{
			return false;
		}
		else
		{
			student.editStudent(newName, newMajor);
			return true;			
		}
	}
} // end StudentManager class

public class SIS
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		StudentManager sm = new StudentManager();
		int choice = 11;
		do
		{
			// Call the printMenu() method that just prints out the menu choices for the user to choose from.
			printMenu();

			// Call the readInt menu which returns an int and is passed in a scanner and a String litteral
			choice = readInt(sc, "Choose: ");
			switch(choice)
			{
				case 1 -> addStudentUI(sc, sm);
				case 2 -> editStudentUI(sc, sm);
				case 3 -> deleteStudentUI(sc, sm);
				case 4 -> viewStudentUI(sc, sm);
				case 5 -> addGradeUI(sc, sm);
				case 6 -> viewGradesUI(sc, sm);
				case 7 -> studentAverageUI(sc, sm);
				case 8 -> highestAverageUI(sm);
				case 9 -> classAverageUI(sm);
				case 10 -> listAllStudentsUI(sm);
				case 11 -> { System.out.println("Exiting ..."); }
				default -> { System.out.println("A critical error has occurred."); System.exit(1); }
			}
		}while(choice != 11);
	}

	private static void printMenu()
	{
		System.out.println("\n---Student Information System---");
		System.out.println("1) Add Student");
		System.out.println("2) Edit Student");
		System.out.println("3) Delete Student");
		System.out.println("4) View Student");
		System.out.println("5) Add Grade");
		System.out.println("6) View Grades");
		System.out.println("7) Student Average");
		System.out.println("8) Highest Average Student");
		System.out.println("9) Class Average");
		System.out.println("10) List All Students");
		System.out.println("11) Exit");
	}
	
	private static int readInt(Scanner sc, String prompt)
	{
		boolean validInput = true;
		int input = 11;
		boolean inRange = true;
		do
		{
			do
			{
				System.out.print(prompt);
				try
				{
					input = sc.nextInt();
					validInput = true;
				} // end try			
				catch(InputMismatchException ex)
				{
					sc.nextLine(); // Discard the invalid input from the buffer
					System.out.println("Please enter a valid number.");
					validInput = false;	
				} // end try-catch block	
			}while(!validInput); // end do-while
			inRange = checkChoiceRange(input);
			if(!inRange)
			{
				System.out.println("Your choice is not within the range of valid choices.");
				System.out.println("You must enter an integer between 1 and 11 (inclusive)");
			}
		}while(!inRange);
		return input;	
	}

	private static boolean checkChoiceRange(int input)
	{
		if(input > 0 && input <= 11)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	private static String readLine(Scanner sc, String prompt)
	{
		String s;
		// Do-while loop added in order to only accept non-empty IDs, names, and majors.
		do
		{
			System.out.print(prompt);
			s = sc.nextLine();
			// Handle pending newline after nextInt
			if(s.isEmpty())
			{
				s = sc.nextLine();
			}
			s.trim();
			if(s.isEmpty())
			{
				System.out.println("Input cannot be empty. Please try again.");
			}
		} while (s.isEmpty());
		return s;	
	}

	private static double readDouble(Scanner sc, String prompt)
	{
		double input = 0.0;
		boolean inRange = true;
		boolean validInput = true;
		do
		{
			do
			{
				System.out.print(prompt);
				try
				{
					input = sc.nextDouble();
					validInput = true;
				} // end try			
				catch(InputMismatchException ex)
				{
					sc.nextLine(); // Discard the invalid input from the buffer
					System.out.println("Please enter a valid number.");
					validInput = false;	
				} // end try-catch block	
			}while(!validInput); // end do-while
			inRange = checkDoubleRange(input);
			if(!inRange)
			{
				System.out.println("The grade entered is not within the range of valid grades.");
				System.out.println("You must enter a decimal number between 0.0 and 100.0 (inclusive)");
			}
		}while(!inRange);
		return input;
	}
	
	private static boolean checkDoubleRange(double grade)
	{
		if(grade >= 0.0 && grade <= 100.0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	private static void addStudentUI(Scanner sc, StudentManager sm)
	{
		boolean successfullyAdded = false;
		String id = readLine(sc, "Please enter the student\'s ID: ");
		String name = readLine(sc, "Please enter the student\'s name: ");
		String major = readLine(sc, "Please enter the student\'s major: ");
		
		successfullyAdded = sm.addStudent(id, name, major);
		if (successfullyAdded)
		{
			viewStudent(id, sm);
		}
		else
		{
			System.out.println("Could not add student because a student with that identification number is already in the database.");
		}
	}

	private static void editStudentUI(Scanner sc, StudentManager sm)
	{
		boolean successfullyEdited = false;
		String id = readLine(sc, "Please enter the ID of the student whose name and/or major you want to change: ");
		String name = readLine(sc, "Please enter the new name of Student ID " + id + ": ");
		String major = readLine(sc, "Please enter the new major for Student ID " + id + ": ");
		successfullyEdited = sm.editStudent(id, name, major);
		if (successfullyEdited)
		{
			System.out.println("Successfully edited student ID: " + id + ", Name: " + name + ", Major: " + major);
			Student student = sm.getStudent(id);
			System.out.println("As conformation, Student ID: " + id + " is now stored in the database as: " + student.toString());
		}
		else
		{
			System.out.println("Unable to edit student because Student ID: " + id + " does not exist in the database.");
		}
	}

	// I figured out how to interface with the student manager and how to have that, in turn, interface with the BST to delete a student on my own.
	// Here, you pass a string to the student manager, and it creates a new anonymous object to pass to the BST for comparison and deletion.
	private static void deleteStudentUI(Scanner sc, StudentManager sm)
	{
		boolean deleteSuccessful = false;
		String id = readLine(sc, "Please enter the ID of the student who you want to delete from the database: ");
		System.out.print("Are you sure you want to delete student ID: " + id + "? This action is permanent and cannot be undone.");
		char choice = sc.next().charAt(0);
		if(Character.toLowerCase(choice) == 'y')
		{
			deleteSuccessful = sm.deleteStudent(id);
		}
		if (deleteSuccessful)
		{
			System.out.println("Student ID: " + id + " successfully deleted from the database.");
		}
		else
		{
			System.out.println("Student ID: " + id + " not successfully deleted from the database because student ID : " + id + " is not in the database.");
		}
	}

	private static void viewStudentUI(Scanner sc, StudentManager sm)
	{
		String id = readLine(sc, "Please enter the ID of the student who you want to find in the database: ");
		Student student = sm.getStudent(id);
		if(student != null)
		{
			System.out.println("Found: " + student.toString());
		}
		else
		{
			System.out.println("Student not found in the database. Please check id and try again.");
		}

	}

	// An overloaded version of viewStudent so that add student can echo back the student entered
	private static void viewStudent(String id, StudentManager sm)
	{
		Student student = sm.getStudent(id);
		if(student != null)
		{
			System.out.println("Successfully added: " + student.toString());
		}
		else
		{
			System.out.println("Student was not found in the database. Please try to adding the student again.");
		}
	}

	private static void highestAverageUI(StudentManager sm)
	{
		Student highestAverageStudent = sm.getHighestAverageStudent();
		if(highestAverageStudent == null)
		{
			System.out.println("No students are yet in the database. Please enter a student along with some grades and try again.");
		}
		else
		{
			System.out.println("The highest average student is: " + highestAverageStudent);
			System.out.println("This student's average is: " + sm.getStudentAverage(highestAverageStudent.id));
		}
	}
	
	private static void addGradeUI(Scanner sc, StudentManager sm)
	{
		boolean addGradeSuccessful = false;
		String id = readLine(sc, "Please enter the ID number of the student who you want to add a grade to: ");
		double grade = readDouble(sc, "Please enter a grade for student ID " + id + ": ");
		// Student student = sm.getStudent(id);
		addGradeSuccessful = sm.addGrade(id, grade);
		if(addGradeSuccessful)
		{
			System.out.println("Grade: " + grade + " successfully added to Student ID: " + id + "\'s record.");
		}
		else
		{
			System.out.println("Could not add grade: " + grade + " to Student ID: " + id + "\'s record.");
			System.out.println("The student does not yet exist in the database. Please check that the student has been entered before adding grades.");
		}
	}
	
	private static void viewGradesUI(Scanner sc, StudentManager sm)
	{
		String id = readLine(sc, "Please enter the ID of the student of whose grades you want to view: ");
		String result = sm.getGrades(id);
		if(result == null)
		{
			System.out.println("Student ID: " + id + " does not yet have any grades in the system.");
		}
		else
		{
			System.out.println("Student ID " + id + "\'s grades: " + result);
		}
	}
	
	/* I searched Google for how to compare a double to Double.NaN, and it's AI search summary suggested using Double.isNaN(value). Key words: "how to check if a double equals Double.NaN in java"
	https://www.google.com/search?q=how+to+check+if+a+double+equals+Double.NaN+in+java&rlz=1C1CHBF_enUS924US924&oq=how+to+check+if+a+double+equals+Double.NaN+in+java&gs_lcrp=EgZjaHJvbWUyBggAEEUYOTIHCAEQIRigATIHCAIQIRigATIHCAMQIRigATIHCAQQIRigATIHCAUQIRigATIHCAYQIRiPAtIBCTEyNzg0ajBqN6gCALACAA&sourceid=chrome&source=chrome.ob&ie=UTF-8
	*/
	private static void studentAverageUI(Scanner sc, StudentManager sm)
	{
		String id = readLine(sc, "Please enter the ID of the student of whose average grade you want to view: ");
		double average = sm.getStudentAverage(id);
		if(Double.isNaN(average))
		{
			System.out.println("Student ID: " + id + " does not yet have any grades in the system to average.");
		}
		else
		{
			System.out.println("The average of Student ID " + id + "\'s grades is " + average);
		}
	}

	private static void classAverageUI(StudentManager sm)
	{
		System.out.println("The class average grade is: " + sm.getClassAverage());
	}

	private static void listAllStudentsUI(StudentManager sm)
	{
		sm.listAllStudents();
	}	
} // end SIS class

/*
Works Cited:
Dale, Nell; Joyce, Daniel T.; and Weems, Chip. Object-Oriented Data Structures Using Java. Jones and Bartlett Learning, 2002. 

Google Search, Google, www.google.com/search?q=what%2Bis%2Bjava%2Butil%2Bfunction%2Bconsumer&rlz=1C1CHBF_enUS924US924&oq=what%2Bis%2Bjava.util.function.Consumer&gs_lcrp=EgZjaHJvbWUqCAgBEAAYFhgeMgYIABBFGDkyCAgBEAAYFhgeMgoIAhAAGAoYFhgeMgcIAxAAGO8FMgoIBBAAGKIEGIkFMgcIBRAAGO8FMgcIBhAAGO8F0gEJNzc1MzlqMGo3qAIAsAIA&sourceid=chrome&source=chrome.ob&ie=UTF-8. Accessed 5 Aug. 2026. 

Google Search, Google, www.google.com/search?q=how%2Bwould%2Byou%2Buse%2BConsumer%2Bin%2Bjava%2Bto%2Bprint%2Bthe%2Belements%2Bin%2Border%2Bin%2Ba%2Bbinary%2Bsearch%2Btree%2Bthat%2Bare%2Bstudent%2Bobjects%2Bthat%2Bhave%2Bthe%2BtoString%2Bmethod%3F&rlz=1C1CHBF_enUS924US924&gs_lcrp=EgZjaHJvbWUyBggAEEUYOdIBCjU1NDMwajBqMTWoAgiwAgHxBaOprLfqSLxa8QWjqay36ki8Wg&sourceid=chrome&ie=UTF-8&udm=50&fbs=ABfTbFVyMZGZf1hfvX9uKjN_-G8cqu7ocb7U6ah0xpkIrGMK4AD-5zQwT5IfpPJ6og2sC2IXdmIqakpXvaGorGwhS-OJs8VccvlD1MGF13c4vQEZ6BOD3Pux5R5lRiN8ciO8Slgl0BUnHh_G26N4HW8fBW4mkNU_voP8HrIeXqVfCc2UPr_YSNPgncxR2WyFnMp5o-T5_iziM1OYX83ka-_PDKYbfe8RNQ&aep=10&ntc=1&mstk=AUtExfD6AbhBbmZUfmrAzZyD8Dr0rjUUmC4WXHZaMVERHqTlZpyli5vWWX_yilihu2gRPjsnyBtL-ey574zQv88_3Hz9miQgF7l2EFqWxB2kMWVMTGkdA3FXdI1iJqn7LOVSilBy2qNkxuqrsQFjloDIBUwP_LjZtOk5e9qaquLJ4VLixVWl8nrz0UE0QtBUClISyv6qZHx6Xyq_UNXzTiyRwOvQnJm0BXZlrMWqxCBGPW_mSSioSasB4T6SdWdtiz7wq6Pa1FMgzUHujgRRQy8epu2d4aKCEzMk9Yyq44uYrpXghvFfUQWtTrKJ61qhK4kCWXFoxpN0DgYu375Gs7ZxUvf-61du1wjMOA&aioh=3&csuir=1&cs=1&atvm=2&mtid=BpNzavndO_jIkPIPuMG28A8. Accessed 5 Aug. 2026.

Google Search, Google, www.google.com/search?q=how%2Bto%2Bcheck%2Bif%2Ba%2Bdouble%2Bequals%2BDouble.NaN%2Bin%2Bjava&rlz=1C1CHBF_enUS924US924&oq=how%2Bto%2Bcheck%2Bif%2Ba%2Bdouble%2Bequals%2BDouble.NaN%2Bin%2Bjava&gs_lcrp=EgZjaHJvbWUyBggAEEUYOTIHCAEQIRigATIHCAIQIRigATIHCAMQIRigATIHCAQQIRigATIHCAUQIRigATIHCAYQIRiPAtIBCTEyNzg0ajBqN6gCALACAA&sourceid=chrome&source=chrome.ob&ie=UTF-8. Accessed 5 Aug. 2026. 

Liang, Y. Daniel. Introduction to Java Programming and Data Structures. 13th ed., Pearson Education Limited, 2024.

Michael. “Java - Finding the Height of the Binary Tree - Stack Overflow.” Stack Overflow, 31 Dec. 2015, stackoverflow.com/questions/34539213/finding-the-height-of-the-binary-tree. Accessed: 02 Aug 2026.

Stalin S. “Find Number of Leaf Nodes in given Binary Tree.” YouTube, 5 May 2015, www.youtube.com/watch?v=7ZWH0ZbUIcs. Accessed: 03 Aug 2026.

*/
