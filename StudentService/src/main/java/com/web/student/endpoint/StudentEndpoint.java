package com.web.student.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.web.student.repo.StudentRepository;
import com.web.student.stub.StudentDetailsRequest;
import com.web.student.stub.StudentDetailsResponse;

@Endpoint
public class StudentEndpoint {
	
	private static final String NAMESPACE_URI = "http://com/web/student/studentinformation";
	 
	  private StudentRepository studentRepository;
	 
	  @Autowired
	  public StudentEndpoint(StudentRepository studentRepository) {
	    this.studentRepository = studentRepository;
	  }
	 
	  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "StudentDetailsRequest")
	  @ResponsePayload
	  public StudentDetailsResponse getStudent(@RequestPayload StudentDetailsRequest request) {
	    StudentDetailsResponse response = new StudentDetailsResponse();
	    response.setStudent(studentRepository.findStudent(request.getName()));
	 
	    return response;
	  }

}
