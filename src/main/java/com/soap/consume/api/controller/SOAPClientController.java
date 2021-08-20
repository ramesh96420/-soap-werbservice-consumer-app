package com.soap.consume.api.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soap.consume.api.client.SoapClientService;
import com.soap.consume.binding.api.loaneligibility.Acknowledgement;
import com.soap.consume.binding.api.loaneligibility.CustomerRequest;


@RestController
public class SOAPClientController {
	
	org.slf4j.Logger logger = LoggerFactory.getLogger(SOAPClientController.class);

	@Autowired
	private SoapClientService soapClient;
	
	@PostMapping("/getLoanStatus")
	public Acknowledgement invockeSoapClientToGetLoanStatus(@RequestBody CustomerRequest request) {
		logger.info("==================> Customer Object {}", request);
		return soapClient.getLoanStatus(request);
	}
}
