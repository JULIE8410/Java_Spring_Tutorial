package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){

    }

    public void logic(){
        System.out.println("Call a singleton object");
    }

    public static void main(String[] args) {
        SingletonService singletonService = new SingletonService();

    }

}
