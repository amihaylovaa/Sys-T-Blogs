package main

type CommentDto struct {
	BlogId         uint     `json: "blogId"`
	Content        string   `json: "content"`
	User           string   `json: "user"`
	AttachmentsUrl []string `json: "attachmentsUrl"`
}
