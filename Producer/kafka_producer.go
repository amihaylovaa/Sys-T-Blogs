package main

import (
	"log"

	"github.com/Shopify/sarama"
)

func createNewProducer() (sarama.SyncProducer, error) {
	config := sarama.NewConfig()
	config.Producer.Partitioner = sarama.NewRandomPartitioner
	config.Producer.Return.Successes = true

	p, err := sarama.NewSyncProducer([]string{"kafka:29092"}, config)

	if err != nil {
		log.Println(err)

		return nil, err
	}

	return p, nil
}

func sendMessage(topic, message string, partition int32, producer sarama.SyncProducer) {
	msg := &sarama.ProducerMessage{
		Topic:     topic,
		Partition: partition,
		Value:     sarama.StringEncoder(message),
	}

	_, _, err := producer.SendMessage(msg)

	if err != nil {
		log.Println(err)
	}
}
