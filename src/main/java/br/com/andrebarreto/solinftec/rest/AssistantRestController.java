package br.com.andrebarreto.solinftec.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.andrebarreto.solinftec.dto.ConversationDTO;
import br.com.andrebarreto.solinftec.service.AssitantService;

@RestController
@RequestMapping("/api/v1/assistant/")
public class AssistantRestController {

	@Autowired
    private AssitantService assistantService;

	@PostMapping()
    @ResponseStatus(HttpStatus.OK)
    ConversationDTO send(@RequestBody ConversationDTO conversation) {
       return this.assistantService.send(conversation);
    }

}
