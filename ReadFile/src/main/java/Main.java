/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alamia
 */
public class Main {

    public static void main(String [] arg){
       try{
         InputStreamerReader r = new InputStreamerReader(System.in);
         BufferedReader br = new BufferedReader(r);
         BufferedWriter bw = new BufferedWriter( new FileWriter (fileName:"C:\\Users\\alamia\\Javanet"));
         String name ="",
         while(!name.equals("stop")){
                try{
                  System.out.print("Enter Data : ");
                  name =br.readline();
                  if (!name.equals("stop")){
                      bw.write(str: name + "\n");



                     }

                }
              
                catch (IOException ex){
                         System.out.println("An Error Has Occurred");



                }


          }


         }

    



      }
}
