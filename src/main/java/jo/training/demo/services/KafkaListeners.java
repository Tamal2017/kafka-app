package jo.training.demo.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

  @KafkaListener(topics = "demoTopic", groupId = "001")
  public void listener(String data) {
    System.out.println("Receiving data : " + data + " :)");
  }

}
