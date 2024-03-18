# Socket


## Java Socket
A **Socket** is an endpoint for communication between two machines. The Java `Socket` class provides a mechanism for the client and the server to communicate over a network. The `ServerSocket` class is used by the server to listen for incoming client connections. When a `ServerSocket` accepts a connection request, it returns a `Socket` on the server side that is connected to the client's socket.

- **Server Side**: The `ServerSocket` is created to listen on a specific port (`4444` in this case). When a client connects, `accept()` method returns a `Socket` instance representing the client connection.
- **Client Side**: The client creates a `Socket` instance attempting to connect to the server's IP address and port. Once connected, both client and server can exchange messages.

## BufferedReader and PrintWriter
- **BufferedReader** and **PrintWriter** are Java's higher-level I/O classes used for reading and writing data respectively.
- **BufferedReader** reads text from an input stream (like the socket's input stream) efficiently by buffering the characters. This means it stores characters so that it can efficiently read and return data, line by line or however it's needed.
- **PrintWriter** offers methods to write data to an output stream. It makes it easy to write formatted text to the connected socket. The `flush()` method is called to ensure all data is sent over the socket before closing it.

## Client & Server System Using Sockets

In this system, the **server** listens for connections on a port and echoes back any messages it receives. The **client** sends a message to the server and prints the response. `BufferedReader` and `PrintWriter` facilitate text-based input and output operations over the socket's streams, making the client-server communication efficient and straightforward. This basic framework can be extended for more complex client-server interactions, including handling multiple clients, secure data transmission, and more sophisticated protocols beyond simple message echo.

- **Server Workflow**:
  1. Initialize a `ServerSocket` on a specific port.
  2. Wait for a client to connect using the `accept()` method. This method blocks until a connection is made.
  3. Once a connection is accepted, create `BufferedReader` and `PrintWriter` from the socket's input and output streams to read from and write to the client.
  4. Read a message sent by the client with `BufferedReader`.
  5. Echo the message back to the client using `PrintWriter`.
  6. Close the socket connection.

```java
public class Server {
    public static void main(String[] args) {
        Socket socket = null;
        ServerSocket server_socket = null;
        BufferedReader in = null;
        
        PrintWriter out = null;
        
        try {
            server_socket = new ServerSocket(4444);
        } catch(IOException e) {
            System.out.println("The port is already open.");
        }
        
        try {
            System.out.println("The server has opened.");
            socket = server_socket.accept(); // Create server, Client waits for connection
            
            in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Create input stream
            
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))); // Create output stream
            
            String str = null;
            str = in.readLine(); // Read data from Client
            
            System.out.println("Message from Client: " + str);
            
            out.write(str); // Similar to print(str).
            out.flush(); // Flushes the output stream and forces any buffered output bytes to be written out.
            socket.close(); // Closes the stream and releases any system resources associated with it. 
        } catch(IOException e) {
            
        }
    }
}
```

- **Client Workflow**:
  1. Connect to the server using its IP address and port number by creating a `Socket`.
  2. Create `BufferedReader` to read from the console and `PrintWriter` for sending messages to the server through the socket's output stream.
  3. Send a message to the server.
  4. Read the server's response.
  5. Close the socket.

```java
public class Client {
    public static void main(String[] args) {
        Socket socket = null; // Client's Socket to communicate with Server
        BufferedReader in = null; // Input stream to read data from Server
        BufferedReader in2 = null; // Input stream to read data from keyboard
        PrintWriter out = null; // Output stream to send data to Server
        InetAddress ia = null;
        
        try {
            ia = InetAddress.getLocalHost(); // Enter server address to connect to server
            socket = new Socket(ia, 4444);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
            // Declare BufferedReader
            in2 = new BufferedReader(new InputStreamReader(System.in)); 
            // Declare BufferedReader2
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))); // The same as above
            
            System.out.println(socket.toString());
        } catch(IOException e) {
        }
        
        try {
            System.out.print("Message to send to server: ");
            String data = in2.readLine(); // Input from keyboard
            out.println(data);
            out.flush();
            
            String str2 = in.readLine(); // Read data returned from the server
            System.out.println("Message returned from server: " + str2);
            socket.close();
        } catch(IOException e) {
        }
    }
}
```