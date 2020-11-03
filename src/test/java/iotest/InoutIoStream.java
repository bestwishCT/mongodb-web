package iotest;

import java.io.FileOutputStream;
import java.io.IOException;

public class InoutIoStream {

	public static void main(String[] args) throws IOException {
		// 使用文件名称创建流对象
        FileOutputStream fos = new FileOutputStream("E:\\tmp\\fos.txt");     
      	// 写出数据
      	fos.write(97); // 写出第1个字节
      	fos.write(98); // 写出第2个字节
      	fos.write(99); // 写出第3个字节
      	// 关闭资源
        fos.close();
}
}