package pack6;

import pack5.*;

class DefaultB {
    public static void main(String[] args) {
        DefaultA obj = new DefaultA(); // CompileTimeError
        obj.msg(); // CompileTimeError
    }
}