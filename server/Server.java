import com.sun.net.httpserver.*;
import java.net.InetSocketAddress;
import java.io.IOException;
import org.json.simple.JSONObject;
import java.util.*;
import java.io.*;
import java.net.URI;
public class Server 
{
    public static void main(String... args)
    {
        try
        {
        HttpServer server = HttpServer.create(new InetSocketAddress(4000),0);
        server.createContext("/api/profile", new ProfileHandler());
        server.createContext("/api/auth/login", new AuthHandler());
        server.createContext("/",new FileHandler());
        server.setExecutor(null);
        server.start();
        }
        catch(IOException ioerror)
        {
            ioerror.printStackTrace();
        }

    }   
}

class ProfileHandler implements HttpHandler
{
    public void handle(HttpExchange exchange)
    {
        try 
        {
        if(exchange.getRequestMethod().equals("GET"))
        {
            JSONObject data = new JSONObject(); 
            data.put("code", 200);
            data.put("message", "Request success");
            data.put("type", "success");
            JSONObject result = new JSONObject();
            result.put("name", "John");
            result.put("age", 18);
            result.put("avatar", "/images/tiantan.jpg" );
            result.put("permissions", Arrays.asList("customer","director"));
            data.put("result", result);
            StringWriter out = new StringWriter();
            data.writeJSONString(out);
            exchange.sendResponseHeaders(200, out.toString().length());
            OutputStreamWriter writer = new OutputStreamWriter(exchange.getResponseBody());
            data.writeJSONString(writer);
            writer.flush();
            exchange.close();
        }
        else
        {
            exchange.sendResponseHeaders(404, 0);
            exchange.close();
        }
        }
        catch(IOException ioerror)
        {
            ioerror.printStackTrace();
        }
    }
}

class AuthHandler implements HttpHandler
{
    public void handle(HttpExchange exchange)
    {
        try 
        {
        if(exchange.getRequestMethod().equals("POST"))
        {
            exchange.sendResponseHeaders(200, 0);
            exchange.close();
        }
        else
        {
            exchange.sendResponseHeaders(404, 0);
            exchange.close();
        }
        }
        catch(IOException ioerror)
        {
            ioerror.printStackTrace();
        }
    }
}

class FileHandler implements HttpHandler {
    public void handle(HttpExchange t) throws IOException {
        try
        {
        String root = ".";
        URI uri = t.getRequestURI();
        if(uri.getPath().equals("/"))
        {
            uri = new URI("/index.html");
        }
        System.out.println("looking for: "+ root + uri.getPath());
        String path = uri.getPath();
        File file = new File(root + path).getCanonicalFile();

        if (!file.isFile()) {
          // Object does not exist or is not a file: reject with 404 error.
          String response = "404 (Not Found)\n";
          t.sendResponseHeaders(404, response.length());
          OutputStream os = t.getResponseBody();
          os.write(response.getBytes());
          os.close();
        } else {
          // Object exists and is a file: accept with response code 200.
          String mime = "text/html";
          if(path.substring(path.length()-3).equals(".js")) mime = "application/javascript";
          if(path.substring(path.length()-3).equals("css")) mime = "text/css";            

          Headers h = t.getResponseHeaders();
          h.set("Content-Type", mime);
          t.sendResponseHeaders(200, 0);              

          OutputStream os = t.getResponseBody();
          FileInputStream fs = new FileInputStream(file);
          final byte[] buffer = new byte[0x10000];
          int count = 0;
          while ((count = fs.read(buffer)) >= 0) {
            os.write(buffer,0,count);
          }
          fs.close();
          os.close();
        } 
        } catch(Exception error)
        {

        } 
    }
}