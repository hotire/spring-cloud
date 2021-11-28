package com.github.hotire.webservice.feign;

import java.util.List;

//@Component
public class JSONPlaceHolderClientFallback implements JSONPlaceHolderClient {

    @Override
    public List<Post> getPostsWithPathAndQuery(Long id, String name) {
        return null;
    }

    @Override
    public List<Post> getPosts() {
        return null;
    }

}
