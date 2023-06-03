package main

import (
	"github.com/Shopify/sarama"
)

func createNewProducer() sarama.AsyncProducer {
	config := sarama.NewConfig()

	p, err := sarama.NewAsyncProducer([]string{"localhost:29092"}, config)

	if err != nil {
		panic("Error")
	}

	return p
}

func createMessage(topic, message string, partition int32) *sarama.ProducerMessage {
	msg := &sarama.ProducerMessage{
		Topic:     topic,
		Partition: partition,
		Value:     sarama.StringEncoder(message),
	}

	return msg
}
