package com.sds.cicd.service.stage;

public interface GitService {
    String clone(String url, String username, String password);
}
