// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.microsoft.bot.builder;

import com.microsoft.bot.schema.Activity;
import org.joda.time.DateTime;

import java.util.concurrent.CompletableFuture;

/**
 * Transcript logger stores activities for conversations for recall.
 */
public interface TranscriptStore extends TranscriptLogger {

    /**
     * Gets from the store activities that match a set of criteria.
     *
     * @param channelId         The ID of the channel the conversation is in.
     * @param conversationId    The ID of the conversation.
     * @return A task that represents the work queued to execute.
     * If the task completes successfully, the result contains the matching activities.
     */
    default CompletableFuture<PagedResult<Activity>> getTranscriptActivitiesAsync(String channelId,
                                                                                  String conversationId) {
        return getTranscriptActivitiesAsync(channelId, conversationId, null);
    }

    /**
     * Gets from the store activities that match a set of criteria.
     *
     * @param channelId         The ID of the channel the conversation is in.
     * @param conversationId    The ID of the conversation.
     * @param continuationToken
     * @return A task that represents the work queued to execute.
     * If the task completes successfully, the result contains the matching activities.
     */
    default CompletableFuture<PagedResult<Activity>> getTranscriptActivitiesAsync(String channelId,
                                                                          String conversationId,
                                                                          String continuationToken) {
        return getTranscriptActivitiesAsync(channelId, conversationId, continuationToken, DateTime.now());
    }

    /**
     * Gets from the store activities that match a set of criteria.
     *
     * @param channelId         The ID of the channel the conversation is in.
     * @param conversationId    The ID of the conversation.
     * @param continuationToken
     * @param startDate         A cutoff date. Activities older than this date are not included.
     * @return A task that represents the work queued to execute.
     * If the task completes successfully, the result contains the matching activities.
     */
    CompletableFuture<PagedResult<Activity>> getTranscriptActivitiesAsync(String channelId,
                                                                          String conversationId,
                                                                          String continuationToken,
                                                                          DateTime startDate);

    /**
     * Gets the conversations on a channel from the store.
     *
     * @param channelId         The ID of the channel.
     * @return A task that represents the work queued to execute.
     */
    default CompletableFuture<PagedResult<TranscriptInfo>> listTranscriptsAsync(String channelId) {
        return listTranscriptsAsync(channelId, null);
    }

    /**
     * Gets the conversations on a channel from the store.
     *
     * @param channelId         The ID of the channel.
     * @param continuationToken
     * @return A task that represents the work queued to execute.
     */
    CompletableFuture<PagedResult<TranscriptInfo>> listTranscriptsAsync(String channelId, String continuationToken);

    /**
     * Deletes conversation data from the store.
     *
     * @param channelId      The ID of the channel the conversation is in.
     * @param conversationId The ID of the conversation to delete.
     * @return A task that represents the work queued to execute.
     */
    CompletableFuture<Void> deleteTranscriptAsync(String channelId, String conversationId);
}