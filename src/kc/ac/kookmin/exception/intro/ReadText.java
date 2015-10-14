
package kc.ac.kookmin.exception.intro;

import java.io.*; 
import java.io.BufferedReader; 
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

// a.text ������ �д� �޼ҵ带 ���� Ŭ������ ������.
class AAA {

	public void readFile() {

		BufferedReader Read_this = null; 
		String read_contents = null; 

		String output = "Output for mobile-programming lab6-a.text"+"\n";

		try { 

			/* String path = AAA.class.getResource("").getPath(); �� ���ָ�
			 * ���� ���丮 ��ġ�� �����ϱ� ������ �̸� �̿��Ͽ� file ��ġ�� ������ �� �ִ�. */
			String path1 = AAA.class.getResource("").getPath();
			String path2 = path1+"a.txt";

			Read_this = new BufferedReader(new InputStreamReader
					(new FileInputStream(path2), "euc-kr")); 

			while ((read_contents = Read_this.readLine()) != null){ 
				output+=read_contents;
			} 

			System.out.println(output); //print contents

		} catch (IOException e1) { 
			
			System.out.print("error = ");
			System.out.println(e1);
			System.exit(1);
			
		} finally { 

			//finally�� close�� ������. 
			//close �Լ��� ���� �� �ȿ��� ������ close�ϴ� �۾��̶� close�� ���� try-catch�� �غ���

			try { 
				if (Read_this != null)	
					Read_this.close(); 
			}
			catch (IOException e2) 
			{ 
				System.out.print("error = ");
				System.out.println(e2);
				System.exit(1); 
				
			} 
			
		} 
	} 
}

public class ReadText {

	public static void main(String args[]) {
		AAA a = new AAA();
		a.readFile();	
	}

} 
