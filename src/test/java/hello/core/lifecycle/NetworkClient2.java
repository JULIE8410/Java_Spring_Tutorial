package hello.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient2 {

    private String url;

    public NetworkClient2() {
        System.out.println("Calling constructor url = " + url);

    }

    public void setUrl(String url) {
        this.url = url;
    }

    // It is called when starting service
    public void connect(){
        System.out.println("connect " + url);
    }

    public void call(String message){
        System.out.println("call " + url + " message = " + message);
    }

    // called when exit service
    public void disconnect(){
        System.out.println("close " + url);
    }

    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("Initial connection message");
    }

    @PreDestroy
    public void close()  {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
