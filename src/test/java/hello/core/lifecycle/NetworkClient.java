package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean {

    private String url;

    public NetworkClient() {
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

    @Override
    public void afterPropertiesSet() {
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("Initial connection message");
    }

    @Override
    public void destroy() {
        System.out.println("NetworkClient.destroy");
        disconnect();
    }
}
