package com.lfy.demo.service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.web.multipart.MultipartFile;

import com.lfy.demo.domain.User;

public interface UserService {
    /** 查找所有用户 */
    List<User> listAll();
    
    /** 添加用户 */
    Integer insert(User user);
    
    /** 根据id删除用户 */
    Integer deleteById(Integer id);
    
    /** 更新用户 */
    Integer update(User user);
    
    /** 根据id查找用户 */
    User getById(Integer id);
    
    public List<JSONObject> readExcels(InputStream is,String fileName);
}
