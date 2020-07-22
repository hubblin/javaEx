package Code9.Code9.src;

/*클래스는 항상 같이 붙어다녀야 하는 데이터를 뭉치는 것이다.
서로 관련있는 데이터들을 하나의 단위로 묶어두면 편한 것이다.


프리미티브 타입이 아닌 변수는 모두 참조변수다
*/
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Persion1 first;
        //first는 새로 만들어진 Persion1형의 데이터가 저장되어 있는 주소를 저장한다.
        first = new Persion1();

        first.name = "John";
        first.number="0102483120";

        System.out.println("name: " + first.name + ", Number: " + first.number);
        
        Persion1 second;
        second = first;
        second.name = "Tom";
        //이렇게 되면 결국 first와 같은 주소를 가지는 변수가 된다.
        //객체는 오로지 new에 의해서만 만들어진다. <-- 동시참조
        System.out.println("name: " + first.name + ", Number: " + first.number);

        System.out.println("name: " + second.name + ", Number: " + second.number);
        
        

        Persion1[] members = new Persion1[100];
        members[0] = first;
        members[1] = new Persion1();
        members[1].name = "David";
        members[1].number = "2873548327458";
        members[1] = second;
        System.out.println(members[0].name+ "," + members[0].number);
        System.out.println(members[1].name+ "," + members[1].number);
        members[2] = new Persion1();
        members[2].name = "David";
        members[2].number = "2376457264";
        /*
        배열에 관한 이야기를 한다.
        배열의 이름을 지정하는 일과, 배열을 생성하는 일을 해줘야 한다고 했는데
        primifive type이라는 것은 int, short등 만이 그것이고 배열도 프리미티브 타입이 아니다.
        실질적인 내용을 담은것이 객체고, 변수명은 그 객체를 가리키는 참조변수이다.

        */
    }
}
