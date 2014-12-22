package com.beehyv.blogging.dao;

import java.util.List;

import com.beehyv.blogging.modal.Tag;


public interface TagDAO {
	public List<Tag> getHomeTags();

	public void addTags(List<Tag> tags);

	public void deleteTag(Long tag_id);
}
