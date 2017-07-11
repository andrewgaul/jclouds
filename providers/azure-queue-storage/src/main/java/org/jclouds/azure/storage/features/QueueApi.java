/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jclouds.azure.storage.features;

import org.jclouds.azure.storage.domain.CreateQueueResponse;
import org.jclouds.azure.storage.domain.ListQueueResponse;
import org.jclouds.azure.storage.filters.SharedKeyLiteAuthentication;
import org.jclouds.rest.annotations.RequestFilters;

import javax.inject.Named;
import javax.ws.rs.*;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;

@RequestFilters(SharedKeyLiteAuthentication.class)
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_XML)
public interface QueueApi {

    @Named("azure_storage_queue_create")
    @PUT
    @Path("/{queueName}")
    CreateQueueResponse create(@PathParam("queueName") String queueName);

    @Named("azure_storage_queue_list")
    @GET
    @Path("/?comp=list")
    ListQueueResponse list();

}
