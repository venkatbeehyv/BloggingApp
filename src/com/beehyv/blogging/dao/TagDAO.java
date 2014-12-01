package com.beehyv.blogging.dao;

import java.util.List;

import com.beehyv.blogging.modal.Tag;


public interface TagDAO {
	public List<Tag> getHomeTags();
}
