class ThreadDemo extends Thread{
	public void run(){
		for(int i=0; i<4; i++){
			System.out.println(Thread.currentThread().getName() + "\tCount : " + i);
			try {
                  // Sleep for 500 milliseconds
                Thread.sleep(500); 
            } 
            catch (InterruptedException e) {
                System.out.println("Thread interrupted");
			}
		}
	}
	
	public static void main(String[] args){
		System.out.println("Name of main thread before:"+ currentThread().getName());
		System.out.println("Priority of main thread before:"+ currentThread().getPriority());
		currentThread().setName("Main method thread");
		currentThread().setPriority(10);
		System.out.println("Name of main thread after:"+ currentThread().getName());
		System.out.println("Priority of main thread after:"+ currentThread().getPriority());
		
		ThreadDemo thread1 = new ThreadDemo();
		ThreadDemo thread2 = new ThreadDemo();
		thread1.setName("Thread-1");
		thread2.setName("Thread-2");
		
		thread1.start();
		thread2.start();
	}
}