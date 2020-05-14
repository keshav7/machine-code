package com.base.timeline.service.impl;

import com.base.timeline.model.Post;
import com.base.timeline.service.api.PostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {


  List<Post> postList = new ArrayList<>();

  @Override
  public Post addPost(String text, String userId) {
    Post post = Post.builder().text(text).userId(userId).id(UUID.randomUUID().toString().substring(3,9)).build();
    postList.add(post);
    return post;
  }


  @Override
  public List<Post> getPostsByUser(String userId) {
    List<Post> result = new ArrayList<>();

    for (Post post : postList) {
      if (post.getUserId().equals(userId)) {
        result.add(post);
      }
    }

    return result;
  }

  @Override
  public List<Post> getPostsByIds(List<String> postIds) {
    List<Post> results =new ArrayList<>();

    for (Post post : postList) {
      for (String id : postIds) {
        if (post.getId().equals(id)) {
          results.add(post);
        }
      }
    }
    return results;
  }
}
