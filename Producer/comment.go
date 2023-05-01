package main

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"net/http"

	sch "producer/schema"

	"github.com/santhosh-tekuri/jsonschema/v5"
)

type Comment struct {
	id             uint
	content        string
	attachmentsUrl []string
}

func saveComment(w http.ResponseWriter, r *http.Request) {
	body, err := ioutil.ReadAll(r.Body)
	if err != nil {
		fmt.Println(err)
	}

	var commentDto map[string]interface{}

	if err = json.Unmarshal(body, &commentDto); err != nil {
		fmt.Println(err)
	}

	schemaName := sch.COMMENT_DTO_SCHEMA
	sch, err := jsonschema.Compile(schemaName)
	if err != nil {
		fmt.Println(err)
	}

	if err = sch.Validate(commentDto); err != nil {
		fmt.Println(err)
	}
}
