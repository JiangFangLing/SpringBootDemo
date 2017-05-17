package springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Created by Mine on 17/5/13.
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 查询所有用户列表
     * http://127.0.0.1:8080/AllUser
     * @return
     */
    @GetMapping(value="AllUser")
    public List<User> userList(){
        return userRepository.findAll();
    }

    /**
     * 添加女生
     * http://127.0.0.1:8080/addUser?userName=jiangfangling&age=21&gender=女
     * @param username
     * @param age
     * @param gender
     * @return
     */
    @PostMapping(value="addUser")
    public User addUser(@RequestParam("userName") String username,@RequestParam("age") Integer age,@RequestParam("gender") String gender){
        User user=new User();
        user.setUserName(username);
        user.setAge(age);
        user.setGender(gender);
        return userRepository.save(user);
    }

    /**
     * 根据id查询女生
     * http://127.0.0.1:8080/findUserById/1
     * @param id
     * @return
     */
    @GetMapping(value="/findUserById/{id}")
    public User findUserById(@PathVariable("id") Integer id){
        return userRepository.findOne(id);
    }

    /**
     * 更新用户
     * 因为是put请求
     * 请求参数要选择body -然后选择x-www-formurlencoded
     * @param id
     * @param userName
     * @param age
     * @param gender
     * @return
     */
    @PutMapping(value="/updateUser/{id}")
    public User updateUser(@PathVariable("id") Integer id,
                            @RequestParam("userName") String userName,
                            @RequestParam("age") Integer  age,
                            @RequestParam("gender") String gender){
            User user=new User();
            user.setId(id);
            user.setUserName(userName);
            user.setAge(age);
            user.setGender(gender);
            return userRepository.save(user);
    }

    @DeleteMapping(value="/deleteUser/{id}")
    public  void deleteUser(@PathVariable("id") Integer id){
          userRepository.delete(id);
    }

    @GetMapping(value="/findUserByAge/{age}")
    public void findUserByAge(@PathVariable("age") Integer age){
            userRepository.findByAge(age);

    }
}
