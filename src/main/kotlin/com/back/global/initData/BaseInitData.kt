package com.back.global.initData

import com.back.domain.member.member.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationRunner
import org.springframework.cache.annotation.Cacheable
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Lazy
import org.springframework.transaction.annotation.Transactional

@Configuration
class BaseInitData(
    private val memberService: MemberService
) {
    @Autowired
    @Lazy
    lateinit var self: BaseInitData

    @Bean
    fun baseInitDataApplicationRunner(): ApplicationRunner {
        return ApplicationRunner {
            self.work1()
        }
    }

    @Transactional
    fun work1() {
        if (memberService.count() == 0L) {
            memberService.save("admin", "1234", "관리자")
        }

        self.get1Plus1()
        self.get1Plus1()
        self.get1Plus1()
        self.get1Plus1()
        self.get1Plus1()

    }

    @Cacheable("get1Plus1")
    fun get1Plus1(): Int {
        println("get1Plus1 run!")
        return 1 + 1
    }
}