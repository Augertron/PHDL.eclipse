package edu.byu.ee.phdl

import org.eclipse.xtext.junit4.InjectWith
import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.XtextRunner
import com.google.inject.Inject
import org.eclipse.xtext.junit4.util.ParseHelper
import edu.byu.ee.phdl.phdl.PhdlModel
import org.junit.Test

import static org.junit.Assert.*

@InjectWith(typeof(PhdlInjectorProvider))
@RunWith(typeof(XtextRunner))
class ParserTest {
	@Inject
	ParseHelper<PhdlModel> parser
	
	@Test
	def void id() {
		//testTerminal("bar", "ID")
	}
	
	
	@Test
	def void parsePhdlModel() {
		val model = parser.parse('''
			device resistor {
				attr name1 = "value";
				attr name1 = "value";
			}
			'''			
		)
		val resource = model.eResource
		println(resource.errors.get(0).message)
		assertTrue(resource.errors.get(0).message.equals("Duplicate attribute declaration 'name1'"));
	}
}