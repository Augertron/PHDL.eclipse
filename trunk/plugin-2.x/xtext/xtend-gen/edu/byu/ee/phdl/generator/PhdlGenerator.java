package edu.byu.ee.phdl.generator;

import java.io.File;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;

@SuppressWarnings("all")
public class PhdlGenerator implements IGenerator {
  private static String separator = File.separator;
  
  public void doGenerate(final Resource resource, final IFileSystemAccess fsa) {
  }
}
