package iotest;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import scala.reflect.internal.Trees.New;

public class Caps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//write
//			OutputStream output = new FileOutputStream("E:\\tmp\\output-file.txt");
//			output.write("北京大学".getBytes());
//			output.close();
			//read
			InputStream input=new BufferedInputStream(new FileInputStream("E:\\tmp\\output-file.txt"));
			byte [] bytes=new byte[1024];
			int len=0;
			while((len=input.read(bytes))!=-1){
				System.out.println(new String(bytes, 0, len));
			}
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
