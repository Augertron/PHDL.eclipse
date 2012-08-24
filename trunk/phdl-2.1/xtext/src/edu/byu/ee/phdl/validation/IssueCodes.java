package edu.byu.ee.phdl.validation;

public interface IssueCodes {
	String PREFIX = "edu.byu.ee.phdl.phdl.";

	String ALREADY_ASSIGNED = PREFIX + "PinAlreadyAssigned";

	String ARRAY_NOT_DECLARED = PREFIX + "ArrayNotDeclared";

	String ASSIGNMENT_WIDTH_MISMATCH = PREFIX + "AssignmentWidthMismatch";

	String ATTRIBUTE_ALREADY_DECLARED = PREFIX + "AttributeAlreadyDeclared";

	String ATTRIBUTE_ALREADY_OVERWRITTEN = PREFIX + "AttributeAlreadyOverwritten";

	String CANNOT_REPLICATE_ARRAY = PREFIX + "CannotReplicateArray";

	String CANNOT_REPLICATE_SLICES = PREFIX + "CannotReplicateSlices";

	String DANGLING_CONNECTION = PREFIX + "DanglingConnection";

	String INDICES_NOT_ALLOWED = PREFIX + "IndicesNotAllowed";

	String INITIAL_OVERWRITTEN_ATTRIBUTE = PREFIX + "InitialOverwrittenAttribute";

	String INVALID_IMPORT = PREFIX + "InvalidImport";

	String INVALID_INDEX = PREFIX + "InvalidIndex";

	String INVALID_LSB = PREFIX + "InvalidLSB";

	String INVALID_MSB = PREFIX + "InvalidMSB";

	String INVALID_PIN_DECLARATION = PREFIX + "InvalidPinDeclaration";

	String INVALID_REPLICATION = PREFIX + "InvalidReplication";

	String INVALID_SLICE = PREFIX + "InvalidSlice";

	String MISSING_CONNECTION_DECL = PREFIX + "MissingConnectionDecl";

	String ORIGINAL_ASSIGNMENT = PREFIX + "OriginalAssignment";

	String PORT_NOT_ALLOWED = PREFIX + "PortNotAllowed";

	String QUALIFIER_NOT_ALLOWED = PREFIX + "QualifierNotAllowed";

	String REQUIRED_ATTRIBUTE_MISSING = PREFIX + "RequiredAttributeMissing";

	String UNASSIGNED_PIN = PREFIX + "UnassignedPin";

	String UNASSIGNED_PORT = PREFIX + "UnassignedPort";

	String UNUSED_CONNECTION_DECL = PREFIX + "UnusedConnectionDecl";

	String NOT_UPPERCASE = PREFIX + "NotUppercase";
}
