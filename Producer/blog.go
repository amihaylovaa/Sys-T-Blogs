package main

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"net/http"
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

	var blogDto BlogDto

	if err = json.Unmarshal(body, &blogDto); err != nil {
		fmt.Println(err)
	}

	// decoder := json.NewDecoder(r.Body)
	// err := decoder.Decode(&blogDto)
	// fmt.Printf("%+v\n", blogDto)
	// fmt.Printf("%+v\n", r.Body)

	// if err == nil {
	// 	fmt.Printf("ERROR")
	// }

	// sch, err := jsonschema.Compile("schema/blog_dto_schema.json")
	// if err != nil {
	// 	log.Fatalf("%#v", err)
	// }

	// data, err := ioutil.ReadFile("schema/blog_dto_schema.json")
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
