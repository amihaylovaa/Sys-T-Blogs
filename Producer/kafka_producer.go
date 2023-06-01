package main

import (
	"github.com/Shopify/sarama"
)

var producer sarama.AsyncProducer

func createNewProducer() {
	config := sarama.NewConfig()

	p, err := sarama.NewAsyncProducer([]string{"localhost:29092"}, config)

	if err != nil {
		panic("Error")
	}

	producer = p
}

func createMessage(topic, message string, partition int32) *sarama.ProducerMessage {
	msg := &sarama.ProducerMessage{
		Topic:     topic,
		Partition: partition,
		Value:     sarama.StringEncoder(message),
	}

	return msg
}
