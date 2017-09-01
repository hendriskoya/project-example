package com.teste;

import java.util.HashMap;
import java.util.Map;
import static com.teste.SQLUpdateImpl.*;

public class TestUpdateCommand {

	public static void main(String[] args) {
		SQLCommand
			.update("PRE_APPROVAL_REQUEST")
			.set(
				column("NUM_USAGE").to(5),
				column("DES_RECEIVER_EMAIL").to("teste@teste.com.br"),
				column("DES_REDIRECT_URL").to("http://www.teste.com.br")
			).where(
				column("IDT_PRE_APPROVAL_REQUEST", equal(1))
			);
	}

}

class SQLCommand {
	
	
	public static SQLUpdate update(String table) {
		SQLUpdate sqlUpdate = new SQLUpdateImpl(table);
		return sqlUpdate;
	}
}

interface SQLUpdate {
	
	SQLUpdate set(String field, Object value);
	
	SQLUpdate where(WhereField... field);
	
	SQLUpdate and(String field, Object value);
	
	SQLUpdate set(SetField... field);
}

class SQLUpdateImpl implements SQLUpdate {

	private String table;
	private Map<String, Object> setFields = new HashMap<>();
	private Map<String, Object> whereFields = new HashMap<>();
	
	public SQLUpdateImpl(String table) {
		this.table = table;
	}
	
	@Override
	public SQLUpdate set(String field, Object value) {
		setFields.put(field, value);
		return this;
	}

	@Override
	public SQLUpdate where(WhereField... field) {
		//whereFields.put(field, value);
		return this;
	}

	@Override
	public SQLUpdate and(String field, Object value) {
		whereFields.put(field, value);
		return this;
	}

	public static SetField column(String name) {
		return new SetField(name);
	}
	
	public static WhereField column(String name, WhereValue value) {
		return new WhereField(name, value);
	}	
	
	public static WhereValue equal(Object value) {
		return new WhereValue(value);
	}
	
	public static WhereValue notEqual(Object value) {
		return new WhereValue(value);
	}

	@Override
	public SQLUpdate set(SetField... field) {
		// TODO Auto-generated method stub
		return this;
	}
	
}

class SetField {

	private String fieldName;
	private Object toValue;
	
	public SetField(String fieldName) {
		this.fieldName = fieldName;
	}
	
	public SetField to(Object value) {
		this.toValue = value;
		return this; 
	}
}

class WhereValue {
	
	private Object value;
	
	public WhereValue(Object value) {
		this.value = value;
	}
}

class WhereField implements AndOrClause<WhereField>, Rule<WhereField> {

	private String fieldName;
	private WhereValue value;
	
	public WhereField(String fieldName, WhereValue value) {
		this.fieldName = fieldName;
		this.value = value;
	}
	
	@Override
	public WhereField and(WhereField field) {
		return field;
	}

	@Override
	public WhereField or(WhereField field) {
		return field;
	}

	@Override
	public WhereField equal(Object value) {
		return null;
	}
}

interface AndOrClause<T> {
	
	T and(T t);
	
	T or(T t);
}

interface Rule<T> {
	
	T equal(Object value);
}

