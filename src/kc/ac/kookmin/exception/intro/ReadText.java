
package kc.ac.kookmin.exception.intro;

import java.io.*; 
import java.io.BufferedReader; 
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

// a.text 파일을 읽는 메소드를 가진 클래스를 만들어보자.
class AAA {

	public void readFile() {

		BufferedReader Read_this = null; 
		String read_contents = null; 

		String output = "Output for mobile-programming lab6-a.text"+"\n";

		try { 

			/* String path = AAA.class.getResource("").getPath(); 를 해주면
			 * 현재 디렉토리 위치를 리턴하기 때문에 이를 이용하여 file 위치를 가져올 수 있다. */
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

			//finally엔 close를 해주자. 
			//close 함수를 만들어서 그 안에서 파일을 close하는 작업이랑 close를 위한 try-catch를 해보자

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
