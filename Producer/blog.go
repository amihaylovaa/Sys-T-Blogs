package main

import (
	"net/http"
)

type Blog struct {
	title     string
	subtitle  string
	content   string
	imagesUrl []string
	comments  []Comment
}

func saveBlog(w http.ResponseWriter, r *http.Request) {

}
