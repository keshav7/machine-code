package com.base.timeline.service.api;

import com.base.timeline.model.Post;

import java.util.List;

public interface PostService {

  Post addPost(String text, String userId);

  List<Post> getPostsByUser(String userId);

  List<Post> getPostsByIds(List<String> postIds);
}
