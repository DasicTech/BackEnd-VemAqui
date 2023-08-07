package com.dasictech.vemaqui.service;

import org.springframework.stereotype.Service;

import com.dasictech.vemaqui.model.FeedbackModel;
import com.dasictech.vemaqui.repository.FeedbackRepository;

@Service
public class FeedbackService {

	private FeedbackRepository feedbackRepository;

	public FeedbackService(FeedbackRepository feedbackRepository) {
		this.feedbackRepository = feedbackRepository;
	}
	
	
	public FeedbackModel addFeedback(FeedbackModel feedback) {
		FeedbackModel feedbackSalvo = feedbackRepository.save(feedback);
		return feedbackSalvo;
	}
}
