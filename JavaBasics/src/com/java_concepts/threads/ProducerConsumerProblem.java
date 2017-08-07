package com.java_concepts.threads;

public class ProducerConsumerProblem {

	public static void main(String[] args) {
		Object object = new Object();

		Thread t1 = new Thread() {
			@Override
			public void run() {
				synchronized (object) {
					while(true){
						try {
							sleep(2000);
							System.out.println("Anil ");
							object.notify();
							object.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		};
		t1.setName("Thread1");
		t1.start();

		Thread t2 = new Thread() {
			@Override
			public void run() {

				synchronized (object) {
					while(true){
						try {
							sleep(2000);
							System.out.print("Suri ");
							object.notify();
							object.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		};
		t2.setName("Thread2");
		t2.start();
	}

}
