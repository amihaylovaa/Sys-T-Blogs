package main

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"net/http"

	sch "producer/schema"

	"github.com/Shopify/sarama"
	"github.com/santhosh-tekuri/jsonschema/v5"
)

func saveBlog(r *http.Request, producer sarama.AsyncProducer) (statusCode int, responseBody string) {
	body, err := ioutil.ReadAll(r.Body)
	if err != nil {
		fmt.Println(err)

		return http.StatusInternalServerError, "Cannot read request body"
	}

	var blogDto map[string]interface{}

	if err = json.Unmarshal(body, &blogDto); err != nil {
		fmt.Println(err)

		return http.StatusInternalServerError, "Cannot unmarshal request body"
	}

	schemaName := sch.BLOG_DTO_SCHEMA
	sch, err := jsonschema.Compile(schemaName)
	if err != nil {
		fmt.Println(err)

		return http.StatusInternalServerError, "Cannot load schema"
	}

	if err = sch.Validate(blogDto); err != nil {
		fmt.Println(err)

		return http.StatusBadRequest, "Schema Validation failed"
	}

	return http.StatusOK, ""
}
