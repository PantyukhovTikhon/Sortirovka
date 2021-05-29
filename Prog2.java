import java.io.*;
import java.util.Scanner;

public class Prog2 {
	public static void main(String[] args) throws Exception {
		FileWriter fw = new FileWriter("f.txt", true);
		boolean flagEnd = false;
		fw.write(System.lineSeparator());
		fw.close();
		while (flagEnd == false) {
		fw = new FileWriter("f.txt", true);
		fw.write(System.lineSeparator());
		fw.close();
		flagEnd = func1();
		func2();
		}
	}
	
	public static Integer getMass (String str){
		String[] str1 = str.split(" ");
		int x = Integer.valueOf(str1[2]);
		return x;
	}
	
	public static boolean func1() throws Exception {
		FileWriter fw1 = new FileWriter("f1.txt");
		FileWriter fw2 = new FileWriter("f2.txt");
		FileReader fr = new FileReader("f.txt");		
		Scanner scan = new Scanner(fr);
		int ser1 = 0;
		int ser2 = 0;
		String str = scan.nextLine();
		String str1 = str;
		FileWriter curentFile = fw1;

        while (scan.hasNextLine()) {
        	int x = getMass(str); int y = getMass(str1);
        	if (x<=y) {
        		curentFile.write(str1 + System.lineSeparator());
        	}
        	else
        	{
        		curentFile.write(" ' ' ' " + System.lineSeparator());
        		if (curentFile == fw1) {
        				ser1++;
        				curentFile = fw2;
        			}
        		else {
        				ser2++;
        				curentFile = fw1;
        		}
        		curentFile.write(str1 + System.lineSeparator());
        	}
        	str = str1;
        	str1 = scan.nextLine();
        }
        curentFile.write(" ' ' ' " + System.lineSeparator());
        
        fw1.close();
		fw2.close();
		curentFile.close();
		fr.close();
		if (ser1 <= 1 && ser2 <= 1)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public static void func2() throws Exception {
		String str2, str1;
		FileWriter fw = new FileWriter("f.txt");
		FileReader fr1 = new FileReader("f1.txt");
		FileReader fr2 = new FileReader("f2.txt");
		Scanner scan1 = new Scanner(fr1);
		Scanner scan2 = new Scanner(fr2); 
		
        boolean flag1 = false;
        boolean flag2 = false;
        int x=0; int y=0;
        str1 = scan1.nextLine();
        str2 = scan2.nextLine();
        while (scan1.hasNextLine() || scan2.hasNextLine()){       
        	try {
        		x = getMass(str1);
        		flag1 = false;
        			}
        		catch (Exception e) {
        		flag1 = true;
        		}
        	try {
            	y = getMass(str2);
            	flag2 = false;
            		}
            	catch (Exception e) {
            		flag2 = true;
            		}
        	
        if (flag1 && flag2)
        {	
        	try {
        	str1 = scan1.nextLine();
        	}
        	catch (Exception e) {
        	 while(scan2.hasNextLine()) {
        		 str2 = scan2.nextLine();
        		 if (str2 != " ' ' ' ") {
        			 fw.write(str2 + System.lineSeparator());
        			 fw.flush();
        		 } 
        	 }
        	}
        	try {
        	str2 = scan2.nextLine();
        	}
        	catch (Exception e) {
        		while(scan1.hasNextLine()) {
           		 str1 = scan1.nextLine();
           		 if (str1 != " ' ' ' ") {
           			 fw.write(str1 + System.lineSeparator());
           			fw.flush();
           		 } 
           	 }
        	}
        }
        else if (flag1) {
        	fw.write(str2 + System.lineSeparator());
        	fw.flush();
        	str2 = scan2.nextLine();
        }
        else if (flag2) {
        	fw.write(str1 + System.lineSeparator());
        	fw.flush();
        	str1 = scan1.nextLine();
        }
        else if (x <= y) {
        	fw.write(str1 + System.lineSeparator());
        	fw.flush();
        	str1 = scan1.nextLine();
        }
        else {
        	fw.write(str2 + System.lineSeparator());
        	fw.flush();
        	str2 = scan2.nextLine();
        }
       }
        fw.close();
		fr1.close();
		fr2.close();
	}
}
