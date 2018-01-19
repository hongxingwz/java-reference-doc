# Java网络编程--Socket与ServerSocket

我们知道，程序可以通过ServerSocket和Socket两个类来实现TCP服务器、TCP客户端。下面我们通过一个简单的demo看一下代码中具体是怎么实现的。

## Client.java

```
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 30000);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = br.readLine();
        System.out.println("来自服务器的数据：" + line);
        br.close();
        socket.close();
    }
}
```

## Server.java


```
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(30000);
        while (true) {
            System.out.println("--------------");
            Socket s = ss.accept();
            PrintStream ps = new PrintStream(s.getOutputStream());
            ps.println("您好，您收到了服务器的新年祝福");
            ps.close();
            s.close();
        }
    }
}
```


##总结
这个简单的小demo就实现了客户端与服务端的通信。但是由于此种方式是基于阻塞API的，即当程序执行输入、输出操作后，在这些操作返回之前会一直阻塞该线程，所以服务器必须为每个客户端都提供一条独立线程进行处理，当服务器需要同时处理大量客户端时，这种做法会导致性能的下降。java提供了NIO API能够有效的解决这个问题，可以让服务器使用一个或者有限几个线程来同时处理连接到服务器上的所有客户端，以开发高性能的网络服务器。也就是Selector的应用。



