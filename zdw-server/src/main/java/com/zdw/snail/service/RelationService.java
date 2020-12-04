package com.zdw.snail.service;

import com.zdw.snail.model.RelationEntity;

import java.util.List;


public interface RelationService {

	/**
	 * 通过userId得到关系List
	 * @param userId
	 * @return
	 */
	public List<RelationEntity> getRelationByUserId(int userId);

	/**
	 * 批量插入关系数据
	 * @param relationList
	 */
	public void insertRelations(List<RelationEntity> relationList);

	
}
