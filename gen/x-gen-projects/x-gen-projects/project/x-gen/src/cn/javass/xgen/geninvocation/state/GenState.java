package cn.javass.xgen.geninvocation.state;

import cn.javass.xgen.geninvocation.BaseGenAction;
import cn.javass.xgen.geninvocation.DefaultGenInvocation;
import cn.javass.xgen.mediator.CoreMediator;

public class GenState implements State{

	@Override
	public void doWork(DefaultGenInvocation ctx) {
		//����ʵ��ҵ����
		//1����ȡÿ��theme��Ӧ��Action
		String className = CoreMediator.getInstance().getNeedGenTypeClass(ctx.getNeedGenType(),ctx.getModuleConf());
		
		//2������Action��������ɵ�����
		Object obj = null;
		
		try {
			obj = ((BaseGenAction)Class.forName(className).newInstance()).generate(ctx.getModuleConf());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//������ʱ������
		ctx.setTempContent(obj);
		
		//������һ��state
		ctx.setState(new OutState());
		ctx.doWork();
	}
}