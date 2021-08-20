package com.soap.consume.api.client;

import javax.swing.text.DefaultEditorKit.CutAction;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.soap.consume.api.controller.SOAPClientController;
import com.soap.consume.binding.api.loaneligibility.Acknowledgement;
import com.soap.consume.binding.api.loaneligibility.CustomerRequest;

/**
 * In this class we can use @Service or @Component Annotation.
 */
@Service
public class SoapClientService {
	
	org.slf4j.Logger logger = LoggerFactory.getLogger(SoapClientService.class);

	@Autowired
	private Jaxb2Marshaller marshaller;

	private WebServiceTemplate template;

	public Acknowledgement getLoanStatus(CustomerRequest request) {
		logger.info("==================> Customer Object in Service {}", request);
		//below line is take care our Object into XML
		template = new WebServiceTemplate(marshaller);
		// below method level we are passing SOAP Provider url and input request
		// template.marshalSendAndReceive(SOAP Provider url, input request);
		Acknowledgement acknowledgement = (Acknowledgement) template.marshalSendAndReceive("http://localhost:8080/ws",
				request);
		return acknowledgement;
	}
}
