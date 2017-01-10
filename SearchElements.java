/**
 * SearchElements.java
 * Assignment: Final Project
 * Purpose: The search functionality for the project.
 * in this state, it doesn't work as we have not added
 * the ability to get the string from the textField.
 *
 * @version 12/14/16
 * @author Will Thomas, Danny Higgins
 */
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class SearchElements extends JPanel implements ActionListener{
public static final int numberOfElements = 118;
private JTextField textField;
public Scanner elements; //hold the whole text
public Scanner lineBreak; //holds a line temporarily
public ArrayList<String> lineList; //holds an entire line
public ArrayList<String> elementNames;  //holds element names
public ArrayList<String> elementSymbol; //holds element symbols
public  String input; //hold the input from the text box
public double trash; //holds un-needed values
public Scanner lineBreakTwo; //holds a second copy of a line
public Scanner elementsTwo; //second copy of elements

   public SearchElements(Scanner elements,Scanner elementsTwo){
      ArrayList<String> elementNames = new ArrayList<String>();
      ArrayList<String> elementSymbol = new ArrayList<String>();
      ArrayList<String> lineList = new ArrayList<String>();
      this.elementNames = elementNames;
      this.elementSymbol = elementSymbol;
      this.lineList = lineList;
      this.elements = elements;
      this.elementsTwo = elementsTwo;
      listGenerator();
   }
   public void listGenerator(){ //creates the 3 array lists for searching
   for(int i = 0; i < numberOfElements; i++){
      this.lineBreak = new Scanner(this.elements.nextLine());
      this.trash = lineBreak.nextInt();
      this.trash = lineBreak.nextInt();
      this.trash = lineBreak.nextInt();
      this.trash = lineBreak.nextDouble();
      String name = lineBreak.next(); //name of element
      String symbol = lineBreak.next(); //symbol of element
      this.elementNames.add(i, name);
      this.elementSymbol.add(i,symbol);
      this.lineList.add(this.elementsTwo.nextLine());
   }
   }
   
   public void createText(CreateButtons panel){ //creates the text field at the top of the table
      textField = new JTextField(20);
      panel.add(textField);
      textField.addActionListener(this);
   }
   
  @Override
   public void actionPerformed(ActionEvent e) {
      this.input = textField.getText();
      searchScanner();
   }
   
      
   public void searchScanner(){ //displays the symbol and the element name of the users input
     for(int i = 0; i < numberOfElements; i++){
      if(this.elementNames.get(i).equalsIgnoreCase(this.input) || this.elementSymbol.get(i).equalsIgnoreCase(this.input)){
         System.out.println(this.lineList.get(i).toString());
      }

     }
      //try creating three array lists, that line up so that position 1 in the names array list 
      //coresponds to the 1st line of text and first symbol.
      //ie <Hydrogen, Etc, Etc,> <H, Etc, Etc> <1.0007, Etc, Etc>


      }
   }
