package main

type BlogDto struct {
	Title          string   `json: "title"`
	Subtitle       string   `json: "subtitle"`
	Content        string   `json: "content"`
	AttachmentsUrl []string `json: "attachmentsUrl"`
}
