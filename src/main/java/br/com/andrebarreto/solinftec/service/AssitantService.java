package br.com.andrebarreto.solinftec.service;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ibm.cloud.sdk.core.service.security.IamOptions;
import com.ibm.watson.assistant.v1.Assistant;
import com.ibm.watson.assistant.v1.model.Context;
import com.ibm.watson.assistant.v1.model.MessageInput;
import com.ibm.watson.assistant.v1.model.MessageOptions;
import com.ibm.watson.assistant.v1.model.MessageResponse;

import br.com.andrebarreto.solinftec.dto.ConversationDTO;

@Service
public class AssitantService {
	
	private Context context;

	public ConversationDTO send(ConversationDTO conversation) {
		IamOptions iamOptions = new IamOptions.Builder().apiKey("bQEkr98ii9OIbRpsUYcYiiJ9NTtty-sgJYECpEQho_w3").build();
		Assistant service = new Assistant("2019-02-28", iamOptions);
		service.setEndPoint("https://gateway.watsonplatform.net/assistant/api");

		String workspaceId = "c10d290d-0b15-4a95-8369-9bfe807ad9eb";

		MessageInput input = new MessageInput();
		input.setText(conversation.getMessage());

		MessageOptions options = new MessageOptions.Builder(workspaceId)
		  .input(input)
		  .context(context)
		  .build();
		  
		MessageResponse response = service.message(options).execute().getResult();

		  context = response.getContext();
		  
		return ConversationDTO.builder()
				.message(response.getOutput().getText().stream().reduce("", String::concat))
				.build();
	}

}
