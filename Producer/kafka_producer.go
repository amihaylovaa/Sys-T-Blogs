package main

import (
	"fmt"

	"github.com/Shopify/sarama"
)

func createNewProducer() sarama.SyncProducer {
	config := sarama.NewConfig()
	config.Producer.Partitioner = sarama.NewRandomPartitioner

	p, err := sarama.NewSyncProducer([]string{"localhost:29092"}, config)

	if err != nil {
		fmt.Println(err)

		return nil
	}

	return p
}

func sendMessage(topic, message string, partition int32, producer sarama.SyncProducer) {
	msg := &sarama.ProducerMessage{
		Topic:     topic,
		Partition: partition,
		Value:     sarama.StringEncoder(message),
	}

	_, _, err := producer.SendMessage(msg)

	if err != nil {
		fmt.Println(err)
	}
}
