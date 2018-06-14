//Raymond Valdez
//Assignment 1 Baron Burger
//April 2nd 2018

public class MyStack<Type> {

 private Node head;
 private int size;
 
 public class Node{
		 Type data;
		 Node next;
	}

 public MyStack() { //constructor
  head = null;
  size = 0;
 }

 void push(Type item) {
  Node node = new Node();
  node.data = item;

  if (head == null) {
   head = node;
   size++;
  } else {
   Node current = head; //point to the front of the node
   while (current.next != null) //while there is a node in the front, iterate through it
   {
    current = current.next;
   }
   current.next = node;
   size++;
  }
 }

 boolean isEmpty() { //methods returns true if empty
  if (head == null) {
   return true;
  }
  return false;
 }

 public Type pop() { //method removes and returns the item on the top of the Mystack
  Type Temp;

  if (head == null) {
   return null;
  }

  if (size() == 1) {
   Temp = head.data;
   head = null;
   size--;
   return Temp;
  }

  Node prev = head;
  Node current = head; //point to the front of the node

  while (current.next != null) //while there is a node in the front, iterate through the stack
  {
   current = current.next;
   if (current.next != null) {
    prev = current;
   }
  }
  Temp = current.data;
  prev.next = null;

  if (size != 0) {
   size--;
  }

  return Temp;
 }


 public Type peek() { //returns the item on the top of the MyStack
  Node current = head;
  if (head == null) {
   return null;
  }

  while (current.next != null) //while there is a node in the front, iterate through the stack
  {
   current = current.next;
  }

  return current.data;
 }

 int size() { //returns the number of items in the MyStack


  return size;
 }

 public String toString() { //this method converts the contents of the MyStack to a String for display

  String print = null;

  if (head == null) {
   return "null";
  }

  MyStack<Type> Stack2 = new MyStack<Type>();


  while (!isEmpty()) {
   Stack2.push(pop()); //push into stack 2 
  }


  Node current2 =  Stack2.head;
  print = (String) current2.data;


  while (current2.next != null) {

   current2 = current2.next;
   print = print + ", " + current2.data;

  }
  while (!Stack2.isEmpty()) {
   push(Stack2.pop()); //push into stack 1 
  }

  return print;
 }
}