package com.sun.wenlou;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jasig.services.persondir.IPersonAttributes;
import org.jasig.services.persondir.support.AttributeNamedPersonImpl;
import org.jasig.services.persondir.support.StubPersonAttributeDao;

public class BlogStubPersonAttributeDao extends StubPersonAttributeDao {
	 @Override
	  public IPersonAttributes getPerson(String uid) {
	        
	        Map<String, List<Object>> attributes = new HashMap<String, List<Object>>();
	        attributes.put("userid", Collections.singletonList((Object)uid));
	        attributes.put("cnblogUsername", Collections.singletonList((Object)"http://www.cnblogs.com/vhua"));
	        attributes.put("cnblogPassword", Collections.singletonList((Object)"123456"));
	        attributes.put("test", Collections.singletonList((Object)"test"));
	        attributes.put("sun", Collections.singletonList((Object)"sun"));
	        return new AttributeNamedPersonImpl(attributes);
	    }
}
