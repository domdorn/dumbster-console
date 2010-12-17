import com.dumbster.smtp.SimpleSmtpServer;
import com.dumbster.smtp.SmtpMessage;

import java.util.Iterator;

/**
 * Dominik Dorn 0626165 dominik.dorn@tuwien.ac.at
 */
public class MailCheckerThread extends Thread {

  SimpleSmtpServer server;
  volatile boolean running = true;
  int port = 25;

  public MailCheckerThread(int port)
  {
    this.port = port;
  }

  public void stopProcess()
  {
    running = false;
  }


  @Override
  public void start()
  {
    super.start();
  }



  @Override
  public void run()
  {
    System.out.println("started MailCheckerThread");
    server = SimpleSmtpServer.start(port);
    System.out.println("started SimpleSmtpServer");
    System.out.println("\n\n\n\nMessages:\n\n");
    while(running)
    {
      if(server.getReceivedEmailSize() > 0)
      {
        Iterator iter = server.getReceivedEmail();

        while(iter.hasNext())
        {
          SmtpMessage message = (SmtpMessage) iter.next();
          System.out.println("message.getBody() = " + message.getBody());
          System.out.println("====================\n\n\n");
        }
        try {
          Thread.sleep(1000l);
        }
        catch (InterruptedException e) {
          System.out.println("interrupted");
        }
        System.out.println("finished reading messages, starting new server");
        System.out.println("====================\n\n\n");
        server.stop();
        if(server.isStopped())
        {
          server = new SimpleSmtpServer(port);
          System.out.println("new server started");
        }
      }
    }
    server.stop();
  }
}
