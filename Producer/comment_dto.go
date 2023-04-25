package main

type CommentDto struct {
	BlogId         uint     `json: "blogId"`
	Content        string   `json: "Content"`
	AttachmentsUrl []string `json: "attachmentsUrl"`
}
