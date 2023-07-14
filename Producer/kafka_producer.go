package main

import (
	"fmt"
	"log"
	"time"

	"github.com/Shopify/sarama"
)

func createNewProducer() (sarama.SyncProducer, error) {
	config := sarama.NewConfig()
	config.Producer.Partitioner = sarama.NewRandomPartitioner
	config.Producer.Return.Successes = true

	p, err := sarama.NewSyncProducer([]string{"kafka:9092"}, config)

	if err != nil {
		return nil, err
	}

	return p, nil
}

func sendMessage(topic, message string, reqPartition int32, producer sarama.SyncProducer) error {
	msg := &sarama.ProducerMessage{
		Topic:     topic,
		Partition: reqPartition,
		Value:     sarama.StringEncoder(message),
	}

	_, _, err = producer.SendMessage(msg)

	return err
}

func createKafkaProducer(attempts int, delay time.Duration, createNewProducer func() (sarama.SyncProducer, error)) (sarama.SyncProducer, error) {
	for i := 0; i < attempts; i++ {

		producer, err = createNewProducer()
		if err != nil {
			log.Println("Failed to establish a producer connection, retrying..")

			time.Sleep(delay)

			continue
		}
		return producer, nil
	}
	return nil, fmt.Errorf("Failed to establish a producer connection")
}
