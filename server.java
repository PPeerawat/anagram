import java.net.*;
import java.io.*;
import java.io.IOException;

public class server {
    public static void main(String[] args){
		try {

            ServerSocket ServeSocket = new ServerSocket(0440);
            System.out.println("Socket connected");

            Socket s = ServeSocket.accept();
            System.out.println("Client connected");

            DataInputStream dataIn = new DataInputStream(s.getInputStream());
            DataOutputStream dataOut = new DataOutputStream(s.getOutputStream());
            System.out.println("Receive words from Client");
            
            String string1 = "Please input first word: ";   
            dataOut.writeUTF(string1);
            String word1 = (String)dataIn.readUTF(); 

            String string2 = "Please input second word: ";   
            dataOut.writeUTF(string2);
            String word2 = (String)dataIn.readUTF();
            
            String  message  = show(anagram(word1,word2));
            System.out.println("Wait for answer.");
            dataOut.writeUTF(message);

        } 
		catch (IOException e) { 
            System.out.println(e);
        }
	
	}

    public static int anagram(String wrd1,String wrd2){
        char[] ch1 = wrd1.toCharArray();
        char[] ch2 = wrd2.toCharArray();
        int flag = 0; 
        
        for(int i=0;i<wrd1.length();i++){
            ch1[i] = Character.toUpperCase(ch1[i]); 
        }
        for(int i=0;i< wrd2.length();i++){
            ch2[i] = Character.toUpperCase(ch2[i]);
        }
        if(wrd1.length()==wrd2.length()){
            for(int  i=0;i<wrd1.length();i++){
                for(int j=0;i<wrd2.length();j++){
                    if(ch1[i] == ch2[j]){
                        flag = 1;
                        break;
                    }
                }
                flag = 0;
            }
        }
        else {
            flag = 0;
        }
        return flag;
    }

    static String show(int flag){  
        String message;
        if(flag == 0){
           message = "Answer is word are not Anagram";	
        }
        else{
           message = "Answer is word are Anagram";	
        }
        return message;
	}
}