package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.EmailNotFoundException;
import com.masai.exceptions.UserNotFoundException;
import com.masai.models.Check;
import com.masai.models.Email;
import com.masai.models.User;
import com.masai.repository.EmailDao;
import com.masai.repository.UserDao;

@Service
public class EmailServiceImpl implements EmailService{

	@Autowired
	private EmailDao emailDao;
	
	@Autowired
	private UserDao userDao;
	
	
	@Override
	public String sendMail(Email mail) throws UserNotFoundException {
		
		String str="Mail not sent successfully";
		
		try {
			
			emailDao.save(mail);
			str="Mail has been sent successfully from "+mail.getSender();
			User sender=mail.getSender();
			sender.getSentmails().add(mail);
			userDao.save(sender);
			List<User> receiver=mail.getReceiver();
			for(int i=0;i<receiver.size();i++) {
				User rec=receiver.get(i);
				rec.getReceivedmails().add(mail);
				userDao.save(rec);
			};
		
			
		}catch(Exception e) {
			
			
			throw new UserNotFoundException(e.getMessage());
			
		}
		
		
		// TODO Auto-generated method stub
		return str;
	}

	@Override
	public String starMail(Integer mailId) throws EmailNotFoundException {
		// TODO Auto-generated method stub
		
		String str="Email not starred";
		
		Optional<Email> starmail=emailDao.findById(mailId);
		
		if(starmail.isEmpty()) {
			
			throw new EmailNotFoundException("Email not found with the provided id");
			
		}else {
			
			starmail.get().setStarred(Check.YES);
			
			emailDao.save(starmail.get());
			
			str="Email starred successfully with id "+starmail.get().getEmail_id();
			
		}
		
		
		return str;
	}

	@Override
	public String deleteMail(Integer mailId) throws EmailNotFoundException {
		// TODO Auto-generated method stub
		
        String str="Email not deleted";
		
		Optional<Email> starmail=emailDao.findById(mailId);
		
		if(starmail.isEmpty()) {
			
			throw new EmailNotFoundException("Email not found with the provided id");
			
		}else {
			
			starmail.get().setStarred(Check.YES);
			
			emailDao.save(starmail.get());
			
			str="Email deleted successfully with id "+starmail.get().getEmail_id();
			
		}
		
		return str;
	}

}
