/*
 * generated by Xtext
 */
package edu.byu.ee.phdl.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import edu.byu.ee.phdl.ui.internal.PhdlActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class PhdlExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return PhdlActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return PhdlActivator.getInstance().getInjector(PhdlActivator.EDU_BYU_EE_PHDL_PHDL);
	}
	
}