package edu.byu.ee.phdl.formatting.tests;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.google.inject.Inject;
import edu.byu.ee.phdl.PhdlInjectorProvider;
import org.eclipse.xtext.junit4.util.ParseHelper
import edu.byu.ee.phdl.phdl.PhdlModel
import org.eclipse.xtext.serializer.ISerializer
import static org.junit.Assert.*
import org.eclipse.xtext.resource.SaveOptions

@InjectWith(typeof(PhdlInjectorProvider))
@RunWith(typeof(XtextRunner2))
public class FormattingTest {
	
	@Inject extension ParseHelper<PhdlModel>;
	@Inject extension ISerializer;
	
	@Test
	def void testDeviceFormat() {
		assertEquals(
'''

device res {
	attr REFPREFIX = "R";
	attr FOOTPRINT = "footprint";
	attr LIBRARY = "library";
	pin a = {1};
	pin b = {2};
}'''.toString,
	'''device res { attr 	REFPREFIX = "R"; 
attr  FOOTPRINT = "footprint" ; 	
	attr LIBRARY  = "library";
pin a = {1};
pin b = {2};
	}'''.parse.serialize(SaveOptions::newBuilder.format.getOptions))
	
	}
	
	
}
