import java.util.*;
class Student_1 implements Comparable<Student_1> {
    String name;
    int ban;
    int no;
    int kor, eng, math;
    Student_1(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
    int getTotal() {
        return kor+eng+math;
    }
    float getAverage() {
        return (int)((getTotal()/ 3f)*10+0.5)/10f;
    }
    public String toString() {
        return name +","+ban +","+no +","+kor +","+eng +","+math+","+getTotal() +","+getAverage();
    }
    @Override
    public int compareTo(Student_1 o){
        if (this.name.charAt(0) > o.name.charAt(0)){
            return 1;
        } else if (this.name.charAt(0) == o.name.charAt(0)) {
            return 0;
        } else{
            return -1;
        }
    }
}



public class ex11_5 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Student_1("홍길동",1,1,100,100,100));
        list.add(new Student_1("남궁성",1,2,90,70,80));
        list.add(new Student_1("김자바",1,3,80,80,90));
        list.add(new Student_1("이자바",1,4,70,90,70));
        list.add(new Student_1("안자바",1,5,60,100,80));
        Collections.sort(list);
        Iterator it = list.iterator();
        while(it.hasNext())
            System.out.println(it.next());
    }
}


