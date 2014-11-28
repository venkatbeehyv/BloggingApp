package com.beehyv.bloggingapp.dao;

import java.util.List;

import com.beehyv.blogging.modal.Tag;


public interface TagDAO {
	public List<Tag> getHomeTags();
}
