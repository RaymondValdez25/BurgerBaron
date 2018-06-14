//Raymond Valdez
//Assignment 1 Baron Burger
//April 2nd 2018

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

public class Main {

 /*
 this main method scans the input file "customer.txt" and processes the 
 customer orders line by line using the method parseLine()
 also included in this method is the testMyStack() method that tests myStack()
 and testBurger() which tests the burger.
  */

 public static void main(String[] args) throws FileNotFoundException {

  int count = 0;

  File file = new File("customer.txt");

  Scanner scan = new Scanner(file);

  
  while (scan.hasNextLine()) {

   System.out.print("Processing Order " + count + ": ");
   parseLine(scan.nextLine());

   count++;
  }
  

  //testMyStack(); //stack testing code
  //testBurger(); //Burger testing code


 }

 /*
 This parseLine() function analyzes the line passed into it word by word
 and collects data. If within the line there is a word "Baron"
 this method knows to produce a baron burger. Otherwise a "burger" is produced.
 If there is a "with" entered in the customer order, then this method knows
 to add the following ingredients. But if a "no" is followed by the "with, the method
 knows to omit the following ingredients.
 If a "but" is entered after either "with no" or "with", the program knows to perform 
 the negation on the following ingredients.
  */

 static void parseLine(String line) {
  int count = 0; //loop iterator	

  String pattyType = "Beef";

  int numPatty = 1;
  boolean baron = false;

  int with = 0;
  int withNo = 0;

  int cheddar = 0;
  int mozzarella = 0;
  int pepperjack = 0;
  int lettuce = 0;
  int tomato = 0;
  int onions = 0;
  int pickle = 0;
  int mushrooms = 0;
  int ketchup = 0;
  int mustard = 0;
  int mayo = 0;
  int baronSauce = 0;

  int cheese = 0;
  int veggies = 0;
  int sauce = 0;



  System.out.println(line);

  String[] splits = line.split("\\s+");

  int lineSize = splits.length;

  while (count != lineSize) {

   if (splits[count].equalsIgnoreCase("baron")) {
    baron = true;
   }


   if (splits[count].equalsIgnoreCase("double")) {
    numPatty = 2;
   }

   if (splits[count].equalsIgnoreCase("triple")) {
    numPatty = 3;
   }


   if (splits[count].equalsIgnoreCase("Veggie")) {
    pattyType = "Veggie";
   }

   if (splits[count].equalsIgnoreCase("Beef")) {
    pattyType = "Beef";
   }

   if (splits[count].equalsIgnoreCase("Chicken")) {
    pattyType = "Chicken";
   }

   if (splits[count].equalsIgnoreCase("with")) {
    with = 1;
    withNo = 0;
   }

   if (splits[count].equalsIgnoreCase("no")) {
    withNo = 1;
    with = 0;
   }

   if (splits[count].equalsIgnoreCase("But")) {

    if (with == 1) {
     withNo = 1;
     with = 0;
    } else if (withNo == 1) {
     with = 1;
     withNo = 0;
    }


   }

   if (splits[count].equalsIgnoreCase("cheddar")) {
    if (with == 1) {
     cheddar = 1;
    } else if (withNo == 1) {
     cheddar = 2;
    }
   }

   if (splits[count].equalsIgnoreCase("mozzarella")) {
    if (with == 1) {
     mozzarella = 1;
    } else if (withNo == 1) {
     mozzarella = 2;
    }
   }

   if (splits[count].equalsIgnoreCase("pepperjack")) {
    if (with == 1) {
     pepperjack = 1;
    } else if (withNo == 1) {
     pepperjack = 2;
    }
   }

   if (splits[count].equalsIgnoreCase("lettuce")) {
    if (with == 1) {
     lettuce = 1;
    } else if (withNo == 1) {
     lettuce = 2;
    }

   }
   if (splits[count].equalsIgnoreCase("tomato")) {
    if (with == 1) {
     tomato = 1;
    } else if (withNo == 1) {
     tomato = 2;
    }
   }
   if (splits[count].equalsIgnoreCase("onions")) {
    if (with == 1) {
     onions = 1;
    } else if (withNo == 1) {
     onions = 2;
    }
   }
   if (splits[count].equalsIgnoreCase("pickle")) {
    if (with == 1) {
     pickle = 1;
    } else if (withNo == 1) {
     pickle = 2;
    }
   }
   if (splits[count].equalsIgnoreCase("mushrooms")) {
    if (with == 1) {
     mushrooms = 1;
    } else if (withNo == 1) {
     mushrooms = 2;
    }
   }
   if (splits[count].equalsIgnoreCase("ketchup")) {
    if (with == 1) {
     ketchup = 1;
    } else if (withNo == 1) {
     ketchup = 2;
    }
   }
   if (splits[count].equalsIgnoreCase("mustard")) {
    if (with == 1) {
     mustard = 1;
    } else if (withNo == 1) {
     mustard = 2;
    }

   }
   if (splits[count].equalsIgnoreCase("Mayonnaise")) {
    if (with == 1) {
     mayo = 1;
    } else if (withNo == 1) {
     mayo = 2;
    }

   }
   if (splits[count].equalsIgnoreCase("Baron-Sauce")) {
    if (with == 1) {
     baronSauce = 1;
    } else if (withNo == 1) {
     baronSauce = 2;
    }
   }
   if (splits[count].equalsIgnoreCase("veggies")) {
    if (with == 1) {
     veggies = 1;
    } else if (withNo == 1) {
     veggies = 2;
    }
   }
   if (splits[count].equalsIgnoreCase("cheese")) {
    if (with == 1) {
     cheese = 1;
    } else if (withNo == 1) {
     cheese = 2;
    }
   }
   if (splits[count].equalsIgnoreCase("sauce")) {
    if (with == 1) {
     sauce = 1;
    } else if (withNo == 1) {
     sauce = 2;
    }
   }
   count++;

  }

  Burger customer = new Burger(baron);


  if (cheese > 0) {
   if (cheese == 1) {
    customer.addCategory("cheese");
   } else if (cheese == 2) {
    customer.removeCategory("cheese");
   }
  }

  if (sauce > 0) {
   if (sauce == 1) {
    customer.addCategory("sauce");
   } else if (sauce == 2) {
    customer.removeCategory("sauce");
   }
  }

  if (veggies > 0) {
   if (veggies == 1) {
    customer.addCategory("veggies");
   } else if (veggies == 2) {
    customer.removeCategory("veggies");
   }
  }

  if (cheddar > 0) {
   if (cheddar == 1) {
    customer.addIngredient("Cheddar");
   } else if (cheddar == 2) {
    customer.removeIngredient("Cheddar");
   }
  }

  if (mozzarella > 0) {
   if (mozzarella == 1) {
    customer.addIngredient("Mozzarella");
   } else if (mozzarella == 2) {
    customer.removeIngredient("Mozzarella");
   }
  }

  if (pepperjack > 0) {
   if (pepperjack == 1) {
    customer.addIngredient("Pepperjack");
   } else if (pepperjack == 2) {
    customer.removeIngredient("Pepperjack");
   }
  }

  if (lettuce > 0) {
   if (lettuce == 1) {
    customer.addIngredient("Lettuce");
   } else if (lettuce == 2) {
    customer.removeIngredient("Lettuce");
   }
  }

  if (tomato > 0) {
   if (tomato == 1) {
    customer.addIngredient("Tomato");
   } else if (tomato == 2) {
    customer.removeIngredient("Tomato");
   }
  }

  if (onions > 0) {
   if (onions == 1) {
    customer.addIngredient("Onions");
   } else if (onions == 2) {
    customer.removeIngredient("Onions");
   }
  }

  if (pickle > 0) {
   if (pickle == 1) {
    customer.addIngredient("Pickle");
   } else if (pickle == 2) {
    customer.removeIngredient("Pickle");
   }
  }

  if (mushrooms > 0) {
   if (mushrooms == 1) {
    customer.addIngredient("Mushrooms");
   } else if (mushrooms == 2) {
    customer.removeIngredient("Mushrooms");
   }
  }

  if (ketchup > 0) {
   if (ketchup == 1) {
    customer.addIngredient("Ketchup");
   } else if (ketchup == 2) {
    customer.removeIngredient("Ketchup");
   }
  }

  if (mustard > 0) {
   if (mustard == 1) {
    customer.addIngredient("mustard");
   } else if (mustard == 2) {
    customer.removeIngredient("mustard");
   }
  }

  if (mayo > 0) {
   if (mayo == 1) {
    customer.addIngredient("Mayonnaise");
   } else if (mayo == 2) {
    customer.removeIngredient("Mayonnaise");
   }
  }

  if (baronSauce > 0) {
   if (baronSauce == 1) {
    customer.addIngredient("Baron-Sauce");
   } else if (baronSauce == 2) {
    customer.removeIngredient("Baron-Sauce");
   }
  }

  if (numPatty == 2) {
   customer.addPatty();
  } else if (numPatty == 3) {
   customer.addPatty();
   customer.addPatty();
  }


  if (!pattyType.equalsIgnoreCase("Beef")) {
   if (pattyType.equalsIgnoreCase("Chicken")) {
    customer.changePatties("Chicken");
   }
   if (pattyType.equalsIgnoreCase("Veggie")) {
    customer.changePatties("Veggie");
   }
  }



  System.out.println("[" + customer.toString() + "]");

  System.out.println();


 }

