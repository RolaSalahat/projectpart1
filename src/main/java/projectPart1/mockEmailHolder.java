package projectPart1;

import static org.mockito.Mockito.mock;


public class mockEmailHolder {
	
private WebEmailService emailService = mock(WebEmailService.class);
//private WebEmailService emailService  = new WebEmailService();

public mockEmailHolder(finderApp finder) {
	
	finder.setEmailService(emailService);
	
}

public WebEmailService getEmailService() {
	return emailService;
	
}

public void setEmailService(WebEmailService emailService) {
	this.emailService =emailService;
}
}
