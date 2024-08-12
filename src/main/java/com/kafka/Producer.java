package com.kafka;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

public class Producer {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		Map<String, Object> config=new HashMap<String, Object>();
		 config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
	        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

	       
		KafkaProducer<String,String> producer=new KafkaProducer<String, String>(config);
		 ProducerRecord<String, String> record = new ProducerRecord<>("java", "4", "Hello 23sdnjdserg");
		 RecordMetadata metadata = producer.send(record).get();
		 System.out.println("Topic "+metadata.topic()+" "+"producer sended the message");
		 producer.close();
	}

}
