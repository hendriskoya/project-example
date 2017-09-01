package com.teste;
public interface SqlCommand {

    String getSql();

    int getParameterCount();

    Object getParameter(int index);
    

}
