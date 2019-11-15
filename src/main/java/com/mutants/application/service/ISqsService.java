package com.mutants.application.service;

public interface ISqsService {
	void sendNotificationSQS(String message);
}
