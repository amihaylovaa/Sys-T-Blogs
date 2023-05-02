package main

type CommentDto struct {
	BlogId         uint     `json: "blogId"`
	Content        string   `json: "content"`
	AttachmentsUrl []string `json: "attachmentsUrl"`
}
