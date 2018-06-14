//Raymond Valdez
//Assignment 1 Baron Burger
//April 2nd 2018
public class Burger {


 private MyStack<String> Order = new MyStack<String>();
 private int patties;
 private String pattyType;
 private boolean test = false;

 public Burger(boolean theWorks) {

  if (theWorks == false) {
   //initializes a burger with only a bun and patty
   patties = 1;
   pattyType = "Beef";
   test = true;

   addIngredient("Bun");
   addIngredient(pattyType);
   addIngredient("Bun");
  } else {
   //make Baron burger

   patties = 1;
   pattyType = "Beef";

   addIngredient("Bun");
   addIngredient("Ketchup");
   addIngredient("Mustard");
   addIngredient("Mushrooms");
   addIngredient(pattyType);
   addIngredient("Cheddar");
   addIngredient("Mozzarella");
   addIngredient("Pepperjack");
   addIngredient("Onions");
   addIngredient("Tomato");
   addIngredient("Lettuce");
   addIngredient("Baron-Sauce");
   addIngredient("Mayonnaise");
   addIngredient("Bun");
   addIngredient("Pickle");
  }
 }


 void changePatties(String pattyType) {
  //this method changes all patties in the Burger to the pattyType

  MyStack<String> Stack2 = new MyStack<String>();

  while (!Order.isEmpty()) {

   if (Order.peek().equalsIgnoreCase("Beef") || Order.peek().equalsIgnoreCase("chicken") || Order.peek().equalsIgnoreCase("veggie")) {
    Order.pop();
    Order.push(pattyType);
   }

   Stack2.push(Order.pop());
  }



  while (!Stack2.isEmpty()) {
   Order.push((String) Stack2.pop()); //push into stack 1 
  }

 }


 void addPatty() {
  //this method adds on patty to the Burger up to a maximum of 3

  MyStack<String> Stack2 = new MyStack<String>();

  patties++;

  if (patties == 2) {
   while (!Order.peek().equalsIgnoreCase(pattyType)) {
    Stack2.push(Order.pop());
   }

   while (Stack2.peek().equalsIgnoreCase( "Cheddar") || Stack2.peek().equalsIgnoreCase("Mozzarella") || Stack2.peek().equalsIgnoreCase("pepperjack")) {
    Order.push(Stack2.pop());
   }

   Order.push(pattyType);

   while (!Stack2.isEmpty()) {
    Order.push(Stack2.pop());
   }
  } else if (patties == 3) {
   while (!Order.peek().equalsIgnoreCase(pattyType)) {
    Stack2.push(Order.pop());
   }

   Order.push(pattyType);

   while (!Stack2.isEmpty()) {
    Order.push(Stack2.pop());
   }
  }
 }

 void addCategory(String type) {
  //this method adds all items of the type to the Burger in the proper locations
  if (type.equalsIgnoreCase("Veggies")) {
   addIngredient("Lettuce");
   addIngredient("Tomato");
   addIngredient("Onions");
   addIngredient("Pickle");
   addIngredient("Mushrooms");
  }

  if (type.equalsIgnoreCase("Sauce")) {
   addIngredient("Ketchup");
   addIngredient("Mustard");
   addIngredient("Mayonnaise");
   addIngredient("Baron-Sauce");

  }

  if (type.equalsIgnoreCase("Cheese")) {
   addIngredient("Cheddar");
   addIngredient("Mozzarella");
   addIngredient("Pepperjack");

  }

 }

 void removeCategory(String type) {
  //this method removes all items of the type on the Burger
  if (type.equalsIgnoreCase("Veggies")) {
   removeIngredient("Lettuce");
   removeIngredient("Tomato");
   removeIngredient("Onions");
   removeIngredient("Pickle");
   removeIngredient("Mushrooms");
  }

  if (type.equalsIgnoreCase("Sauce")) {
   removeIngredient("Ketchup");
   removeIngredient("Mustard");
   removeIngredient("Mayonnaise");
   removeIngredient("Baron-Sauce");

  }

  if (type.equalsIgnoreCase("Cheese")) {
   removeIngredient("Cheddar");
   removeIngredient("Mozzarella");
   removeIngredient("Pepperjack");

  }
 }

