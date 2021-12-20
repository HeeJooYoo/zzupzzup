package com.zzupzzup.service.chat;

import java.util.List;

import com.zzupzzup.common.Search;
import com.zzupzzup.service.domain.Chat;

public interface ChatDAO {
	// Insert
	public void addChat(Chat chat) throws Exception;
	
	// Select One
	public Chat getChat(int chatNo) throws Exception;
	
	// Select List
	public List<Chat> listChat(Search search) throws Exception;
	
	// Update
	public void updateChat(Chat chat) throws Exception;
	
	// Page Row(totalCount) return
	public int getTotalCount(Search search) throws Exception;
	
	// Select One
	public Chat getChatEntrance(int chatNo) throws Exception;
	
	// Update
	public void deleteChat(Chat chat) throws Exception;
	
	// Update
	public void updateChatState(Chat chat) throws Exception;
	
	// Select One
	public Chat getChatRecord(int chatNo) throws Exception;
	
	// Update
	public void updateReadyCheck(Chat chat) throws Exception;
	
	// Update
	public void deleteChatMember(Chat chat) throws Exception;
	
	// Select One
	public List<Chat> listChatMember(Search search) throws Exception;
	
	// Select One
	public List<Chat> listReadyCheckMember(Search search) throws Exception;
}
