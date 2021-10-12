package hello.core.lifecycle;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("Calling constructor url = " + url);
        connect();
        call("Initial connection message");
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

}
