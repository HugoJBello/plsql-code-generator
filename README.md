# plsql-code-generator
Java library that generates several PLSQL code blocks from various inputs. Useful to automatice repetitive tasks when programming with PLSQL.

For the moment, I am focusing on generating dbms_outputs from objects or types in PLSQL.

## Usage and instalation

Just download the file plsql-code-generator.jar and execute it using java (normally it suffices with double clicking it).

## Example

Execute the file plsql-code-generator.jar and copy the code:

  TYPE type                IS RECORD (type_name1 T_type1, type_name1 t_type2, type_name1 t_type3, type_name1 t_type4);

(this declarates a very simple type)

now click **Generate** and go to the tab *Generated dbms_output*

  CREATE OR REPLACE TYPE object_name FORCE AS OBJECT
  (
      record1  VARCHAR2(15 BYTE),
      record2  NUMBER(5),
      record3  NUMBER(2),
      record4  NUMBER,
      record5  NUMBER,
      record6  NUMBER(6)
  ,CONSTRUCTOR FUNCTION object_name(
      record1  VARCHAR2,
      record2  NUMBER,
      record3  NUMBER,
      record4  NUMBER,
      record5  NUMBER,
      record6  NUMBER)  
  RETURN SELF AS RESULT
  );

click 
