/**
 * 
 * @author YZhi
 * @date 2012-5-29
 * @copyright 2012 haitian.com All rights reserved
 * @since V1.0	
 *
 */
package org.walnuts.study.dp.example.structure.bridge.star;

/**
 * 
 * @author YZhi
 * @since 1.0
 */
public class Singer extends AbsStar {

	public Singer() {
		super(new Sing());
	}
	
	public Singer(AbsAction action) {
		super(action);
	}

	/* (non-Javadoc)
	 * @see dp.example.structure.bridge.star.AbsStar#doJob()
	 */
	@Override
	public void doJob() {
		super.doJob();
	}
	

}