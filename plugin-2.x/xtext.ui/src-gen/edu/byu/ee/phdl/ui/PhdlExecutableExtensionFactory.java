/*
 * generated by Xtext
 */
package edu.byu.ee.phdl.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class PhdlExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return edu.byu.ee.phdl.ui.internal.PhdlActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return edu.byu.ee.phdl.ui.internal.PhdlActivator.getInstance().getInjector("edu.byu.ee.phdl.Phdl");
	}
	
}