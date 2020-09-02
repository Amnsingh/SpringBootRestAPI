package io.java.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	private List<Topic> topics=new ArrayList<> (Arrays.asList(
			new Topic("spring","Spring","Spring Description"),
			new Topic("java","Java","Java Description"),
			new Topic("javascript","JavaScript","JavaScript Descripti")
			));
	
	public List<Topic> getAlltopics(){
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
	}
	public void addTopics(Topic topic) {
		topics.add(topic);
	}

	public void updateTopics(Topic topic, String id) {
		for(int i=0;i<topics.size();i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(t->t.getId().equals(id));
	}

}
