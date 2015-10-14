package kr.ac.kookmin.exception.fileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* Makes numbered.txt the same as original.txt, but with each line numbered.
 * original.txt 파일을 읽은 다음 각각의 줄에 라인 넘버를 추가하여 numbered.txt파일로 저장하는 프로그램을 작성하시오. */
public class AddLineNumber
{
	public static void main(String[] args)
	{
		String path = AddLineNumber.class.getResource("").getPath();

		try
		{
			BufferedReader inputStream = 
					new BufferedReader(new FileReader(path+"original.txt"));
			PrintWriter outputStream = 
					new PrintWriter(new FileOutputStream(path+"numbered.txt"));

			//implement here
			String read_contents = null;
			String output = "";
			int counting_num = 1;

			while ((read_contents = inputStream.readLine()) != null){ 
				output+=counting_num+" ";
				counting_num++;

				output+=read_contents;
				output+="\n";
			}
			//System.out.println(output);

			PrintWriter write_contents = new PrintWriter(path+"numbered.txt");
			
			String write_this = output;
			write_contents.println(write_this);
			
			//System.out.println(write_this);
			
			write_contents.close( );
			inputStream.close( );
			outputStream.close( );
		}

		/** catch() 구문 작성하시오 **/
		catch(IOException error){

			System.out.print("error = ");
			System.out.println(error);
			System.exit(1);

		}

	}
}
