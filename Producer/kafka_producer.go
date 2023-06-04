package main

import (
	"fmt"

	"github.com/Shopify/sarama"
)

func createNewProducer() sarama.AsyncProducer {
	config := sarama.NewConfig()

	p, err := sarama.NewAsyncProducer([]string{"localhost:29092"}, config)

	if err != nil {
		fmt.Println(err)
	}

	return p
}

func createMessage(topic, message string, partition int32, producer sarama.AsyncProducer) {
	msg := &sarama.ProducerMessage{
		Topic:     topic,
		Partition: partition,
		Value:     sarama.StringEncoder(message),
	}

	producer.Input() <- msg
}
