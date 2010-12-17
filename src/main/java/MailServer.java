import com.dumbster.smtp.SimpleSmtpServer;

import java.util.Scanner;

/**
 * Dominik Dorn 0626165 dominik.dorn@tuwien.ac.at
 */
public class MailServer {
  public static void main(String[] args)
  {





    MailCheckerThread thread = new MailCheckerThread(25);
    thread.start();

    Scanner sc = new Scanner(System.in);
    System.out.println("server started, press any key to stop");
    sc.nextLine();

    thread.stopProcess();




  }

  
}
