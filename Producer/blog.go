package main

type comment struct {
	content        string
	attachmentsUrl []string
}

type Blog struct {
	title     string
	subtitle  string
	content   string
	imagesUrl []string
	comments  []comment
}

func savePost(blog Blog) {

}
