package main

import (
	"encoding/json"
	"io/ioutil"
	"log"
	"net/http"

	sch "producer/schema"

	"github.com/Shopify/sarama"
	"github.com/santhosh-tekuri/jsonschema/v5"
)

func saveBlog(r *http.Request, producer sarama.SyncProducer) (statusCode int, responseBody string) {
	body, err := ioutil.ReadAll(r.Body)
	if err != nil {
		log.Println(err)

		return http.StatusBadRequest, "Cannot read request body"
	}

	var blogDto map[string]interface{}

	if err = json.Unmarshal(body, &blogDto); err != nil {
		log.Println(err)

		return http.StatusBadRequest, "Cannot unmarshal request body"
	}

	schemaName := sch.BLOG_DTO_SCHEMA
	sch, err := jsonschema.Compile(schemaName)
	if err != nil {
		log.Println(err)

		return http.StatusInternalServerError, "Cannot load schema"
	}

	if err = sch.Validate(blogDto); err != nil {
		log.Println(err)

		return http.StatusBadRequest, "Schema Validation failed"
	}

	sendMessage("blogs", string(body[:]), 0, producer)

	return http.StatusOK, ""
}
