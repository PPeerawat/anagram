import java.io.*;
import java.net.*;
import java.util.Scanner;

public class client {
   
    public static void main(String[] args) { 
        Scanner inputWord = new Scanner(System.in);
        try{
            Socket s = new Socket("172.28.144.1", 0440);

            DataOutputStream dataOut = new DataOutputStream(s.getOutputStream());
            DataInputStream dataIn = new DataInputStream(s.getInputStream());

            String string1 = (String)dataIn.readUTF();
            System.out.println(string1);

            String input1 = inputWord.nextLine();
            dataOut.writeUTF(input1);

            String string2 = (String)dataIn.readUTF();
            System.out.println(string2);

            String input2 = inputWord.nextLine();
            dataOut.writeUTF(input2);

            String answer = (String)dataIn.readUTF();
            System.out.println(answer);  
            
            
            dataOut.flush();
            dataOut.close();
            s.close();

        } 
        catch (IOException e){
            System.out.println(e); 
        }
    }
}