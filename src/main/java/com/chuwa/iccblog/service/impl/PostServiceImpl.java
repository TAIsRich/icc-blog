package com.chuwa.iccblog.service.impl;

import com.chuwa.iccblog.dao.PostRepository;
import com.chuwa.iccblog.entity.Post;
import com.chuwa.iccblog.payload.PostDto;
import com.chuwa.iccblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author b1go
 * @date 6/20/22 6:42 PM
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDto createPost(PostDto postDto) {
        // 把payload转换成entity,这样才能让DAO 去把该数据存到数据库中。
        // postDto pojo  -->  post entity
        Post post = new Post();
        if (postDto.getTitle() != null) {
            post.setTitle(postDto.getTitle());
        } else {
            post.setTitle("");
        }
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        // 已成功转换成post entity
        Post savedPost = postRepository.save(post);

        // 把post entity 对象转化成dto
        PostDto postResponse = new PostDto();
        // post entity(从数据库读出来的)  --> postDto pojo
        postResponse.setId(savedPost.getId());
        postResponse.setTitle(savedPost.getTitle());
        postResponse.setDescription(savedPost.getDescription());
        postResponse.setContent(savedPost.getContent());

        return postResponse;
    }
}
