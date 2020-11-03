package iotest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;


public class ByteCharArrayIo {

	public static void main(String[] args) {
		//1 ByteArrayInputStream
//		byte [] buf=new byte[1024];
//		ByteArrayInputStream bais=new ByteArrayInputStream(buf);
//		//读取第一个字节
//		int data = bais.read();
//		while(data !=-1){
//			//操作
//			System.out.println(data);
//			//读取下一个字节
//			bais.read();
//		}
		//2 CharArrayReader  用来读字符数组
		char [] charBuf=new char[]{'a','b','c','d','e'};
		Reader car=new CharArrayReader(charBuf);
		try {
			int ch=car.read();
			while(ch!=-1){
				System.out.println(ch);
				ch=car.read();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//3 CharArrayWriter 用来写字符数组
//		char [] cwCharArray=new char[]{'m','m','p'};
//		CharArrayWriter cw=new CharArrayWriter();
//		try {
//			cw.write(cwCharArray);
//			char[] buf = cw.toCharArray();
//			System.out.printf("%04x\n", (int)buf[0]);
//		   } catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

	}

}
