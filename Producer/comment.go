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

func saveComment(r *http.Request, producer sarama.SyncProducer) (statusCode int, responseBody string) {
	body, err := ioutil.ReadAll(r.Body)
	if err != nil {
		fmt.Println(err)

		return http.StatusBadRequest, "Cannot read request body"
	}

	var commentDto map[string]interface{}

	if err = json.Unmarshal(body, &commentDto); err != nil {
		fmt.Println(err)

		return http.StatusBadRequest, "Cannot unmarshal request body"
	}

	schemaName := sch.COMMENT_DTO_SCHEMA
	sch, err := jsonschema.Compile(schemaName)
	if err != nil {
		fmt.Println(err)

		return http.StatusInternalServerError, "Cannot load schema"
	}

	if err = sch.Validate(commentDto); err != nil {
		fmt.Println(err)

		return http.StatusBadRequest, "Schema Validation failed"
	}
	return http.StatusOK, ""
}
