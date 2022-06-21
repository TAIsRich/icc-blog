package com.chuwa.iccblog.service;

import com.chuwa.iccblog.payload.PostDto;

/**
 * @author b1go
 * @date 6/20/22 6:41 PM
 */
public interface PostService {
    PostDto createPost(PostDto postDto);
}
