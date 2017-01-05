import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class PopUp extends JFrame{
   private int index;
   private Scanner e;
   private Scanner printer;
   private String[] values;
   private String weight;
   private String name;
   private String symbol;
   private String group;
   private String number;
   private JFrame frame;

   public PopUp(int index, JFrame frame){
      this.index = index;
      this.frame = frame;
      try{
      File text = new File("elements.txt");
      this.e = new Scanner(text);
      }catch(Exception e){
      }
      findElement(); 
   }
   public void findElement(){
      boolean search = true;
      while(search && e.hasNextLine()){
         e.nextInt();
         e.nextInt();
         if(e.nextInt() == index + 1){
            String line = e.nextLine();
            printElem(line);
            break;           
         }
         else{
            if(e.hasNextLine()){
               e.nextLine();
            }
         }
      }
   }
   private void printElem(String fot){
        Scanner printer = new Scanner(fot);
        this.values = new String[10];
        int i = 1;
        int number = (index + 1);
        values[0] = String.valueOf(number);
        while(printer.hasNext()){
           values[i] = printer.next();
           i++;
        }
        matter();          
    }
    
    private void matter(){
        JOptionPane.showMessageDialog(frame,"Atomic Number:  " + values[0] + "\nAtomic Weight:  " + values[1] + "\nName:  " + values[2] + "\nAtomic Symbol:  "
         + values[3] + "\nClassification:  " + values[4] + "\nState:  " + values[5] + "\nMelting Point(in celcius):  " + values[6] + 
        "\nBoiling Point(in celcius):  " + values[7] + "\nDensity:  " + values[8] + "\nDiscovery Date:  " + values[9]);
    }
}