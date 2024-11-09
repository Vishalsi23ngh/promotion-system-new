package com.example.promotion.System.Controller;


import com.example.promotion.System.Service.UserHistoryService;
import com.example.promotion.System.dto.requestDto.UserHistoryRequest;
import com.example.promotion.System.model.UserHistory;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/history")
public class UserHistoryController {

    private final UserHistoryService userHistoryService;

    @PostMapping("/addHistory")
    @Operation(summary = "adding  the user history using this api ", description = " we require the userId and productId and using this id we get the user and product and set the product to user ")
    public ResponseEntity<String> addUserSearchHistory(@RequestBody UserHistoryRequest userHistoryRequest){
        String response = userHistoryService.addUserHistory(userHistoryRequest);
        return new ResponseEntity<>(response ,HttpStatus.CREATED );
    }

    @GetMapping("/getHistory")
    @Operation(summary = "getting the user History using this end-point ", description = "require user id to fetch the history for  the particular user")
    public  List<UserHistory> getUserHistory(@RequestParam Integer userId){
        return userHistoryService.getPromotionBasedOnPastHistory(userId);
    }
}
