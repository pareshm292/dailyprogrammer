package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class RecurringCharacter implements Runnable {


	public static void main(String[] args) {

		/*List<String> words = Arrays.asList("IKEUNFUVFV" ,"PXLJOUDJVZGQHLBHGXIW", "*l1J?)yn%R[}9~1\"=k7]9;0[$");

		words.stream().forEach(word -> {

			int recurringChar = 0;
			Set<Integer> set = new HashSet<>();	
			recurringChar = word.chars().boxed()
					// .flatMap(word -> word.chars().boxed())
					.filter(c -> !set.add(c))
					.findFirst()
					.orElse(-1);

			System.out.println((char)recurringChar);
		}); */
		
		//List<RecurringCharacter> runnables = new ArrayList<>();
		List<Thread> thr = new ArrayList<>();
		
		thr.forEach(thread -> thread.start());
		
		ExecutorService service = Executors.newFixedThreadPool(5);
		
		IntStream.range(0, 10).forEach(i -> service.submit(new RecurringCharacter()));
	
		service.shutdown();
	}

	@Override
	public void run() {

		try {
			long startTime = System.currentTimeMillis();
			int sleep = new Random().nextInt(10);
			System.out.println(Thread.currentThread().getName() + " sleeping for " + sleep + " seconds");
			Thread.sleep(sleep*1000);
			callingSyncronizedMethod();
			long endTime = System.currentTimeMillis();
			System.out.println("Thread name : " + Thread.currentThread().getName() + " woke up after "
					+ (endTime - startTime)/1000 + " s. ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	private synchronized void callingSyncronizedMethod() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " has lock on resource " );
	}
}
