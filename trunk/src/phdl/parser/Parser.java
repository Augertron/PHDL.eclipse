package phdl.parser;

import java.util.HashSet;

public class Parser {

	protected HashSet<DesignDeclaration> designDecls;
	
	public Parser() {
		this.designDecls = new HashSet<DesignDeclaration>();
	}

	public HashSet<DesignDeclaration> getDesignDecls() {
		return designDecls;
	}

	public void addDesignDecl(DesignDeclaration designDecl) {
		designDecls.add(designDecl);
	}
}
