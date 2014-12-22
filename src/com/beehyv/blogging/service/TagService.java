package com.beehyv.blogging.service;

import java.util.List;

import com.beehyv.blogging.dao.TagDAO;
import com.beehyv.blogging.dao.impl.TagDAOImpl;
import com.beehyv.blogging.modal.Tag;

public class TagService {
	private TagDAO tagDAO = new TagDAOImpl();
	
	public List<Tag> getHomeTags(){
		return tagDAO.getHomeTags();
	}
	
	public void addTags(List<Tag> tags){
		tagDAO.addTags(tags);
	}
	
	public void deleteTag(Long tag_id){
		tagDAO.deleteTag(tag_id);
	}
}
