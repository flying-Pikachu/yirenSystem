package test.com.deepcloud.dao; 

import com.deepcloud.dao.UserDao;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* UserDao Tester. 
* 
* @author <Authors name> 
* @since <pre>六月 25, 2018</pre> 
* @version 1.0 
*/ 
public class UserDaoTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: isManager(String userName) 
* 
*/ 
@Test
public void testIsManager() throws Exception { 
//TODO: Test goes here...
    UserDao.isManager("1");
} 


} 
