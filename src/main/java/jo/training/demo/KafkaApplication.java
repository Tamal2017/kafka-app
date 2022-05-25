package jo.training.demo;

import java.util.stream.IntStream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaApplication {

  public static void main(String[] args) {
    SpringApplication.run(KafkaApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
    return args -> {
      kafkaTemplate.send("demoTopic", "Hello first message! :) ");
      IntStream.rangeClosed(1, 1_000)
          .forEach(i -> kafkaTemplate.send("demoTopic", "Hello on demo topic :) " + i));
    };
  }
}
