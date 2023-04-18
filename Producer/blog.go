package main

import (
	"log"
	"net/http"

	"github.com/santhosh-tekuri/jsonschema"
)

type Blog struct {
	id             uint
	title          string
	subtitle       string
	content        string
	attachmentsUrl []string
	comments       []Comment
}

func saveBlog(w http.ResponseWriter, r *http.Request) {
	sch, err := jsonschema.Compile("schema/blog_dto_schema.json")

	if err != nil {
		log.Fatalf("%#v", err)
	}
}
