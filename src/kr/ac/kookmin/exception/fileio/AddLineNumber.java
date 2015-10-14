package kr.ac.kookmin.exception.fileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* Makes numbered.txt the same as original.txt, but with each line numbered.
 * original.txt ������ ���� ���� ������ �ٿ� ���� �ѹ��� �߰��Ͽ� numbered.txt���Ϸ� �����ϴ� ���α׷��� �ۼ��Ͻÿ�. */
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

		/** catch() ���� �ۼ��Ͻÿ� **/
		catch(IOException error){

			System.out.print("error = ");
			System.out.println(error);
			System.exit(1);

		}

	}
}
