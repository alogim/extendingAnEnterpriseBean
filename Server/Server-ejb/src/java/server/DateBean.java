package server;

import java.util.Date;
import javax.ejb.Stateless;

@Stateless
public class DateBean implements DateBeanRemote
{
  @Override
  public String getTimeAndDate()
  {
    Date date = new Date();
    String str = String.format("%1$tT:%1$tL, %1$td %1$tB %1$tY", date);
    return str;
  }
}
