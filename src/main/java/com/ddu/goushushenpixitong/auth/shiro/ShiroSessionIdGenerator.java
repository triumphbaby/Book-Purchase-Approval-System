package com.ddu.goushushenpixitong.auth.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;

import java.io.Serializable;

/**
 * 自定义SessionId生成器
 * @auther ChunKitAu
 * @create 2020-01-16 16
 */
public class ShiroSessionIdGenerator  implements SessionIdGenerator{
    /**
     * 实现SessionId生成
     * @param session
     * @return
     */
    @Override
    public Serializable generateId(Session session) {
        Serializable sessionId = new JavaUuidSessionIdGenerator().generateId(session);
        return String.format("login_token_%s", sessionId);
    }
}
