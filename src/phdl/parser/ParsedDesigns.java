package phdl.parser;

import java.util.HashSet;

public class ParsedDesigns {

	protected HashSet<DesignDeclaration> designDecls;
	
	public ParsedDesigns() {
		this.designDecls = new HashSet<DesignDeclaration>();
	}

	public HashSet<DesignDeclaration> getDesignDecls() {
		return designDecls;
	}

	public void addDesignDecl(DesignDeclaration designDecl) {
		designDecls.add(designDecl);
	}
}
