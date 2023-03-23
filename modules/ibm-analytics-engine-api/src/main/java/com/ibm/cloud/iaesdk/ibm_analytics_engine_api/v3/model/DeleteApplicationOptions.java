/*
 * (C) Copyright IBM Corp. 2023.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.cloud.iaesdk.ibm_analytics_engine_api.v3.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The deleteApplication options.
 */
public class DeleteApplicationOptions extends GenericModel {

  protected String instanceId;
  protected String applicationId;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String applicationId;

    /**
     * Instantiates a new Builder from an existing DeleteApplicationOptions instance.
     *
     * @param deleteApplicationOptions the instance to initialize the Builder with
     */
    private Builder(DeleteApplicationOptions deleteApplicationOptions) {
      this.instanceId = deleteApplicationOptions.instanceId;
      this.applicationId = deleteApplicationOptions.applicationId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param instanceId the instanceId
     * @param applicationId the applicationId
     */
    public Builder(String instanceId, String applicationId) {
      this.instanceId = instanceId;
      this.applicationId = applicationId;
    }

    /**
     * Builds a DeleteApplicationOptions.
     *
     * @return the new DeleteApplicationOptions instance
     */
    public DeleteApplicationOptions build() {
      return new DeleteApplicationOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the DeleteApplicationOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the applicationId.
     *
     * @param applicationId the applicationId
     * @return the DeleteApplicationOptions builder
     */
    public Builder applicationId(String applicationId) {
      this.applicationId = applicationId;
      return this;
    }
  }

  protected DeleteApplicationOptions() { }

  protected DeleteApplicationOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.applicationId,
      "applicationId cannot be empty");
    instanceId = builder.instanceId;
    applicationId = builder.applicationId;
  }

  /**
   * New builder.
   *
   * @return a DeleteApplicationOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the instanceId.
   *
   * Identifier of the instance to which the application belongs.
   *
   * @return the instanceId
   */
  public String instanceId() {
    return instanceId;
  }

  /**
   * Gets the applicationId.
   *
   * Identifier of the application that needs to be stopped.
   *
   * @return the applicationId
   */
  public String applicationId() {
    return applicationId;
  }
}

