package Task12;


@MessagingGateway(defaultRequestChannel = "textInputChanel")
public interface FileGateway {
    void writeToFile(@Header(FileHeaders.FILENAME) String filename, String data);
}
