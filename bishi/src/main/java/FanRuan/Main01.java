package FanRuan;

public class Main01 {
    public String render (String tpl, String name, int age) {
        // write code here
        return tpl.replace("{{name}}",name).replace("{{age}}",age+"");
    }
}
