import java.net.*;
import java.io.*;
import java.security.*;

import javax.net.ssl.*;

public class HTTPSClient {

  public static void main(String[] args) {
    int port = 443; // default https port
    String host = "blairstorage.blob.core.chinacloudapi.cn";

    try {
      SSLSocketFactory factory
       = (SSLSocketFactory) SSLSocketFactory.getDefault();

      SSLSocket socket = (SSLSocket) factory.createSocket(host, port);

      // enable all the suites
      String[] supported = socket.getSupportedCipherSuites();
      socket.setEnabledCipherSuites(supported);

      Writer out = new OutputStreamWriter(socket.getOutputStream());
      // https requires the full URL in the GET line
      out.write("GET http://" + host + "/ HTTP/1.1\r\n");
      out.write("Host: " + host + "\r\n");
      out.write("\r\n");
      out.flush();

      // read response
      BufferedReader in = new BufferedReader(
        new InputStreamReader(socket.getInputStream()));

      // read the header
      String s;
      while (!(s = in.readLine()).equals("")) {
          System.out.println(s);
      }
      System.out.println();

      // read the length
      String contentLength = in.readLine();
      int length = Integer.MAX_VALUE;
      try {
        length = Integer.parseInt(contentLength.trim(), 16);
      }
      catch (NumberFormatException ex) {
        // This server doesn't send the content-length
        // in the first line of the response body
      }
      System.out.println(contentLength);

      int c;
      int i = 0;
      while ((c = in.read()) != -1 && i++ < length) {
        System.out.write(c);
      }

      System.out.println();
      out.close();
      in.close();
      socket.close();

    }
    catch (IOException ex) {
      System.err.println(ex);
    }

  }

}

   /**
   *   Java Network Programming, Third Edition
   *   By Elliotte Rusty Harold
   *   Third Edition October 2004
   *   ISBN: 0-596-00721-3
   */

