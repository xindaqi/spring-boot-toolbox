// package basic.datatype.datatest;

// import java.util.ArrayList;
// import java.util.Iterator;
// import java.util.List;
// import java.util.ListIterator;
// import java.util.Map;
// import java.util.HashMap;

// public class ListTest{
//     List<String> infos = new ArrayList<String>();
//     List<String> works = new ArrayList<String>();
//     List<String> temps = new ArrayList<String>();

//     public void addTest(String name, String address, String sex){
//         infos.add(name);
//         infos.add(address);
//         infos.add(sex);
//         System.out.format("add--infos: "+infos+"\n");
//     }

//     public void addAllTest(String occupation, String technology){
//         works.add(occupation);
//         works.add(technology);
//         System.out.format("addAll--before: "+works+"\n");
//         infos.addAll(2, works);
//         System.out.format("addAll--after: "+infos+"\n");
//     }

//     public void sizeTest(){
//         int size = infos.size();
//         System.out.format("size--infos size: "+size+"\n");
//     }

//     public void getTest(){
//         Object obj = infos.get(2);
//         System.out.format("get--infos: "+obj+"\n");
//     }

//     public void indexOfTest(){
//         int i = infos.indexOf("shenzhen");
//         System.out.format("indexOf--infos position: "+i+"\n");
//     }

//     public void iteratorTest(){
//         Iterator<String> its = infos.iterator();
//         System.out.format("-----iterator------\n");
//         while(its.hasNext()){
//             String value = its.next();
//             System.out.format("infos value: "+value+"\n");
//         }
//         System.out.format("-------------------------\n");
//     }

//     public void listIteratorTest(){
//         ListIterator<String> lits = infos.listIterator();
//         System.out.format("-----list iterator------\n");
//         while(lits.hasNext()){
//             String value = lits.next();
//             System.out.format("infos value: "+value+"\n");
//         }
//         System.out.format("-------------------------\n");
//     }

//     public void removeTest(){
//         System.out.format("remove--before values: "+infos+"\n");
//         System.out.format("remvoe--values: "+infos.remove(2)+"\n");
//         System.out.format("remove--after values: "+infos+"\n");
//     }

//     public void setTest(){
//         System.out.format("set--before values: "+infos+"\n");
//         System.out.format("set--values: "+infos.set(2, "hebei")+"\n");
//         System.out.format("set--after values: "+infos+"\n");
//     }

//     public void subListTest(){
//         temps = infos.subList(1, 3);
//         System.out.format("subList--values: "+temps+"\n");
//     }

//     public List listIteratorMix(){
//         List infos = new ArrayList();
//         Map item = new HashMap();
//         Map tempMap = new HashMap();
//         tempMap.put("name", "xiaohong");
//         tempMap.put("address", "shenzhen");
//         item.put("count", 10);
//         item.put("infos", tempMap);
//         infos.add(item);
//         // infos.add(tempMap);
//         return infos;
//     }
//     public void listDataAdd(){
//         String[] weeks = {"1", "2", "3"};
//         List<String>
//     }

//     public static void main(String[] args){
//         ListTest listTest = new ListTest();
//         listTest.addTest("xiaohong", "shenzhen", "sex");
//         listTest.addAllTest("AI Enginner", "techonlogy");
//         listTest.sizeTest();
//         listTest.getTest();
//         listTest.indexOfTest();
//         listTest.iteratorTest();
//         listTest.listIteratorTest();
//         listTest.removeTest();
//         listTest.setTest();
//         listTest.subListTest();
//         List infos = listTest.listIteratorMix();
//         System.out.format("infos list:"+infos.get(0)+"\n");
//         Map inside = (Map)infos.get(0);

//         System.out.format("list inside data: "+inside.get("count")+"\n");
//         // for (int i=0;i < infos.size();i++){
//         //     Map info = (Map)infos.get(i);
//         //     System.out.format("info"+info+"\n");
//         // }
//     }
// }