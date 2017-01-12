# plsql-code-generator
Java library that generates several PLSQL code blocks from various inputs. Useful to automatice repetitive tasks when programming with PLSQL.

For the moment, I am focusing on generating dbms_outputs from objects or types in PLSQL.

## Usage and instalation

Just download the file plsql-code-generator.jar and execute it using java (normally it suffices with double clicking it).

## Example

Execute the file plsql-code-generator.jar and copy the code:

  ``TYPE type                IS RECORD (type_name1 T_type1, type_name1 t_type2, type_name1 t_type3, type_name1 t_type4);``

(this declarates a very simple type) and paste it in the tab *Declaration*.

![image](https://github.com/HugoJBello/plsql-code-generator/blob/master/captures/example_type1.png)

Now click on the button *dbms_output from a type* and click **Generate**. If you go to the tab *Generated dbms_output* you will see that it has generated the code
```
 dbms_output.put_line('type_name1 ' || result.type_name1 );
 dbms_output.put_line('type_name1 ' || result.type_name1 );
 dbms_output.put_line('type_name1 ' || result.type_name1 );
 dbms_output.put_line('type_name1 ' || result.type_name1 );
```
![image](https://github.com/HugoJBello/plsql-code-generator/blob/master/captures/example_type2.png)


We can repeat this operation with objects instead of types. In that case we can use a code as the following one:

  ```
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
  ```
![image](https://github.com/HugoJBello/plsql-code-generator/blob/master/captures/example_object1.png)

clicking on *dbms_output from a type* and   **Generate** we will obtain the code:
```
 dbms_output.put_line('record1 ' || result.record1 );
 dbms_output.put_line('record2 ' || result.record2 );
 dbms_output.put_line('record3 ' || result.record3 );
 dbms_output.put_line('record4 ' || result.record4 );
 dbms_output.put_line('record5 ' || result.record5 );
 dbms_output.put_line('record6 ' || result.record6 );
```

### Table objects or records (with loops)

If the object or type that we want to display is a PLSQL table, we can tick the box **with loop** and we will obtain results like this:
```
i := result.first();
WHILE result.exists(i) LOOP
 dbms_output.put_line('record1 ' || result(i).record1 );
 dbms_output.put_line('record2 ' || result(i).record2 );
 dbms_output.put_line('record3 ' || result(i).record3 );
 dbms_output.put_line('record4 ' || result(i).record4 );
 dbms_output.put_line('record5 ' || result(i).record5 );
 dbms_output.put_line('record6 ' || result(i).record6 );
 dbms_output.put_line('------| '||i||' |------');
 dbms_output.put_line('');
i := result.next(i);
END LOOP;
```

