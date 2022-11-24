package com.xquare.v1serviceattachment.domain.entity

import com.github.f4b6a3.uuid.UuidCreator
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "tbl_attachment")
@Entity
class FeedAttachment(

    @Id
    @Column(columnDefinition = "BINARY(16)", nullable = false)
    val id: UUID = UuidCreator.getTimeOrderedEpoch(),

    @Column(columnDefinition = "BINARY(16)", nullable = false)
    val attachedId: UUID,

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    val fileName: String,

    @Column(columnDefinition = "VARCHAR(1024)", nullable = false)
    val filePath: String
)
