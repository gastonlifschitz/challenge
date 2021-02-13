package application.services;

import java.util.List;

public class MessageService {
    public static String completeMessage(List<List<String>> messages){
        StringBuilder sentence = new StringBuilder();
        String[] fullMessage = new String[maxSize(messages)];
        for(List<String> message: messages){
            for(int i = 0;i<message.size();i++){
                if(!message.get(i).equals("") && message.get(i) != null)
                    fullMessage[i] = message.get(i);
            }
        }
        for (String s : fullMessage) {
            if (s != null)
                sentence.append(s).append(" ");
        }
        return sentence.toString();
    }

    public static int maxSize(List<List<String>> messages) {
        int max = messages.get(0).size();
        for(int i = 1;i<messages.size();i++){
            if(messages.get(i).size()>max)
                max = messages.get(i).size();
        }
        return max;
    }
}
