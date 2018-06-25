package test.com.deepcloud.util; 

import com.deepcloud.util.DBHelper;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* DBHelper Tester. 
* 
* @author <Authors name> 
* @since <pre>六月 25, 2018</pre> 
* @version 1.0 
*/ 
public class DBHelperTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: conn() 
* 
*/ 
@Test
public void testConn() throws Exception { 
//TODO: Test goes here...
    if (DBHelper.conn() != null)
        System.out.println("fsdfsd");
    System.out.println(DBHelper.conn());
} 


} 
