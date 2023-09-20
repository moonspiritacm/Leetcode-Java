public class Application {
    public static void main(String[] args) {
        System.out.println("Hello World！");
        System.out.println("Java 版本：" + System.getProperty("java.version"));
        System.out.println("Java 虚拟机版本：" + System.getProperty("java.vm.version"));
        System.out.println("Java 虚拟机规范版本：" + System.getProperty("java.vm.specification.version"));
    }
}