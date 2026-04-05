package practice.ch06;

import practice.ch06.MessageBox;

public class Main {
    public static void main(String[] args) {
        MessageBox mbox1 = new MessageBox('*');
        mbox1.use("Hello, world.");

        mbox1.createCopy().use("Hello, world.");
        //mbox1.clone(); - 이거는 못한다. 자기 자신과 하위만 클론 가능 
    }
}

