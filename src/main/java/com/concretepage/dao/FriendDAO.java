package com.concretepage.dao;

import javax.annotation.Resource;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.stereotype.Repository;

import com.concretepage.Person;

@Repository
public class FriendDAO {
	 private static final String KEY = "friendsKey";

	 // inject the redisTemplate as ListOperations
	 @Resource(name="redisTemplate")
	 private ListOperations<String, Person> opsForList;	 	 
	  
	 public void addFriend(Person person) {
		 opsForList.leftPush(KEY, person);
	 }
	 public long getNumberOfFriends() {
		 return opsForList.size(KEY);
	 }
	 public Person getFriendAtIndex(Integer index) {
		 return opsForList.index(KEY, index);
	 }
	 public void removeFriend(Person p) {
		 opsForList.remove(KEY, 1, p);
	 }
}
