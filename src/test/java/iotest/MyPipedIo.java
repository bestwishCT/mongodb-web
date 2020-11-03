package iotest;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class MyPipedIo {
	public static void main(String[] args) throws IOException, InterruptedException {

		final PipedOutputStream pos = new PipedOutputStream();
		final PipedInputStream pis = new PipedInputStream(pos);
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					pos.write("Hello world pipe !".getBytes());
					//用完关闭
					pos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					int data = pis.read();
					while (data != -1) {
						System.out.println((char) data);
						data = pis.read();
					}
					pis.close();//用完关闭
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		t1.start();
		t2.start();
		t1.join();
		t2.join();
//		pis.close();
//		pos.close();
	}
}
