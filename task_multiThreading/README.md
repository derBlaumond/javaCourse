#### 1. Atomic Incrementation

**Objective**: Implement the `AtomicIncrementer` class, which adheres to the `util.Incrementer` interface. This class is responsible for implementing a counter that can be read, incremented, and reset through methods defined by the interface, ensuring thread safety and preventing unwanted effects such as race conditions during concurrent access by multiple parallel threads.

**Key Java Skills**:
- Understanding and implementing interfaces.
- Ensuring thread safety in Java.
- Atomic operations to prevent race conditions.
- Usage of synchronization mechanisms or atomic variables to guarantee that all operations on the counter are atomic.

**Implementation Tasks**:
- Implement missing methods as defined by the interface.
- Ensure all operations (methods) are atomic and thread-safe.
- Test implementation with provided `TestAtomicIncrementer` tests.

#### 2. InputStreams and Multithreaded Quicksort

**Objective**: Read numbers from `numbers.txt` in the project's `resources` folder, transfer them into an Integer array, and sort this array using the Quicksort algorithm known from Programming I. However, each recursion step should hand over to fresh threads, making the implementation multi-threaded rather than merely recursive.

**Key Java Skills**:
- Working with I/O Streams to read data from files.
- Understanding and implementing multithreading in Java.
- Applying the Quicksort algorithm in a multithreaded environment.
- Synchronizing threads to ensure the correct execution order and data consistency.

**Implementation Tasks**:
1. **Main.java (3 Points)**:
   - Modify only the `readAndSort()` method to read the Integer array from the given file using `FileInput.readIntsFromFile()` and sort the array by starting a thread with a `QuicksortRunnable` containing the array.
   - Wait for the thread to finish and then return the sorted array.

2. **FileInput.java (4 Points)**:
   - Implement `readIntsFromFile()` method to read the file and write its content into an Integer array. Each line of the file is expected to contain exactly one Integer and is not empty. If an invalid file path is provided, return an empty Integer array.

3. **QuicksortRunnable.java (6 Points)**:
   - Implement the `run()` method of the `QuicksortRunnable` class. The class should execute the recursive Quicksort algorithm by starting new threads for each recursion step.
   - The `QuicksortRunnable` is given an object of type `Partition` containing all the information necessary for a recursion step.

**Testing**:
- Test your solution with the provided `TestReadAndSort` class for verifying the correct implementation of the InputStreams and multithreaded Quicksort functionality.

These tasks demonstrate critical Java programming skills including interface implementation, file I/O operations, understanding of atomic operations and thread safety, as well as advanced concepts like multithreading and recursion in sorting algorithms.