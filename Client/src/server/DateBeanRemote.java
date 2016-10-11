package server;

import javax.ejb.Remote;

@Remote
public interface DateBeanRemote
{
  String getTimeAndDate();
}
