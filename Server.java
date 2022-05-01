import com.sun.net.httpserver.*;
import java.net.InetSocketAddress;
import java.io.IOException;
import org.json.simple.*;
import org.json.simple.parser.*;
import java.util.*;
import java.io.*;
import java.net.URI;
import java.sql.*;


public class Server 
{
    public static void main(String... args)
    {
        try
        {
            init_db();
            HttpServer server = HttpServer.create(new InetSocketAddress('https://superfrog-scheduler-frontend.herokuapp.com'),0);
            server.createContext("/api/profile", new ProfileHandler());
            server.createContext("/api/auth/login", new AuthHandler());
            server.createContext("/api/signup", new SignUpHandler());
            server.createContext("/",new FileHandler());
            server.setExecutor(null);
            server.start();
        }
        catch(IOException ioerror)
        {
            ioerror.printStackTrace();
        }
        catch(SQLException sqlerror)
        {
            sqlerror.printStackTrace();
        }
        catch(Exception error)
        {
            error.printStackTrace();
        }
    }

    public static void init_db() throws SQLException, ClassNotFoundException
    {
        Class.forName ("org.h2.Driver"); 
        Connection conn = DriverManager.getConnection ("jdbc:h2:./test");
        Statement st = conn.createStatement(); 
            try {
                st.executeUpdate("create table Event (userId int, name text,location text,date text,start_time text,end_time text, status text);");
                System.out.println("created the event table");
            }
            catch(SQLException sqlerror)
            {
                System.out.println("could not create the event table " + sqlerror);
            }
            st.close();
            st = conn.createStatement();
             try {
                st.executeUpdate("create table People (userId int, first_name text, last_name text, phone_number text, email text, password text, permission int, active int);");
                System.out.println("created the user table");
            }
            catch(SQLException sqlerror)
            {
                System.out.println("could not create the user table " + sqlerror);
            }
            st.close();
            conn.close();
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
            InputStream params = exchange.getRequestBody();
            JSONParser parser = new JSONParser();
            JSONObject login_info= (JSONObject)parser.parse(new InputStreamReader(params));
            String email = (String)login_info.get("account");
            String password = (String)login_info.get("password");

            Connection conn = DriverManager.getConnection ("jdbc:h2:./test"); 
            PreparedStatement preSt = conn.prepareStatement("select * from People where email = ? and password = ?");
            preSt.setString(1, email);
            preSt.setString(2, password);
            ResultSet results = preSt.executeQuery();
            if(results.last())
            {
                int rows = results.getRow();
                if(rows != 1)
                {
                    exchange.sendResponseHeaders(404, 0);
                    exchange.close();
                    return;
                }
                else
                {
                    if(results.getInt("active") == 0)
                    {
                        exchange.sendResponseHeaders(404, 0);
                        exchange.close();
                        return;
                    }
                    int perm_num = results.getInt("permission");
                    JSONObject token = new JSONObject();
                    token.put("token", createToken(perm_num));
                    token.put("permissions",perm_num);
                    StringWriter out = new StringWriter();
                    token.writeJSONString(out);
                    exchange.sendResponseHeaders(200, out.toString().length());
                    OutputStreamWriter writer = new OutputStreamWriter(exchange.getResponseBody());
                    token.writeJSONString(writer);
                    writer.flush();
                    exchange.close();
                    return;
                }
            }
            exchange.sendResponseHeaders(404, 0);
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
        catch(ParseException error)
        {
            error.printStackTrace();
        }
           catch(SQLException error)
        {
            error.printStackTrace();
        }
    }
    public String createToken(int number) throws IOException
    {
        JSONObject token = new JSONObject();
        token.put("permissions", number);
        StringWriter out = new StringWriter();
        token.writeJSONString(out);
        return Base64.getEncoder().encodeToString(out.toString().getBytes());
      

    }
}
class SignUpHandler implements HttpHandler
{
    public void handle(HttpExchange exchange)
    {
        try 
        {
        if(exchange.getRequestMethod().equals("POST"))
        {
            int count = 0;
            count++;
            InputStream params = exchange.getRequestBody();
            JSONParser parser = new JSONParser();
            JSONObject login_info= (JSONObject)parser.parse(new InputStreamReader(params));

            String first_name = (String)login_info.get("first_name");
            String last_name = (String)login_info.get("last_name");
            String email = (String)login_info.get("email");
            String phone = (String)login_info.get("phone+number");
            String confirm_password = (String)login_info.get("confirm_password");

            Connection conn = DriverManager.getConnection ("jdbc:h2:./test");
            
            PreparedStatement preSt = conn.prepareStatement("insert into People (userId, first_name, last_name, phone_number, email, password, permission, active) values (?, ?, ?, ?, ?, ?, ?, ?);");
            preSt.setString(1, String.valueOf(count));
            preSt.setString(2, first_name);
            preSt.setString(3, last_name);
            preSt.setString(4, phone);
            preSt.setString(5, email);
            preSt.setString(6, confirm_password);
            preSt.setString(7, String.valueOf(0));
            preSt.setString(8, String.valueOf(1));

            preSt.executeQuery();
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
        catch(ParseException error)
        {
            error.printStackTrace();
        }
           catch(SQLException error)
        {
            error.printStackTrace();
        }
    }
}

class FileHandler implements HttpHandler {
    public void handle(HttpExchange t) throws IOException {
        try
        {
        String root = "..";
        URI uri = t.getRequestURI();
        System.out.println(uri.toString());
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
          t.sendResponseHeaders(200, file.length());              

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
            System.out.println(error.toString());
        } 
    }
}