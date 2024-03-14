package com.von.api.articles;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ArticleController {
    private ArticleServiceImpl service;

    public ArticleController() {
        this.service = ArticleServiceImpl.getInstance();
    }

    public List<?> findAll() throws SQLException {
        return service.findAll();
    }
}