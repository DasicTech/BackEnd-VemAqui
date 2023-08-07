package com.dasictech.vemaqui.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dasictech.vemaqui.model.FeedbackModel;



public interface FeedbackRepository extends JpaRepository<FeedbackModel, Long>{
	
}
