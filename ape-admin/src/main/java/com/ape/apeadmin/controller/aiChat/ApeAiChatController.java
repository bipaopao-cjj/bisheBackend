package com.ape.apeadmin.controller.aiChat;

import com.ape.apecommon.annotation.Log;
import com.ape.apecommon.domain.Result;
import com.ape.apecommon.enums.BusinessType;
import com.ape.apesystem.service.ApeAiChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/ai")
@CrossOrigin
public class ApeAiChatController {
    @Autowired
    private ApeAiChatService aiChatService;

    @Log(name = "ai聊天返回对话", type = BusinessType.OTHER)
    @PostMapping("/chat")
    public Result chat(@RequestBody Map<String,String> payload) {
        String prompt = payload.get("prompt");
        String result = aiChatService.getAnswer(prompt);
        return Result.success(result);
    }
}
