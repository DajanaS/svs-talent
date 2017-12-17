package com.controllers;

import com.MemberService;
import com.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Controller
@RequestMapping("/members")
public class MemberController {

    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    @ResponseBody
    public List<Member> findMembers() {
        return memberService.findMembers();
    }

    @PostMapping
    @ResponseBody
    public void createMember(@RequestBody Member member) {
        memberService.createMember(member);
    }
}
// extension za Chrome: Postman
// nov req na http://localhost:8080/members, nema headeri, body: raw Text->JSON(application/json)
// { "atribut": "vrednost" } Spring sam naogja kontroler, req go parsira i naogja instanca i postavuva polinja