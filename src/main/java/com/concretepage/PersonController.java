package com.concretepage;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.concretepage.dao.FriendDAO;

@RestController
public class PersonController {
	
	@Autowired
	private FriendDAO friendDAO;
	
	@RequestMapping("/")
	public String welcome() throws Exception {
		getRedisData();
		return "Welcome to Spring Boot REST...";
	}
	
    public void getRedisData() throws Exception {
 	   System.out.println("--Example of ListOperations--");
       Person p1 = new Person(1, "Mahesh", 30);
       friendDAO.addFriend(p1);
       Person p2 = new Person(2, "Krishna", 35);
       friendDAO.addFriend(p2);
	   System.out.println("Number of friends: " + friendDAO.getNumberOfFriends());
       System.out.println(friendDAO.getFriendAtIndex(1));
       friendDAO.removeFriend(p2);
       System.out.println(friendDAO.getFriendAtIndex(1)); //It will return null, because value is deleted.  
    }
	
}
