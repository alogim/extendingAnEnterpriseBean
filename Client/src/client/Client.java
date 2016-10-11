package client;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import server.DateBeanRemote;
public class Client
{
  public static void main(String[] args)
  {
    Properties jndiProps = new Properties();
    jndiProps.put(Context.INITIAL_CONTEXT_FACTORY,
                  "org.jboss.naming.remote.client.InitialContextFactory");
    jndiProps.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080");
    jndiProps.put(Context.SECURITY_PRINCIPAL, "user");
    jndiProps.put(Context.SECURITY_CREDENTIALS, "password");
    jndiProps.put("jboss.naming.client.ejb.context", true);

    try
    {
      InitialContext context = new InitialContext(jndiProps);
      DateBeanRemote myDateBeanRemote = (DateBeanRemote) context.lookup(
        "/Server/Server-ejb/DateBean!server.DateBeanRemote");
      System.out.println(myDateBeanRemote.getTimeAndDate());
      System.out.println(myDateBeanRemote.getTimeAndDate());
    }
    catch (NamingException ex)
    {
      System.out.println(ex.getMessage());
    }
  }
}
