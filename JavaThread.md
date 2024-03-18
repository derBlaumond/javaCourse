# Thread

1. java.lang.Thread class
   - Start a class that inherits Thread with `start()`.

2. **java.lang.Runnable interface**
   - To start a class that implements Runnable, give it as an argument to `new Thread()` when inheritance from another class is needed.

3. After inheriting the Thread class, override the code you want to support in the thread in the `run()` method.

4. Create an object of that thread and call the start() method of the thread object.

```java
public class Main extends Thread {
    public void run(){
        for (int i = 1; i < 11; i++){
            // Access the current thread with the Thread.currentThread() method.
            System.out.println("I am " + Thread.currentThread().getName() + " and my number is " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // If there is sleep, always create an exception to wake it up.
                this.interrupt();
            }
        }
    }
    public static void main(String[] args) {
        // Build new thread from runnable object and start that thread
        Thread a = new Thread(new Main());
        a.start();
    }
}
```

- Names are created as “Thread-n”.
- A thread can go to sleep for a specified period of time by invoking `Thread.sleep(long)`.

```java
public class SyncBlock {
    List<String> stringList = new ArrayList<>();
    
    synchronized void add(String s){
    // One of the two threads cannot run.
            stringList.add(s);
    }
    synchronized void print() {
            for (String s : stringList) System.out.println(s);
    }
}
```

- Threads waiting for a lock are in the "Blocked" state.
- The keyword `synchronized` can also be used in the headers of class and instance methods.
- A call to `notifyAll()` wakes up all threads waiting on the given object.