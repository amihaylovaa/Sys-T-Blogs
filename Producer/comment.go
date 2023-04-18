package main

import (
	"log"
	"net/http"

	"github.com/santhosh-tekuri/jsonschema"
)

type Comment struct {
	id             uint
	content        string
	attachmentsUrl []string
}

func saveComment(w http.ResponseWriter, r *http.Request) {
	sch, err := jsonschema.Compile("schema/comment_dto_schema.json")

	if err != nil {
		log.Fatalf("%#v", err)
	}
}
