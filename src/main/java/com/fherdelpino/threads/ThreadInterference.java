package com.fherdelpino.threads;

public class ThreadInterference {

	int duration = 1000;
	Counter counter = new Counter();

	class Counter {
		private int c = 0;

		public void increment() {
			c++;
		}

		public void decrement() {
			c--;
		}

		public int value() {
			return c;
		}

	}

	class SingleThread implements Runnable {
		
		boolean increment;
		
		public SingleThread(boolean increment) {
			this.increment = increment;
		}

		@Override
		public void run() {
			long startTime = System.currentTimeMillis();

			try {
				while (System.currentTimeMillis() - startTime < duration) {
					if (increment)
						counter.increment();
					else
						counter.decrement();
					System.out.print(Thread.currentThread().getName() + ":");
					System.out.println(counter.value());
					Thread.sleep(100);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	public void run() {
		Thread t1 = new Thread(new SingleThread(true));
		Thread t2 = new Thread(new SingleThread(false));
		t1.start();
		t2.start();
		
	}

	public static void main(String args[]) {
		new ThreadInterference().run();
	}

}
