package com.kafka;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.KafkaFuture;

public class Topic {
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		Map<String, Object> config=new HashMap<String, Object>();		
		config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		AdminClient client = AdminClient.create(config); 
		NewTopic topic =new NewTopic("java", 1, (short) 1);
		CreateTopicsResult topicsResult = client.createTopics(Collections.singleton(topic));
		KafkaFuture<Void> future = topicsResult.all();
		future.get();		
		System.out.println("Topic is created successfully"+future.toCompletionStage());
	}

}
