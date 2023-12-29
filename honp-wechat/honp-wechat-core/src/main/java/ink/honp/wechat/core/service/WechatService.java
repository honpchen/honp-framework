package ink.honp.wechat.core.service;

import ink.honp.wechat.core.exception.WechatException;

import java.util.List;

/**
 * @author jeffchen
 * date    2023/12/29 17:07
 */
public interface WechatService {

    <T> T get(String url, Class<T> responseClz) throws WechatException;

    <T> List<T> getList(String url, Class<T> responseClz) throws WechatException;

    <T> T post(String url, Class<T> responseClz) throws WechatException;

    <T> T postList(String url, Class<T> responseClz) throws WechatException;
}
