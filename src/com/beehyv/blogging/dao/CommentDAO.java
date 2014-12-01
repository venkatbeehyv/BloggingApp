package com.beehyv.blogging.dao;

import java.util.List;

import com.beehyv.blogging.modal.Comment;

public interface CommentDAO {
	public List<Comment> getComments(long post_id);
}
