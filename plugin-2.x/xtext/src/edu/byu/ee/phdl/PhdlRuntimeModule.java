/*
 * generated by Xtext
 */
package edu.byu.ee.phdl;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension
 * registry.
 */
public class PhdlRuntimeModule extends edu.byu.ee.phdl.AbstractPhdlRuntimeModule {

	@Override
	public Class<? extends org.eclipse.xtext.generator.IGenerator> bindIGenerator() {
		return edu.byu.ee.phdl.generator.PhdlGenerator.class;
	}
}