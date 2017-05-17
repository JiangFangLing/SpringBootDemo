package springbootdemo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Mine on 17/5/13.
 */
public interface UserRepository extends JpaRepository<User,Integer> {

    public List<User> findByAge(Integer age);

 }
