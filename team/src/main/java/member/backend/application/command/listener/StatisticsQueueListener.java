package member.backend.application.command.listener;

import org.axonframework.amqp.eventhandling.DefaultAMQPMessageConverter;
import org.axonframework.amqp.eventhandling.spring.SpringAMQPMessageSource;
import org.axonframework.serialization.Serializer;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;

@Service
public class StatisticsQueueListener {

	@Bean
	public SpringAMQPMessageSource statisticsQueue(Serializer serializer) {
		return new SpringAMQPMessageSource(new DefaultAMQPMessageConverter(serializer)) {

			@RabbitListener(queues = "Members")
			@Override
			public void onMessage(Message message, Channel channel) throws Exception {
				System.out.println("************** RabbitListener ***************");
				System.out.println(message);
				super.onMessage(message, channel);
			}
		};
	}	
	
}
