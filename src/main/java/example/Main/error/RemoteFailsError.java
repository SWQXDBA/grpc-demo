package example.Main.error;

public class RemoteFailsError extends RuntimeException {
    public RemoteFailsError(String message) {
        this.message = message;
    }

    public String message;

}