 /* for my parseLine() function to work properly, i follow a few rules for the burger method.
 The addPatties() call is called after any add/remove category and Ingredients calls.
 Any add/remove Ingredients call must come after the add/remove category calls. 
 Regardless, as long as the customer follows the procedure to type in their order,
 parseLine() will take care of which method goes where. 
  */


 static void testBurger() {

  Burger Test = new Burger(true); //test for a baron burger
  Test.removeCategory("cheese"); //test remove category
  Test.addIngredient("mozzarella"); //test add ingredient


  System.out.println("Test " + Test.toString());

  Burger Test1 = new Burger(false); //test for a regular burger
  Test1.addCategory("cheese"); //test add category
  Test1.removeIngredient("mozzarella"); //test remove Ingredient

  System.out.println("Test1 " + Test1.toString());

  Burger Test2 = new Burger(true); //test for a baron burger
  Test2.removeCategory("cheese"); //test remove all categories
  Test2.removeCategory("sauce");
  Test2.removeCategory("veggies");

  System.out.println("Test2 " + Test2.toString());

  Burger Test3 = new Burger(false); //test for a regular burger
  Test3.addCategory("cheese");
  /*
   * tests add category
  adding cheese, then including a patty after-words
  will place the patty in the correct position
  see for yourself
  */
  Test3.addPatty();
  System.out.println("Test3 " + Test3.toString());


  //even if another patty is also added, the burger will come out correct
  Test3.addPatty();
  System.out.println("Test3 " + Test3.toString());


  //if I would like to change patties, it will come after adding the patty.
  Test3.changePatties("chicken");
  System.out.println("Test3 " + Test3.toString());


  //I thought about the most complex test 
  Burger Test4 = new Burger(false);

  Test4.addCategory("veggies");
  Test4.addCategory("cheese");
  Test4.addCategory("sauce");
  Test4.removeIngredient("pickle");
  Test4.removeIngredient("mayonnaise");
  Test4.removeIngredient("cheddar");
  Test4.addPatty();
  Test4.addPatty();
  Test4.addPatty();
  Test4.addPatty();
  Test4.changePatties("veggie");

  //although addPatty() is called multiples of times, the program knows to 
  //only include a maximum of 3 per burger

  System.out.println("Test4 " + Test4.toString());


 }



 static void testMyStack() {


  MyStack<String> testStack = new MyStack<String>();

  testStack.push("1"); //test push method
  testStack.push("2");
  testStack.push("3");


  System.out.println("size of stack after pushing " + testStack.size()); //check size

  System.out.println("to String " + testStack.toString()); //print stack


  testStack.pop(); //test pop method
  System.out.println("size of stack after popping off the top.... " + testStack.size()); //check size

  System.out.println("toString " + testStack.toString());

  testStack.pop();
  testStack.pop();
  testStack.pop();

  System.out.println("toString should be 'null' " + testStack.toString());
  System.out.println("is this stack empty? should be 'true' " + testStack.isEmpty()); //is empty?

  testStack.push("3");
  testStack.push("2");
  testStack.push("1");

  System.out.println("toString " + testStack.toString());

  System.out.println("peek " + testStack.peek()); //peek at the top 
  System.out.println("isEmpty should be 'false' " + testStack.isEmpty()); //is empty?


 }
}