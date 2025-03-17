package com.back.global.jpa.entity

import BaseEntity
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@EntityListeners(AuditingEntityListener::class)
@MappedSuperclass
abstract class BaseTime : BaseEntity() {
    @CreatedDate
    lateinit var createdDate: LocalDateTime

    @LastModifiedDate
    lateinit var modifyDate: LocalDateTime

    fun setCreateDateNow() {
        this.createdDate = LocalDateTime.now()
        this.modifyDate = createdDate
    }
}