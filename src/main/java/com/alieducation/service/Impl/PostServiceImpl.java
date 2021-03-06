package com.alieducation.service.Impl;

import com.alieducation.dao.PostDao;
import com.alieducation.entity.Post;
import com.alieducation.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;


/**
 * @author JiaZhiYuan
 * @version 1.0
 * @date 2020/7/9 9:07
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Override
    public int selectCountOfPost() {
        Post post = new Post();
        return postDao.selectCount(post);
    }

    @Override
    public Post findPostById(int postId) {
        Post post = new Post();
        post.setId(postId);
        return postDao.selectOne(post);
    }

}
