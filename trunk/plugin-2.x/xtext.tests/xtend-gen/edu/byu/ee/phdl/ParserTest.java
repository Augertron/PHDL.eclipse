package edu.byu.ee.phdl;

import com.google.inject.Inject;
import edu.byu.ee.phdl.PhdlInjectorProvider;
import edu.byu.ee.phdl.phdl.PhdlModel;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@SuppressWarnings("all")
@InjectWith(PhdlInjectorProvider.class)
@RunWith(XtextRunner.class)
public class ParserTest {
  @Inject
  private ParseHelper<PhdlModel> parser;
  
  @Test
  public void id() {
  }
  
  @Test
  public void parsePhdlModel() {
    try {
      {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("device resistor {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("attr name1 = \"value\";");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("attr name1 = \"value\";");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        PhdlModel _parse = this.parser.parse(_builder);
        final PhdlModel model = _parse;
        Resource _eResource = model.eResource();
        final Resource resource = _eResource;
        EList<Diagnostic> _errors = resource.getErrors();
        Diagnostic _get = _errors.get(0);
        String _message = _get.getMessage();
        InputOutput.<String>println(_message);
        EList<Diagnostic> _errors_1 = resource.getErrors();
        Diagnostic _get_1 = _errors_1.get(0);
        String _message_1 = _get_1.getMessage();
        boolean _equals = _message_1.equals("Duplicate attribute declaration \'name1\'");
        Assert.assertTrue(_equals);
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
