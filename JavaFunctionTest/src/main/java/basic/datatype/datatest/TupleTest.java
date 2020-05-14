package basic.datatype.datatest;

import basic.datatype.util.TwoTuple;

public class TupleTest{
    static TwoTuple<String, Integer> f(){
        return new TwoTuple<String, Integer>("test tuple", 250);
    }
    public static void main(String[] args){
        // Pair<>
        TwoTuple<String, Integer> tupleTest = f();
        System.out.format("tuple"+tupleTest+"\n");
        System.out.format("test data"+"\n");
    }
}