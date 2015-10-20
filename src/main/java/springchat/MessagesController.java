package springchat;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.collections4.queue.CircularFifoQueue;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MessagesController {

    private final AtomicLong counter = new AtomicLong();
    private final Queue<Message> messages = new CircularFifoQueue<Message>();

    @RequestMapping(value="/message", method=RequestMethod.POST)
    public @ResponseBody Message message(
            @RequestParam(value="name", required=true) String name, 
            @RequestParam(value="text", required=true) String text) {
      System.out.println("==== in message ====");
      Message message = new Message(counter.incrementAndGet(), name, text);
      messages.add(message);
      return message;
    }

    @RequestMapping(value="/messages", method=RequestMethod.GET)
    public @ResponseBody Message[] messages() {
      System.out.println("==== in messages ====");
      return messages.toArray(new Message[0]);
    }
}