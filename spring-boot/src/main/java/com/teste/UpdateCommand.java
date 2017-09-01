package com.teste;

import java.util.ArrayList;
import java.util.List;

public class UpdateCommand implements SqlCommand {

    private final String table;
    private final String idColumn;
    private final Object idValue;

    private final List<String> fields = new ArrayList<String>();
    private final List<Object> values = new ArrayList<Object>();

    public UpdateCommand(String table, String idColumn, Object idValue) {
        this.table = table;
        this.idColumn = idColumn;
        this.idValue = idValue;
    }

    public void set(String field, Object value) {
        fields.add(field);
        values.add(value);
    }

    @Override
    public String getSql() {

        StringBuilder sb = new StringBuilder("UPDATE ").append(table).append(" SET ");

        final int size = fields.size();
        for (int i = 0; i < size; i++)
            sb.append(fields.get(i)).append(" = ?, ");

        sb.delete(sb.length() - 2, sb.length());

        sb.append(" WHERE ");
        sb.append(idColumn).append(" = ? ");
        return sb.toString();
    }

    @Override
    public int getParameterCount() {
        return values.size() + 1; //table id
    }

    @Override
    public Object getParameter(int index) {
        return getValue(index);
    }

    private Object getValue(int index) {
        if (index <= values.size() -1) {
            return values.get(index);
        } else {
            return idValue;
        }
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("UpdateCommand[table=");
        sb.append(table);
        sb.append(",fields=");
        sb.append(fields);
        sb.append(",values=");
        sb.append(values);
        sb.append(",idColumn=");
        sb.append(idColumn);
        sb.append(",idValue=");
        sb.append(idValue);
        sb.append("]");

        return sb.toString();
    }

}