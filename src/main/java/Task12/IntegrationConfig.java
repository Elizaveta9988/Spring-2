package Task12;


@Configuration
public class IntegrationConfig {


    @Bean
    public MessageChannel textInputChanel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel fileWriterChanel() {
        return new DirectChannel();
    }

    @Bean
    @Transformer(inputChannel = "textInputChanel", outputChannel = "fileWriterChanel")
    public GenericTransformer<String, String> mainTransformer() {
        return text -> {
            //какая-то логика
            return text;
        };
    }

    @Bean
    @ServiceActivator(inputChannel = "fileWriterChanel")
    public FileWritingMessageHandler messageHandler() {
        FileWritingMessageHandler handler =
                new FileWritingMessageHandler(new File(
                        "/Users/logeyko/IdeaProjects/Spring_HW12/Files"));
        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);

        return handler;
    }
}