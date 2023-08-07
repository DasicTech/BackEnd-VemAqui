package com.dasictech.vemaqui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dasictech.vemaqui.model.EstabelecimentoModel;
import com.dasictech.vemaqui.model.FeedbackModel;
import com.dasictech.vemaqui.repository.FeedbackRepository;
import com.dasictech.vemaqui.service.FeedbackService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "api/v1/feedback")
public class FeedbackController {
	
	@Autowired
	private FeedbackService feedbackService;
	@Autowired
	private FeedbackRepository feedbackRepository;
	@Autowired
    private  HttpServletRequest request;
	
	  @PostMapping(value = "/form")
	    public FeedbackModel addFeedback(@RequestBody FeedbackModel feedback) {
			return feedbackService.addFeedback(feedback);   
	  }
}
