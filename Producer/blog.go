package main

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"net/http"

	sch "producer/schema"

	"github.com/santhosh-tekuri/jsonschema/v5"
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
	body, err := ioutil.ReadAll(r.Body)
	if err != nil {
		fmt.Println(err)
	}

	var blogDto map[string]interface{}

	if err = json.Unmarshal(body, &blogDto); err != nil {
		fmt.Println(err)
	}

	schemaName := sch.BLOG_DTO_SCHEMA
	sch, err := jsonschema.Compile(schemaName)
	if err != nil {
		fmt.Println(err)
	}

	if err = sch.Validate(blogDto); err != nil {
		fmt.Println(err)
	}
}
