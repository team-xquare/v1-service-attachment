package com.xquare.v1serviceattachment.domain.entity.repository

import com.xquare.v1serviceattachment.domain.entity.FeedAttachment
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface FeedAttachmentRepository : CrudRepository<FeedAttachment, UUID>
