package com.back.controller

import com.back.domain.member.member.service.MemberService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController(private val memberService: MemberService) {

    @GetMapping("/")
    fun main() = "회원 수 : ${memberService.count()}"
}