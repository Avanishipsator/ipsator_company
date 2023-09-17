package com.ipsator.Service;

import org.springframework.stereotype.Service;

import com.ipsator.Entity.User;
import com.ipsator.Entity.UserSession;

import java.util.HashMap;
import java.util.Map;

@Service
public class SessionManagementService {

    private final Map<String, UserSession> userSessions = new HashMap<>();

    public void createSession(String sessionId, User user) {
        UserSession userSession = new UserSession(sessionId, user);
        userSessions.put(sessionId, userSession);
    }

    public UserSession getSession(String sessionId) {
        return userSessions.get(sessionId);
    }

    public void removeSession(String sessionId) {
        userSessions.remove(sessionId);
    }
}

