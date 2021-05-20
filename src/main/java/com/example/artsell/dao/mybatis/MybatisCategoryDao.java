package com.example.artsell.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.artsell.dao.CategoryDao;
import com.example.artsell.dao.mybatis.mapper.CategoryMapper;
import com.example.artsell.domain.Category;

@Repository
public class MybatisCategoryDao implements CategoryDao {
	@Autowired
	private CategoryMapper categoryMapper;
	
	public List<Category> getCategoryList(String categoryId) throws DataAccessException {
		return categoryMapper.getCategoryList(categoryId);
	}
	
	public Category getCategory(String categoryId) throws DataAccessException {
		return categoryMapper.getCategory(categoryId);
	}
}