 void addIngredient(String type) {
  //this method adds the ingredient type to the burger in the proper location

  MyStack<String> Stack2 = new MyStack<String>();

  if (Order.size() == 0) {
   Order.push(type);
  } else {

   //***************************************************************		
   if (type.equalsIgnoreCase("Pickle")) {
    if (!Order.peek().equalsIgnoreCase("Pickle")) {
     Order.push("Pickle");
    }
   }

   if (Order.peek().equalsIgnoreCase("Pickle")) {
    Stack2.push(Order.pop());
   }


   //*****************************************************************			

   if (Order.size() != 1) {
    if (type.equalsIgnoreCase("Bun")) {
     if (!Order.peek().equalsIgnoreCase("Bun")) {
      Order.push("Bun");
     }
    }

    if (Order.peek().equalsIgnoreCase("Bun")) {
     Stack2.push(Order.pop());
    }
   }


   //***********************************************************************		

   if (type.equalsIgnoreCase("Mayonnaise")) {
    if (!Order.peek().equalsIgnoreCase("Mayonnaise")) {
     Order.push("Mayonnaise");
    }
   }

   if (Order.peek().equalsIgnoreCase("Mayonnaise")) {
    Stack2.push(Order.pop());
   }


   //******************************************************************
   if (type.equalsIgnoreCase("Baron-Sauce")) {
    if (!Order.peek().equalsIgnoreCase("Baron-Sauce")) {
     Order.push("Baron-Sauce");
    }
   }

   if (Order.peek().equalsIgnoreCase("Baron-Sauce")) {
    Stack2.push(Order.pop());
   }
   //****************************************************		
   if (type.equalsIgnoreCase("Lettuce")) {
    if (!Order.peek().equalsIgnoreCase("Lettuce")) {
     Order.push("Lettuce");
    }
   }

   if (Order.peek().equalsIgnoreCase("Lettuce")) {
    Stack2.push(Order.pop());
   }

   //*************************************************************		
   if (type.equalsIgnoreCase("Tomato")) {
    if (!Order.peek().equalsIgnoreCase("Tomato")) {
     Order.push("Tomato");
    }
   }

   if (Order.peek().equalsIgnoreCase("Tomato")) {
    Stack2.push(Order.pop());
   }
   //*************************************************************		
   if (type.equalsIgnoreCase("Onions")) {
    if (!Order.peek().equalsIgnoreCase("Onions")) {
     Order.push("Onions");
    }
   }

   if (Order.peek().equalsIgnoreCase("Onions")) {
    Stack2.push(Order.pop());
   }


   //******************************************************************			
   if (type.equalsIgnoreCase("Pepperjack")) {
    if (!Order.peek().equalsIgnoreCase("Pepperjack")) {
     Order.push("Pepperjack");
    }
   }

   if (Order.peek().equalsIgnoreCase("Pepperjack")) {
    Stack2.push(Order.pop());
   }

   //*************************************************************

   if (type.equalsIgnoreCase("Mozzarella")) {
    if (!Order.peek().equalsIgnoreCase("Mozzarella")) {
     Order.push("Mozzarella");
    }
   }

   if (Order.peek().equalsIgnoreCase("Mozzarella")) {
    Stack2.push(Order.pop());
   }
   //***********************************************************		

   if (type.equalsIgnoreCase("Cheddar")) {
    if (!Order.peek().equalsIgnoreCase("Cheddar")) {
     Order.push("Cheddar");
    }
   }

   if (Order.peek().equalsIgnoreCase("Cheddar")) {
    Stack2.push(Order.pop());
   }

   //*****************************************************


   if (type.equalsIgnoreCase(pattyType)) {
    if (!Order.peek().equalsIgnoreCase("pattyType")) {
     Order.push(pattyType);
    }
   }

   if (Order.peek().equalsIgnoreCase(pattyType)) {
    Stack2.push(Order.pop());
   }



   //**************************************************************

   if (type.equalsIgnoreCase("Mushrooms")) {
    if (!Order.peek().equalsIgnoreCase("Mushrooms")) {
     Order.push("Mushrooms");
    }
   }

   if (Order.peek().equalsIgnoreCase("Mushrooms")) {
    Stack2.push(Order.pop());
   }


   //******************************************************
   if (type.equalsIgnoreCase("Mustard")) {
    if (!Order.peek().equalsIgnoreCase("Mustard")) {
     Order.push("Mustard");
    }
   }

   if (Order.peek().equalsIgnoreCase("Mustard")) {
    Stack2.push(Order.pop());
   }
   //******************************************************
   if (type.equalsIgnoreCase("Ketchup")) {
    if (!Order.peek().equalsIgnoreCase("Ketchup")) {
     Order.push("Ketchup");
    }
   }

   if (Order.peek().equalsIgnoreCase("ketchup")) {
    Stack2.push(Order.pop());
   }
   //********************************************************


   if (type.equalsIgnoreCase("Bun")) {
    if (!Order.peek().equalsIgnoreCase("Bun")) {
     Order.push("Bun");
    }
   }

   if (Order.peek().equalsIgnoreCase("Bun")) {
    Stack2.push(Order.pop());
   }


   //***********************************************************	
   //code to push back onto order
   while (!Stack2.isEmpty()) {
    Order.push(Stack2.pop());
   }

  }
 }


 void removeIngredient(String type) {
  //this method removes ingredients

  MyStack<String> Stack2 = new MyStack<String>();

  if (Order.size() == 0) {
   return;
  } else if (Order.size() == 1) {
   if (Order.peek().equalsIgnoreCase(type))
    Order.pop();
  } else if (Order.size() == 2) {
   if (Order.peek().equalsIgnoreCase(type) && Order.peek().equalsIgnoreCase("bun"));
   Order.pop();
   Order.pop();
  } else {
   while (!Order.isEmpty()) {

    if (Order.peek().equalsIgnoreCase(type)) {
     Order.pop();
    } else {
     Stack2.push(Order.pop()); //push into stack 2 
    }
   }


   while (!Stack2.isEmpty()) {
    Order.push(Stack2.pop()); //push into stack 1 
   }
  }
 }

 public String toString() {

  return Order.toString();
 }
}