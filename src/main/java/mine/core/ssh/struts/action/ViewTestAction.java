package mine.core.ssh.struts.action;


import java.util.ArrayList;
import java.util.List;

import mine.core.ssh.domain.Test;
import mine.core.ssh.struts.BaseAction;

public class ViewTestAction extends BaseAction{ 
	
	@Override
	public String execute() throws Exception {
		test=(Test) coreService.getEntityById(Test.class, 1);
		try{
			throw new IllegalArgumentException("哈哈");
		}catch(IllegalArgumentException e){
			logger.error(e);
		}
		String hql="from Test t where t.id=?";
		testList=this.coreService.loadEntityAll(Test.class);
		return "success";
	}
	private Test test;
	private List<Test> testList=new ArrayList<Test>();
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public List<Test> getTestList() {
		return testList;
	}
	public void setTestList(List<Test> testList) {
		this.testList = testList;
	}
	
}
