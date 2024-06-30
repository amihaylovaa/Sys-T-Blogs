package main

type CommentDto struct {
	BlogId         string   `json: "blogId"`
	Content        string   `json: "content"`
	User           string   `json: "user"`
	AttachmentsUrl []string `json: "attachmentsUrl"`
}
