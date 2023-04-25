package main

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"net/http"
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

	var commentDto CommentDto

	if err = json.Unmarshal(body, &commentDto); err != nil {
		fmt.Println(err)
	}
	// sch, err := jsonschema.Compile("schema/comment_dto_schema.json")
	// if err != nil {
	// 	log.Fatalf("%#v", err)
	// }

	// data, err := ioutil.ReadFile("schema/comment_dto_schema.json")
	// if err != nil {
	// 	log.Fatal(err)
	// }

	// var v interface{}
	// if err := json.Unmarshal(data, &v); err != nil {
	// 	log.Fatal(err)
	// }

	// if err = sch.Validate(v); err != nil {
	// 	log.Fatalf("%#v", err)
	// }
}
