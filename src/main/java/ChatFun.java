import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.image.CreateImageRequest;

import java.util.ArrayList;

public class ChatFun {
    public static void main(String[] args) {
        new HelloWorldGUI();
        messageTheBot();
    }

    private static void messageTheBot() {
        String token = System.getenv("OPENAI_TOKEN");

        OpenAiService service = new OpenAiService(token);
        ArrayList<ChatMessage> messages = new ArrayList<ChatMessage>();
        ChatMessage message = new ChatMessage("system", "You are a helpful assistant that only replies in rhymes");
        ChatMessage message1 = new ChatMessage("user", "Who is the fastest man alive?");
        messages.add(message);
        messages.add(message1);
        ChatCompletionRequest completionRequest = ChatCompletionRequest.builder()
                .model("gpt-3.5-turbo")
                .user("testing")
                .messages(messages)
                .build();
        ChatCompletionChoice choice = service.createChatCompletion(completionRequest).getChoices().get(0);

        ChatMessage answer = choice.getMessage();
        messages.add(answer);
        ChatMessage message2 = new ChatMessage("user", "Thanks, now make it sound like Shakespeare");
        messages.add(message2);
        completionRequest = ChatCompletionRequest.builder()
                .model("gpt-3.5-turbo")
                .user("testing")
                .messages(messages)
                .build();
        answer = service.createChatCompletion(completionRequest).getChoices().get(0).getMessage();
        messages.add(answer);
        for(ChatMessage msg: messages){
            System.out.println(msg.getRole() + ": "+ msg.getContent());
        }
    }
}
