package member.backend.infrastructure.config.amqp;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AmqpConfig {

	@Bean
	public org.springframework.amqp.core.Exchange exchange(){
		return ExchangeBuilder.fanoutExchange("Members").build();
	}
	
	@Bean
	public org.springframework.amqp.core.Queue queue() {
		return QueueBuilder.durable("Members").build();
	}
	
	@Bean
	public Binding binding() {
		return BindingBuilder.bind(queue()).to(exchange()).with("*").noargs();
	}
	
	@Autowired
	public void configure(AmqpAdmin admin) {
		admin.declareExchange(exchange());
		admin.declareQueue(queue());
		admin.declareBinding(binding());
	}	
	
}
