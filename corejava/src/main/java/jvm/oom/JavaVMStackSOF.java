package jvm.oom;

/**
 * VM Args：-Xss128k
 *
 * @author zzm
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("Stack length:" + oom.stackLength);
            throw e;
        }
    }

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }
}

