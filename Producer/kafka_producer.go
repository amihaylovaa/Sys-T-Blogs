package main

import (
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

func sendMessage(topic, message string, reqPartition int32, producer sarama.SyncProducer) (partition int32, offset int64, err error) {
	msg := &sarama.ProducerMessage{
		Topic:     topic,
		Partition: reqPartition,
		Value:     sarama.StringEncoder(message),
	}

	return producer.SendMessage(msg)
}
