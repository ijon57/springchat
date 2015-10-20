package springchat;

import java.util.Date;

public class Message {

  private final long id;
  private final String name;
  private final String text;
  private final Date time;


  public Message(long id, String name, String text){
    this.id = id;
    this.name = name;
    this.text = text;
    this.time = new Date();
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getText() {
    return text;
  }

  public Date getTime() {
    return time;
  }
}