package com.xquare.v1serviceattachment.domain.entity

import com.fasterxml.uuid.Generators
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class FeedAttachment(

    @Id
    @Column(columnDefinition = "BINARY(16)", nullable = false)
    val id: UUID = Generators.timeBasedGenerator().generate(),

    @Column(columnDefinition = "BINARY(16)",nullable = false)
    val feedId: UUID,

    @Column(columnDefinition = "VARCHAR(255)",nullable = false)
    val fileName: String
)
