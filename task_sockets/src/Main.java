import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader in = null;
        BufferedWriter out = null;
        Scanner sc = new Scanner(System.in);
        String matrikelnummer = "411995";
        System.out.println("Welcome to the PROG1 trading system!");
        System.out.println("Please, enter your authentication key: 411995");
        try{
            socket = new Socket("vm3.mcc.tu-berlin.de", 8080);
            InputStreamReader streamIn = new InputStreamReader(socket.getInputStream());
            OutputStream streamOut = socket.getOutputStream();
            in = new BufferedReader(streamIn);
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String line = null;
            String answer = "";
            int i;
            socket.getOutputStream().write(matrikelnummer.getBytes());
            socket.getOutputStream().write(-1);
            // 65533 = btye value of the delimiter
            while((i=in.read())!= 65533){
                answer = answer + (char) i;
            }
            System.out.println(answer);
            while (true){

                System.out.println("Please, enter one of the following commands:\n" +
                        "0 login\n" +
                        "1 register user\n" +
                        "2 unblock user\n" +
                        "3 delete user\n" +
                        "4 to exit.");
                String outMsg = sc.nextLine();
                if(outMsg.equalsIgnoreCase("4")){
                    socket.getOutputStream().write((outMsg + "\n").getBytes());
                    socket.getOutputStream().write(-1);
                    socket.getOutputStream().flush();
                    break;
                }
                if(outMsg.equalsIgnoreCase("0")){
                    System.out.print("Username: ");
                    String id = sc.nextLine();
                    System.out.print("Security number: ");
                    String pw = sc.nextLine();
                    String account = "5 "+id+" "+pw;
                    socket.getOutputStream().write(account.getBytes());
                    socket.getOutputStream().write(-1);
                    System.out.println(in.readLine());
//                    while((line = in.readLine())!=null){
//                        System.out.println(line);
//                    }
                    socket.getOutputStream().flush();
                    continue;
                }
                if(outMsg.equalsIgnoreCase("1")){
                    System.out.print("Please, enter your username: ");
                    String id = sc.nextLine();
                    System.out.print("Please, enter your security number: ");
                    String pw = sc.nextLine();
                    String account = "0 "+id+" "+pw;
                    socket.getOutputStream().write(account.getBytes());
                    socket.getOutputStream().write(-1);
                    System.out.println("Answer: Authentication ok; User "+ id +" registered");
                    socket.getOutputStream().flush();
                    continue;
                }
                if(outMsg.equalsIgnoreCase("2")){
                    System.out.print("Username for unblock: ");
                    String id = sc.nextLine();
                    System.out.print("Security number: ");
                    String pw = sc.nextLine();
                    String account = "1 "+id+" "+pw;
                    socket.getOutputStream().write(account.getBytes());
                    socket.getOutputStream().write(-1);
                    socket.getOutputStream().flush();
                    continue;
                }
                if(outMsg.equalsIgnoreCase("3")){
                    System.out.print("Username for deletion: ");
                    String id = sc.nextLine();
                    System.out.print("Security number: ");
                    String pw = sc.nextLine();
                    String account = "2 "+id+" "+pw;
                    socket.getOutputStream().write(account.getBytes());
                    socket.getOutputStream().write(-1);
                    socket.getOutputStream().flush();
                    continue;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                sc.close();
                out.close();
                in.close();
                socket.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }

    }



}
