package basic.datatype.datatest;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class ParamTransfer{
    public String name;
    public Map<String, String> relationships = new HashMap<String, String>();
    public List<String> family = new ArrayList<String>();

    public ParamTransfer(){};

    public ParamTransfer(String name){
        System.out.format("name: " + name);
    }
}