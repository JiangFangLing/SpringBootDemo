package springbootdemo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void insertTwo(){
		User userA=new User();
		userA.setUserName("AAAA");
		userA.setAge(20);
		userA.setGender("男");
		userRepository.save(userA);
		
		User userB=new User();
		userB.setUserName("BBBBBBBBBBBBBBBBBBBBB");
		userB.setAge(100);
		userB.setGender("男");
		userRepository.save(userB);
		
	}

}
